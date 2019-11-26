package com.example.demo.view;

import com.example.demo.controller.CharacterController;
import com.example.demo.controller.CookieController;
import com.example.demo.model.Character;
import com.example.demo.model.Quest;

import javax.inject.Named;
import java.util.ArrayList;

@Named
public class CharacterView {

    public String getName() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getName();
    }

    public String getImg() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getImg();
    }

    public String getRace() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getRace();
    }

    public int getEnergy() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getEnergy();
    }

    public int getExp() {
        return getDex() + getCon() + getIntel() + getStr();
    }
    public int getCash() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getCash();
    }
    public int getStr() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getStr();
    }
    public int getIntel() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getIntel();
    }
    public int getCon() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getCon();
    }
    public int getDex() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getDex();
    }
    public int getStrCost() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getStrCost();
    }
    public int getIntelCost() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getIntelCost();
    }
    public int getConCost() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getConCost();
    }
    public int getDexCost() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getDexCost();
    }
    public int getHelmet() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getHelmet();
    }
    public int getGloves() {
       return  CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getGloves();
    }
    public int getJew2() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getJew2();
    }
    public int getOutfit() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getOutfit();
    }
    public int getWeapon() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getWeapon();
    }
    public int getJew1() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getJew1();
    }
    public int getInv1() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getInv1();
    }
    public int getInv2() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getInv2();
    }
    public int getInv3() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getInv3();
    }
    public int getInv4() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getInv4();
    }
    public int getInv5() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getInv5();
    }
    public int getInv6() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getInv6();
    }
    public int getInv7() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getInv7();
    }
    public int getInv8() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getInv8();
    }

    public ArrayList<Quest> getRandomizedQuests() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getRandomizedQuests();
    }

    public int getLevel() { return getExp()/10;}

}


