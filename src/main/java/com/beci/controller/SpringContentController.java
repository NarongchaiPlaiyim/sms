package com.beci.controller;

import com.beci.model.ProfileModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.annotation.Resource;

@org.springframework.stereotype.Controller
public class SpringContentController {
//    @Autowired ProfileModel profileModel;
    @RequestMapping(value="/springcontent", method= RequestMethod.GET ,produces={"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ProfileModel getUser() {
        System.out.println("getUser()");
        ProfileModel profileModel = new ProfileModel();
        profileModel.setFirstName("Mr. Narongchai");
        profileModel.setLastName("Plaiyim");
        return profileModel;
    }
}
