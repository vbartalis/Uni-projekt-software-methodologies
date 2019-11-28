package com.example.demo.controller;

import com.example.demo.database.DatabaseHandler;
import com.github.javafaker.Faker;
import com.example.demo.model.Enemy;
import com.example.demo.model.Character;
import com.example.demo.model.Enemy;

import java.util.Random;

import javax.inject.Named;

@Named
public class ArenaController {

    public static void makeEnemy(Character character) {
        System.out.println("enemyt csinalunk");
        Enemy enemy = new Enemy();
        Faker faker = new Faker();
        Random random = new Random();
        int enemycash = random.nextInt(130) + 10;
        int enemylevel= random.nextInt(99) + 1;
        String enemyName = faker.name().fullName();
        enemy.setName(enemyName);
        enemy.setCash(enemycash);
        enemy.setLevel(enemylevel);
        character.setEnemy(enemy);
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
