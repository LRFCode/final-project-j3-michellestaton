package controllers;


import models.FamilyDetail;
import models.MemberDetail;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;




public class MembershipController extends Controller
{
    private JPAApi jpaApi;
    @Inject
    public MembershipController(JPAApi jpaApi)
    {
        this.jpaApi = jpaApi;
    }
    @Transactional(readOnly = true)

    public Result getFamily(Integer familyId)
    {
        FamilyDetail familyDetail = (FamilyDetail)jpaApi.em().
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
        return ok(views.html.membership.render(familyDetail, familyMember));

    }

    public Result getNews()
    {
        return ok(views.html.news.render());
    }

    public Result getCalendar()
    {
        return ok(views.html.calendar.render());
    }


}
