package com.example.demo.model;

public class Enemy {

    String name;
    int level;
    int cash;


    public Enemy(String name, int level) {
        this.name = name;
        this.level = level;
    }
    public Enemy() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }



}
