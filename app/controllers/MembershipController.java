package controllers;


import com.google.common.io.Files;
import models.*;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;
import java.io.File;
import java.util.Calendar;
import java.util.List;




public class MembershipController extends Controller
{
    private FormFactory formFactory;
    private JPAApi jpaApi;
    @Inject
    public MembershipController(FormFactory formFactory, JPAApi jpaApi)
    {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
    }
    @Transactional(readOnly = true)

    public Result getFamily(Integer familyId)
    {
        FamilyDetail familyDetail = (FamilyDetail)jpaApi.em().
                            createNativeQuery("SELECT f.FamilyId, f.FamilyName AS Name, f.address, m.phoneNumber, m.email " +
                            "FROM family f JOIN membership m ON f.familyid = m.familyid " +
                            "WHERE f.familyid = :familyId", FamilyDetail.class).
        setParameter("familyId", familyId).
        getSingleResult();

        List<MemberDetail> familyMember = jpaApi.em().
                                        createNativeQuery("SELECT f.familyId, m.membershipid, m.membername, m.birthday " +
                                                "FROM membership m JOIN family f ON m.familyId = f.familyId " +
                                                "WHERE f.familyid = :familyId", MemberDetail.class).
                setParameter("familyId", familyId).
                getResultList();


        return ok(views.html.membership.render(familyDetail, familyMember));

    }
    @Transactional(readOnly = true)
    public Result getNews()
    {
        List<News> news = jpaApi.em().
                createQuery("SELECT n FROM News n", News.class).
                getResultList();
        return ok(views.html.news.render(news));
    }
    @Transactional(readOnly = true)
    public Result getCalendar()
    {
        List<CalendarInfo> calendar = jpaApi.em().
                    createQuery("SELECT c FROM CalendarInfo c", CalendarInfo.class).
                    getResultList();

        return ok(views.html.calendar.render(calendar));
    }

    @Transactional(readOnly = true)

    public Result getFamilypic(Integer familyId)
    {
        FamilyDetail familyDetail = (FamilyDetail) jpaApi.em().
                createNativeQuery("SELECT f.FamilyId, f.FamilyName AS Name, address, phoneNumber, email " +
                        "FROM family f JOIN membership m ON f.familyid = m.familyid " +
                        "WHERE f.familyid = :familyId", FamilyDetail.class).
                setParameter("familyId", familyId).
                getSingleResult();

        List<MemberDetail> familyMember = jpaApi.em().
                createNativeQuery("SELECT f.familyId, m.membershipid, m.memberName, m.birthday " +
                        "FROM Membership m JOIN family f ON m.familyId = f.familyId " +
                        "WHERE f.familyid = :familyId", MemberDetail.class).
                setParameter("familyId", familyId).
                getResultList();
        return ok(views.html.familypic.render(familyDetail, familyMember));
    }
        @Transactional
        public Result postFamilyPic(Integer familyId)
        {
            Http.MultipartFormData<File> formData = request().body().asMultipartFormData();
            Http.MultipartFormData.FilePart<File> filePart = formData.getFile("filename");
            File file = filePart.getFile();

            byte[] picture;

            try
            {
                picture = Files.toByteArray(file);
            }
            catch (Exception e)
            {
                picture = null;
            }

            Family family = jpaApi.em().
                    createQuery("SELECT p FROM Family p WHERE familyId = :id", Family.class).
                    setParameter("id", familyId).
                    getSingleResult();
            if (picture != null)
            {
                family.setPicture(picture);
            }
            jpaApi.em().persist(family);

            return ok("Saved the pic");
        }
        /*public Result getPics()
        {

            return ok(views.html.families.render());
        }*/

        @Transactional(readOnly = true)
        public Result getFamilyPicture(int familyId)
        {
            Family family = jpaApi.em().
                                    createQuery("SELECT p FROM Family p WHERE familyId = :id", Family.class).
                                    setParameter("id", familyId).
                                    getSingleResult();

            if (family.getPicture() == null)
            {
                return null;
            }
            else
            {
                return ok(family.getPicture()).as("image.jpg");
            }

        }
        @Transactional(readOnly = true)
    public Result getChurchFamily()
        {
            List<Family> families = jpaApi.em().createQuery("SELECT f FROM Family f ORDER BY FamilyName, FamilyId").getResultList();
            return ok(views.html.families.render(families));
        }



    }


