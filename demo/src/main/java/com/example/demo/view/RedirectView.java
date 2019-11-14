package com.example.demo.view;

import com.example.demo.controller.RedirectHandler;

import javax.inject.Named;

@Named
public class RedirectView {


    public String redirect() {
        String toRedirect = RedirectHandler.getRedirectSite() + "?faces-redirect=true";
        System.out.println("Redirecting to " + toRedirect);
        return toRedirect;
    }
}
