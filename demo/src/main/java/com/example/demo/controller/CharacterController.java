package com.example.demo.controller;

import com.example.demo.database.DatabaseHandler;
import com.example.demo.model.Character;
import com.example.demo.model.Item;

import javax.inject.Named;
import java.net.CookieHandler;
import java.util.ArrayList;

@Named
public class CharacterController {

    private static ArrayList<Character> loggedInUsers = new ArrayList<>();

    public static int getLoggedInUsersCounter() {
        return LoginHandler.getLoginCounter() + RegisterHandler.getRegisterCounter();
    }

    public static ArrayList<Character> getLoggedInUsers() {
        return loggedInUsers;
    }

    public void growDexBy(int value) {
        int cash = CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getCash();
        int cost = CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getDexCost();
        if (cash>=cost){
            CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).setCash(cash-cost);
            DatabaseHandler.updateUser(CookieController.getNameStoredInCookie(), "cash",
                    CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getCash()
                    );
            int toUpdate = CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getDex() + value;
            CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).setDex(toUpdate);
            DatabaseHandler.updateUser(CookieController.getNameStoredInCookie(), "dex", toUpdate);
            DatabaseHandler.updateUser(CookieController.getNameStoredInCookie(), "exp",
                    CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getExp()
            );
        }
    }

    public void growIntelBy(int value) {
        int cash = CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getCash();
        int cost = CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getIntelCost();
        if (cash>=cost) {
            CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).setCash(cash-cost);
            DatabaseHandler.updateUser(CookieController.getNameStoredInCookie(), "cash",
                    CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getCash()
            );
            int toUpdate = CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getIntel() + value;
            CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).setIntel(toUpdate);
            DatabaseHandler.updateUser(CookieController.getNameStoredInCookie(), "intel", toUpdate);
            DatabaseHandler.updateUser(CookieController.getNameStoredInCookie(), "exp",
                    CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getExp()
            );
        }
    }

    public void growConBy(int value) {
        int cash = CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getCash();
        int cost = CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getConCost();
        if (cash>=cost) {
            CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).setCash(cash-cost);
            DatabaseHandler.updateUser(CookieController.getNameStoredInCookie(), "cash",
                    CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getCash()
            );
            int toUpdate = CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getCon() + value;
            CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).setCon(toUpdate);
            DatabaseHandler.updateUser(CookieController.getNameStoredInCookie(), "con", toUpdate);
            DatabaseHandler.updateUser(CookieController.getNameStoredInCookie(), "exp",
                    CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getExp()
            );
        }
    }

    public void growStrBy(int value) {
        int cash = CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getCash();
        int cost = CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getStrCost();
        if (cash>=cost) {
            CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).setCash(cash-cost);
            DatabaseHandler.updateUser(CookieController.getNameStoredInCookie(), "cash",
                    CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getCash()
            );
            int toUpdate = CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getStr() + value;
            CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).setStr(toUpdate);
            DatabaseHandler.updateUser(CookieController.getNameStoredInCookie(), "str", toUpdate);
            DatabaseHandler.updateUser(CookieController.getNameStoredInCookie(), "exp",
                    CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getExp()
            );
        }
    }

    public static void growStatsByItem(Item item) {
        System.out.println("Growing stats by item...");
        System.out.println("Item str: " + item.getStr());

        int toUpdateStr = CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getStr() + item.getStr();
        int toUpdateDex = CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getDex() + item.getDex();
        int toUpdateInt = CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getIntel() + item.getIntel();
        int toUpdateCons = CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getCon() + item.getCons();

        CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).setStr(toUpdateStr);
        CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).setDex(toUpdateDex);
        CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).setIntel(toUpdateInt);
        CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).setCon(toUpdateCons);

        DatabaseHandler.updateUser(CookieController.getNameStoredInCookie(), "str", toUpdateStr);
        DatabaseHandler.updateUser(CookieController.getNameStoredInCookie(), "dex", toUpdateDex);
        DatabaseHandler.updateUser(CookieController.getNameStoredInCookie(), "intel", toUpdateInt);
        DatabaseHandler.updateUser(CookieController.getNameStoredInCookie(), "con", toUpdateCons);

    }

    public static void decreaseStatsByItem(Item item) {
        System.out.println("decreasing stats by item...");
        System.out.println("Item str: " + item.getStr());

        int toUpdateStr = CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getStr() - item.getStr();
        int toUpdateDex = CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getDex() - item.getDex();
        int toUpdateInt = CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getIntel() - item.getIntel();
        int toUpdateCons = CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getCon() - item.getCons();

        CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).setStr(toUpdateStr);
        CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).setDex(toUpdateDex);
        CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).setIntel(toUpdateInt);
        CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).setCon(toUpdateCons);

        DatabaseHandler.updateUser(CookieController.getNameStoredInCookie(), "str", toUpdateStr);
        DatabaseHandler.updateUser(CookieController.getNameStoredInCookie(), "dex", toUpdateDex);
        DatabaseHandler.updateUser(CookieController.getNameStoredInCookie(), "intel", toUpdateInt);
        DatabaseHandler.updateUser(CookieController.getNameStoredInCookie(), "con", toUpdateCons);
    }

    public static Character getCharacterByUserName(String username) {
        for (Character character: loggedInUsers) {
            if (character!=null)
            if (character.getName().equals(username))
                return character;
        }

        return null;
    }



}
