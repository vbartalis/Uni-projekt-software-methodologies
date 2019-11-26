package com.example.demo.controller;

import com.example.demo.model.Character;

import javax.inject.Named;

@Named
public class LogOutController {

    public void logOut() {

        CookieController.removeCookie("id");
        CookieController.removeCookie("name");
        CharacterController.getLoggedInUsers().set(CookieController.getLoggedInIndex(), null);


        System.out.println("Log out clicked");

        RedirectHandler.setRedirectSite("/login");
    }
}
