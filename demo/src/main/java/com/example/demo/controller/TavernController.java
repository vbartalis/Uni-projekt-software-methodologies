package com.example.demo.controller;

import com.example.demo.database.DatabaseHandler;
import com.example.demo.model.Character;
import com.example.demo.model.Quest;

import javax.inject.Named;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

@Named
public class TavernController {

    Random randomGenerator = new Random();



    public void startQuest(Quest quest, Character character) {

        System.out.println("Starting quest if it doesn't exist....");

        if (character.isWorking() < 0) {

            System.out.println(character.getName() +  " is tarting quest " + quest.getDescription());
            System.out.println("Working minutes: " + quest.getWorkingMinutes());
            System.out.println("Reward: " + quest.getReward());

            character.setWorking(1);
            DatabaseHandler.updateUser(character.getName(), "is_working", 1);
            DatabaseHandler.updateUser(character.getName(), "quest_id", quest.getId());
            DatabaseHandler.updateUser(character.getName(), "quest_reward", quest.getReward());

            character.setWork_end((System.currentTimeMillis() + quest.getWorkingMinutes() * 60000));
            character.setQuest(quest);
            character.setQuestReward(quest.getReward());
        }
    }

    public void finishQuest(Character character) {
        RedirectHandler.setRedirectSite("tavern");

        if (character.getWork_end() < System.currentTimeMillis() && character.isWorking() > 0) {

            System.out.println(character.getName() + " successfully finished his quest");
            character.setWorking(-1);
            int newCash = character.getCash() + character.getQuestReward();
            character.setCash(newCash);
            DatabaseHandler.updateUser(character.getName(), "cash", newCash);
            RedirectHandler.setRedirectSite("character");

            QuestController.randomizeQuests(character);


        } else {
            System.out.println("Quest is not finished yet.");
        }

    }
}
