package com.example.demo.controller;

import com.example.demo.database.DatabaseHandler;
import com.example.demo.model.Character;
import com.example.demo.model.Quest;
import org.hibernate.dialect.Database;

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

        if (character.getEnergy() >= 15) {

            System.out.println("Starting quest if it doesn't exist....");
            System.out.println("is wokring: " + character.isWorking());

            if (character.isWorking() <= 0) {

                System.out.println(character.getName() + " is starting quest " + quest.getDescription());
                System.out.println("Working minutes: " + quest.getWorkingMinutes());
                System.out.println("Reward: " + quest.getReward());

                character.setWorking(1);
                DatabaseHandler.updateUser(character.getName(), "is_working", 1);
                DatabaseHandler.updateUser(character.getName(), "quest_id", quest.getId());
                DatabaseHandler.updateUser(character.getName(), "quest_reward", quest.getReward());

                character.setWork_end(((System.currentTimeMillis() + quest.getWorkingMinutes() * 60000) / 1000));

                DatabaseHandler.updateUser(character.getName(), "work_end", character.getWork_end());
                character.setEnergy(character.getEnergy() - 15);
                DatabaseHandler.updateUser(character.getName(), "energy", character.getEnergy());
                character.setQuest(quest);
                character.setQuestReward(quest.getReward());

            }
        }
    }

    public void finishQuest(Character character) {
        RedirectHandler.setRedirectSite("tavern");
        System.out.println("Current user: " + CookieController.getNameStoredInCookie());

        System.out.println("Work end: " + character.getWork_end());
        System.out.println("Is working: " + character.isWorking());

        if (character.getWork_end()*1000 < System.currentTimeMillis() && character.isWorking() > 0) {

            System.out.println(character.getName() + " successfully finished his quest");
            character.setWorking(-1);
            character.setQuestId(-1);

            int newCash = character.getCash() + character.getQuestReward();
            character.setCash(newCash);
            DatabaseHandler.updateUser(character.getName(), "cash", newCash);
            DatabaseHandler.updateUser(character.getName(), "quest_reward", 0);
            DatabaseHandler.updateUser(character.getName(), "is_working", -1);
            DatabaseHandler.updateUser(character.getName(), "quest_id", -1);
            RedirectHandler.setRedirectSite("character");

            QuestController.randomizeQuests(character);


        } else {
            System.out.println("Quest is not finished yet.");
        }

    }
}
