package com.example.demo.view;

import com.example.demo.controller.CharacterController;
import com.example.demo.controller.CookieController;
import com.example.demo.controller.QuestController;
import com.example.demo.model.Quest;

import javax.inject.Named;

@Named
public class QuestView {

    public Quest getQuest1() {
        return  CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getRandomizedQuests().get(0);
    }

    public Quest getQuest2(){
        return  CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getRandomizedQuests().get(1);
    }
    public Quest getQuest3() {
        return CharacterController.getLoggedInUsers().get(CookieController.getLoggedInIndex()).getRandomizedQuests().get(2);
    }




}
