package com.example.demo.view;

import com.example.demo.controller.CharacterController;
import com.example.demo.controller.CookieController;

import javax.inject.Named;

@Named
public class LuckView {

    public int getCash()
    {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getCash();
    }
}
