package com.example.demo.controller;

import com.example.demo.model.Character;
import com.example.demo.model.Quest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

public class QuestController {

    private static ArrayList<Quest> quests = new ArrayList<>();
    private static Random randomGenerator = new Random();

    public static ArrayList<Quest> getQuests() {
        return quests;
    }

    public static void setQuests(ArrayList<Quest> quests) {
        System.out.println("Setting quests...");
        QuestController.quests = quests;

    }

    public static void randomizeQuests(Character character) {
        System.out.println("Randomizing quests for " + character.getName());
        ArrayList<Quest> random = new ArrayList<>();
        Collections.shuffle(quests);
        int workingMinute;
        long workEnd;

        if (character.isWorking() > 0) {
            System.out.println("Already doing quest...");

            Quest quest1 = new Quest(character.getQuestId(), getDescriptionById(character.getQuestId()));
            quest1.setReward(character.getQuestReward());
            quest1.setWorkingMinutes(0);
            quest1.setFinishTime( new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date(character.getWork_end())));
            random.add(quest1);
        }

        else {
                Quest quest1 = new Quest(quests.get(0).getId(), quests.get(0).getDescription());
                quest1.setReward(generateReward(character));
                workingMinute = generateWorkingMinute(character);
                quest1.setWorkingMinutes(workingMinute);
                workEnd = System.currentTimeMillis() + workingMinute * 60000;
                quest1.setFinishTime(new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date(workEnd)));
                random.add(quest1);
        }

        Quest quest2 = new Quest(quests.get(1).getId(), quests.get(1).getDescription());
        quest2.setReward(generateReward(character));
        workingMinute = generateWorkingMinute(character);
        quest2.setWorkingMinutes(workingMinute);
        workEnd = System.currentTimeMillis() + workingMinute * 60000;
        quest2.setFinishTime( new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date(workEnd)));
        random.add(quest2);

        Quest quest3 = new Quest(quests.get(2).getId(), quests.get(2).getDescription());
        quest3.setReward(generateReward(character));
        workingMinute = generateWorkingMinute(character);
        quest3.setWorkingMinutes(workingMinute);
        workEnd = System.currentTimeMillis() + workingMinute * 60000;
        quest3.setFinishTime( new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date(workEnd)));
        random.add(quest3);

        character.setRandomizedQuests(random);

        System.out.println("Users: ");
        int counter;
        for (Character character1: CharacterController.getLoggedInUsers()) {
            System.out.println("Character name: " + character1.getName());
            System.out.println("quests:");
            counter = 0;
            for (Quest quest4: character1.getRandomizedQuests()) {
                System.out.println(counter + ": " + quest4.getDescription() + ": " + quest4.getReward());
                counter++;
            }
            System.out.println("_______________________________________________");
        }

    }

    public static int generateReward(Character character) {
        return randomGenerator.nextInt((character.getLevel() * 10)  + (character.getLevel() * 20));
    }



    public static int generateWorkingMinute(Character character) {
        return 0;
    }

    private static String getDescriptionById(int id) {
        for (Quest quest: quests) {
            if (quest.getId() == id) {
                return quest.getDescription();
            }
        }

        return null;
    }





}
