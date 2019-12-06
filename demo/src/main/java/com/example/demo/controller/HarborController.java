package com.example.demo.controller;

import com.example.demo.database.DatabaseHandler;
import com.example.demo.model.Character;
import com.example.demo.model.Enemy;
import com.example.demo.model.Harbor;
import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.Random;

import javax.inject.Named;
import javax.xml.crypto.Data;

@Named
public class HarborController {

    public static void makeHarborEnemy(Character character) {
        System.out.println("enemyt csinalunk");
        Harbor harbor = new Harbor();
        Faker faker = new Faker();
        Random random = new Random();
        int enemycash = random.nextInt(40) + 10;
        int enemylevel = random.nextInt(character.getLevel()) + 4;
        String enemyName = faker.name().fullName();
        harbor.setHarborEnemyName(enemyName);
        harbor.setHarborEnemyCash(enemycash);
        harbor.setHarborEnemyLvl(enemylevel);
        String harborEnemyImage;
        String harborEnemyRace;
        int enemyImg = random.nextInt(8);
        switch (enemyImg) {
            case 0:
                harborEnemyImage = "anthropomorphic_cat";
                harborEnemyRace = "Felinid";
                harbor.setHarborEnemyImage(harborEnemyImage);
                harbor.setHarborEnemyRace(harborEnemyRace);
                break;
            case 1:
                harborEnemyImage = "anthropomorphic_dog";
                harborEnemyRace = "Canid";
                harbor.setHarborEnemyImage(harborEnemyImage);
                harbor.setHarborEnemyRace(harborEnemyRace);
                break;
            case 2:
                harborEnemyImage = "cyborg";
                harborEnemyRace = "Cyborg";
                harbor.setHarborEnemyImage(harborEnemyImage);
                harbor.setHarborEnemyRace(harborEnemyRace);
                break;
            case 3:
                harborEnemyImage = "procyon";
                harborEnemyRace = "Procyon";
                harbor.setHarborEnemyImage(harborEnemyImage);
                harbor.setHarborEnemyRace(harborEnemyRace);
                break;
            case 4:
                harborEnemyImage = "rock_monster";
                harborEnemyRace = "Cragorian";
                harbor.setHarborEnemyImage(harborEnemyImage);
                harbor.setHarborEnemyRace(harborEnemyRace);
                break;
            case 5:
                harborEnemyImage = "snail_monster";
                harborEnemyRace = "Zirrelian";
                harbor.setHarborEnemyImage(harborEnemyImage);
                harbor.setHarborEnemyRace(harborEnemyRace);
                break;
            case 6:
                harborEnemyImage = "arcturians";
                harborEnemyRace = "Arcturian";
                harbor.setHarborEnemyImage(harborEnemyImage);
                harbor.setHarborEnemyRace(harborEnemyRace);
                break;
            case 7:
                harborEnemyImage = "aquanog";
                harborEnemyRace = "Aquanog";
                harbor.setHarborEnemyImage(harborEnemyImage);
                harbor.setHarborEnemyRace(harborEnemyRace);
                break;
            case 8:
                harborEnemyImage = "macikri";
                harborEnemyRace = "Macikri";
                harbor.setHarborEnemyImage(harborEnemyImage);
                harbor.setHarborEnemyRace(harborEnemyRace);
                break;
        }
        character.setHarbor(harbor);
    }


    public void nextHarborEnemy(Character character) {
        makeHarborEnemy(character);
    }

    public void attackHarborEnemy(Character character) {
        if (character.getEnergy() >= 3) {
            character.setEnergy(character.getEnergy() - 3);
            DatabaseHandler.updateUser(character.getName(), "energy", character.getEnergy());
            if (character.getEnemy().getLevel() < character.getLevel()) {
                character.setCash(character.getCash() + character.getHarbor().getHarborEnemyCash());
                DatabaseHandler.updateUser(character.getName(), "cash", character.getCash());
                nextHarborEnemy(character);
            } else {
                nextHarborEnemy(character);
            }
        }
    }
}