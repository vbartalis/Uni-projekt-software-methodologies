package com.example.demo.controller;

import com.example.demo.database.DatabaseHandler;
import com.example.demo.model.Character;

import javax.inject.Named;

@Named
public class HouseController
{
    public void sleepForFour(Character character)
    {
        System.out.println(character.getName() + " wants to sleep ...");

        if ((character.isWorking() <= 0 ) && (character.getQuestId())<0)
        {
            System.out.println(character.getName() + " is sleeping now ...");
            character.setWork_end(System.currentTimeMillis()/1000);
            character.setWorking(4);
            DatabaseHandler.updateUser(character.getName(), "is_working", character.isWorking());
            DatabaseHandler.updateUser(character.getName(), "work_end", character.getWork_end());
        }
        else
        {
            System.out.println("You may not rest now there are monsters nearby");
        }
    }

    public void sleepForEight(Character character)
    {
        System.out.println(character.getName() + " wants to sleep ...");

        if ((character.isWorking() <= 0 ) && (character.getQuestId())<0)
        {
            System.out.println(character.getName() + " is sleeping now ...");
            character.setWork_end(System.currentTimeMillis()/1000);
            character.setWorking(8);
            DatabaseHandler.updateUser(character.getName(), "is_working", character.isWorking());
            DatabaseHandler.updateUser(character.getName(), "work_end", character.getWork_end());
        }
        else
        {
            System.out.println("You may not rest now there are monsters nearby");
        }
    }
}
