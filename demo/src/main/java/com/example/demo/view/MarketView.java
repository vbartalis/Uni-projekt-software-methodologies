package com.example.demo.view;

import com.example.demo.controller.CharacterController;
import com.example.demo.controller.CookieController;

import javax.inject.Named;

@Named
public class MarketView {

    public int getMarketSlot1() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getMarket().getMarketSlot1();
    }

    public int getMarketSlot2() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getMarket().getMarketSlot2();
    }

    public int getMarketSlot3() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getMarket().getMarketSlot3();
    }


    public int getMarketSlot4() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getMarket().getMarketSlot4();
    }

    public int getMarketSlot5() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getMarket().getMarketSlot5();
    }

    public int getMarketSlot6() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getMarket().getMarketSlot6();
    }


}



