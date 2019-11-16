package com.example.demo.controller;

import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieController {

        public static void setCookie(String name, String value, int expiry) {

            boolean cookieFound = false;
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

            for (Cookie cookie: request.getCookies()) {
                if (cookie.getName().equals(name)) {
                    cookie.setValue(value);
                    cookie.setMaxAge(expiry);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    cookieFound = true;
                }
            }

            if (!cookieFound) {
                Cookie cookie = new Cookie(name, value);
                cookie.setMaxAge(expiry);
                cookie.setMaxAge(expiry);
                cookie.setPath("/");
                response.addCookie(cookie);
            }

            System.out.println("Cookie " + name + " set to " + value);


        }

        public static String getNameStoredInCookie() {


            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            Cookie[] cookies = request.getCookies();

            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    // System.out.println("Name: " + cookie.getName() + "Value: " + cookie.getValue());
                    if (cookie.getName().equals("name")) {
                        return cookie.getValue();
                    }
                }
            }

            return null;

        }


        public static int getLoggedInIndex() {


            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            Cookie[] cookies = request.getCookies();


            for (Cookie cookie : cookies) {
                //System.out.println("Name: " + cookie.getName() + " Value: " + cookie.getValue());
                if (cookie.getName().equals("id")) {

                    return Integer.parseInt(cookie.getValue());
                }
            }

            return -1;

        }
    }

