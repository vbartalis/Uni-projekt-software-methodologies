package com.example.demo.view;

import com.example.demo.controller.RedirectHandler;

import javax.inject.Named;

@Named
public class RedirectView {


    public String redirect() {
        System.out.println("Redirecting to " + RedirectHandler.getRedirectSite() + "...");
        return RedirectHandler.getRedirectSite();
    }
}
