package com.example.demo.controller;

import com.example.demo.database.DatabaseHandler;
import com.example.demo.model.Character;

import javax.inject.Named;
import java.net.CookieHandler;

@Named
public class CharacterController {

    public void growDexBy(int value) {
        int toUpdate = Character.getDex() + value;
        Character.setDex(toUpdate);
        DatabaseHandler.updateUser(CookieController.getNameStoredInCookie(), "dex", toUpdate);
    }

    public void growIntelBy(int value) {
        int toUpdate = Character.getIntel() + value;
        Character.setIntel(toUpdate);
        DatabaseHandler.updateUser(CookieController.getNameStoredInCookie(), "intel", toUpdate);
    }

    public void growConBy(int value) {
        int toUpdate = Character.getCon() + value;
        Character.setCon(toUpdate);
        DatabaseHandler.updateUser(CookieController.getNameStoredInCookie(), "con", toUpdate);
    }

    public void growStrBy(int value) {
        int toUpdate = Character.getStr() + value;
        Character.setStr(toUpdate);
        DatabaseHandler.updateUser(CookieController.getNameStoredInCookie(), "str", toUpdate);
    }

    public void growXpBy(int value) {
        int toUpdate = Character.getStr() + value;
        Character.setStr(toUpdate);
        DatabaseHandler.updateUser(CookieController.getNameStoredInCookie(), "str", toUpdate);
    }
}
