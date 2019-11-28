package com.example.demo.view;

import com.example.demo.controller.CharacterController;
import com.example.demo.controller.CookieController;

import javax.inject.Named;

@Named
public class ArenaView {
    public String getEnemyName() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getEnemy().getName();
    }

    public int getEnemyCash() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getEnemy().getCash();
    }

    public int getEnemyLevel() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getEnemy().getLevel();
    }
    public int getPlayerCash() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getCash();
    }
}
