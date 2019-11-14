package com.example.demo.view;

import com.example.demo.controller.CookieController;

import javax.inject.Named;

@Named
public class CookieView {

    public String getNameStoredInCookie() {
        return CookieController.getNameStoredInCookie();
    }
}
