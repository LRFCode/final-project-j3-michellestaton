package controllers;


import models.FamilyDetail;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;


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
        return ok(views.html.membership.render(familyDetail));

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
