package com.example.demo.model;

public class Item {

    private int id;
    private String name;
    private int str;
    private int intel;
    private int dex;
    private int cons;
    private int type;
    private int price;

    public Item (int id, String name, int str, int intel, int dex, int cons, int type, int price) {
        this.id = id;
        this.name = name;
        this.str = str;
        this.intel = intel;
        this.dex = dex;
        this.cons = cons;
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getIntel() {
        return intel;
    }

    public void setIntel(int intel) {
        this.intel = intel;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getCons() {
        return cons;
    }

    public void setCons(int cons) {
        this.cons = cons;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
