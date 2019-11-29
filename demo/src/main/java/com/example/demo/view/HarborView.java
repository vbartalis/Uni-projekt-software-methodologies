package com.example.demo.view;

import com.example.demo.controller.CharacterController;
import com.example.demo.controller.CookieController;

import javax.inject.Named;
@Named
public class HarborView {
    public String getHarborEnemyName() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getHarbor().getHarborEnemyName();
    }

    public int getHarborEnemyCash() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getHarbor().getHarborEnemyCash();
    }

    public int getHarborEnemyLevel() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getHarbor().getHarborEnemyLvl();
    }
    public String getHarborEnemyImage() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getHarbor().getHarborEnemyImage();
    }

    public String getHarborEnemyRace() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getHarbor().getHarborEnemyRace();
    }
    public int getHarborPlayerCash() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getCash();
    }
}
