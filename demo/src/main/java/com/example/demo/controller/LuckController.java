package com.example.demo.controller;

import com.example.demo.database.DatabaseHandler;
import com.example.demo.model.Character;

import javax.inject.Named;
import java.util.Random;

@Named
public class LuckController {

    Random random = new Random();
    public void betOne(Character character)
    {
        System.out.println(character.getName() + " wants to gamble a dollar");

        if (character.getCash() >=1)
        {
            System.out.println(character.getName() + " has enough money to play.");
            int temp = random.nextInt(2);
            if (temp>0)
            {
                System.out.println(character.getName() + " just won the bet");
                character.setCash(character.getCash() + 1);
            }
            else
            {
                System.out.println(character.getName() + " just lost a bet");
                character.setCash(character.getCash() - 1);
            }
            DatabaseHandler.updateUser(character.getName(), "cash", character.getCash());
        }
        else
        {
            System.out.println(character.getName() + " lacks the founds to play");
            RedirectHandler.setRedirectSite("character");
        }
    }

    public void betFive(Character character)
    {
        System.out.println(character.getName() + " wants to gamble five dollar");

        if (character.getCash() >=5)
        {
            System.out.println(character.getName() + " has enough money to play.");
            int temp = random.nextInt(2);
            if (temp>0)
            {
                System.out.println(character.getName() + " just won the bet");
                character.setCash(character.getCash() + 5);
            }
            else
            {
                System.out.println(character.getName() + " just lost a bet");
                character.setCash(character.getCash() - 5);
            }
            DatabaseHandler.updateUser(character.getName(), "cash", character.getCash());
        }
        else
        {
            System.out.println(character.getName() + " lacks the founds to play");
            RedirectHandler.setRedirectSite("character");
        }
    }
}
