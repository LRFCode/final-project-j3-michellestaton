package controllers;

import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.mvc.Controller;

import javax.inject.Inject;

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



}
