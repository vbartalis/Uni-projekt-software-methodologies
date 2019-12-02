package com.example.demo.controller;

import com.example.demo.database.DatabaseHandler;
import com.github.javafaker.Faker;
import com.example.demo.model.Enemy;
import com.example.demo.model.Character;
import com.example.demo.model.Enemy;
import org.springframework.context.support.AbstractResourceBasedMessageSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.inject.Named;

import static java.util.Collections.shuffle;

@Named
public class ArenaController {

    private static ArrayList<Enemy> enemies = new ArrayList<>();

    public static void setEnemies(ArrayList<Enemy> enemies) {
        System.out.println("Loadin enemy from database");
        ArenaController.enemies = enemies;
    }



    public static void makeEnemy(Character character) {
        System.out.println("enemyt csinalunk");
        Collections.shuffle(enemies);
        Enemy enemy = new Enemy();
        Faker faker = new Faker();
        Random random = new Random();
        int enemycash = random.nextInt(130) + 10;
        int enemylevel= random.nextInt(99) + 1;
        enemies.get(1).setCash(enemycash);
        character.setEnemy(enemies.get(1));
    }


    public void nextEnemy(Character character) {
        makeEnemy(character);
    }

    public void attackEnemy(Character character) {
        if(character.getEnemy().getLevel() < character.getLevel()) {
            character.setCash(character.getCash() + character.getEnemy().getCash());
            DatabaseHandler.updateUser(character.getName(),"cash", character.getCash());
            nextEnemy(character);
        }
        else {
            nextEnemy(character);
        }

    }
}
