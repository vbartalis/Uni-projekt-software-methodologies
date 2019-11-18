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
                random.add(generateQuest(quests.get(0) ,character));
        }


        random.add(generateQuest(quests.get(1), character));
        random.add(generateQuest(quests.get(2), character));

        character.setRandomizedQuests(random);

        System.out.println("Users: ");
        int counter;
        for (Character character1: CharacterController.getLoggedInUsers()) {
            if (character1 != null) {
                System.out.println("Character name: " + character1.getName());
                System.out.println("quests:");
                counter = 0;
                for (Quest quest4 : character1.getRandomizedQuests()) {
                    System.out.println(counter + ": " + quest4.getDescription() + ": " + quest4.getReward());
                    counter++;
                }
                System.out.println("_______________________________________________");
            }
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

    public static Quest generateQuest(Quest quest, Character character) {
        quest.setReward(generateReward(character));
        int workingMinute = generateWorkingMinute(character);
        quest.setWorkingMinutes(workingMinute);
        long workEnd = System.currentTimeMillis() + workingMinute * 60000;
        quest.setFinishTime( new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date(workEnd)));

        return quest;
    }





}
