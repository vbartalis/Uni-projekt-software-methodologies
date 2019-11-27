package com.example.demo.controller;

import com.example.demo.database.DatabaseHandler;
import com.example.demo.model.Character;

import javax.inject.Named;

@Named
public class JobController {

    public void startJob(Character character)
    {
        System.out.println("Start working if the character dose not already or dose not do a quest");
        System.out.println("is working: " + character.isWorking() + "quest id: " + character.getQuestId());

        if ((character.isWorking() <= 0 ) && (character.getQuestId())<0)
        {
            System.out.println(character.getName() + "just started to work");

            character.setWorking(1);
            DatabaseHandler.updateUser(character.getName(), "is_working", 1);
            DatabaseHandler.updateUser(character.getName(), "work_end", System.currentTimeMillis()/1000);
            character.setWork_end((System.currentTimeMillis()/1000 + 28800));
        }
        else
        {
            System.out.println(character.getName() + " tryed to start the job but dose not meet the requrments to do so ...");
        }
    }

    public void finishJob(Character character)
    {
        System.out.println("Finishing job... ");
        System.out.println("is working: " + character.isWorking());

        System.out.println("Current time: " + System.currentTimeMillis() + " work end " + character.getWork_end()*1000);
        if ((character.isWorking() > 0) && (character.getWork_end()*1000 < System.currentTimeMillis()))
        {
            System.out.println(character.getName() + " successfully finished his job");
            character.setWorking(-1);

            int newCash = character.getCash() + (character.getLevel()*25 + 75);
            character.setCash(newCash);
            DatabaseHandler.updateUser(character.getName(), "cash", newCash);
            DatabaseHandler.updateUser(character.getName(), "is_working", -1);
            RedirectHandler.setRedirectSite("character");
        }
        else
        {
            System.out.println("Job cant be finished... ");
        }

    }
}
