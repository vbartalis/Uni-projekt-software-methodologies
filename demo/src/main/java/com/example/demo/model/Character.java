package com.example.demo.model;


import java.util.ArrayList;

public class Character {

    private String name;
    private String race;
    private String img;
    private int energy;
    private int exp;
    private int cash;
    private int str;
    private int intel;
    private int con;
    private int dex;
    private int strCost;
    private int intelCost;
    private int conCost;
    private int dexCost;
    private int helmet;
    private int gloves;
    private int jew1;
    private int jew2;
    private int outfit;
    private int weapon;
    private int inv1;
    private int inv2;
    private int inv3;
    private int inv4;
    private int inv5;
    private int inv6;
    private int inv7;
    private int inv8;
    private Long work_end;
    private Quest quest = null;
    private ArrayList<Quest> randomizedQuests;
    private int isWorking;
    private int questId;
    private int questReward;

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    private Enemy enemy;

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    private Market market;

    public int isWorking() {
        return isWorking;
    }

    public void setWorking(int working) {
        isWorking = working;
    }



    public int getQuestId() {
        return questId;
    }

    public void setQuestId(int questId) {
        this.questId = questId;
    }

    public int getQuestReward() {
        return questReward;
    }

    public void setQuestReward(int questReward) {
        this.questReward = questReward;
    }


    public ArrayList<Quest> getRandomizedQuests() {
        return randomizedQuests;
    }

    public void setRandomizedQuests(ArrayList<Quest> randomizedQuests) {

        System.out.println("Setting quests for " + getName());
        this.randomizedQuests = randomizedQuests;
    }


    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    public int getJew2() {
        return jew2;
    }

    public void setJew2(int jew2) {
        this.jew2 = jew2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getExp() {
        System.out.println("GET EXP");
        return getDex() + getIntel() + getCon() + getStr();
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
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

    public int getCon() {
        return con;
    }

    public void setCon(int con) {
        this.con = con;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getStrCost() {
        return getLevel() * getStr();
    }

    public void setStrCost(int strCost) {
        this.strCost = strCost;
    }

    public int getIntelCost() {
        return getLevel() * getIntel();
    }

    public void setIntelCost(int intelCost) {
        this.intelCost = intelCost;
    }

    public int getConCost() {
        return getLevel() * getCon();
    }

    public void setConCost(int conCost) {
        this.conCost = conCost;
    }

    public int getDexCost() {
        return getLevel() * getDex();
    }

    public void setDexCost(int dexCost) {
        this.dexCost = dexCost;
    }

    public int getHelmet() {
        return helmet;
    }

    public void setHelmet(int helmet) {
        this.helmet = helmet;
    }

    public int getGloves() {
        return gloves;
    }

    public void setGloves(int gloves) {
        this.gloves = gloves;
    }

    public int getOutfit() {
        return outfit;
    }

    public void setOutfit(int outfit) {
        this.outfit = outfit;
    }

    public int getWeapon() {
        return weapon;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    public int getJew1() {
        return jew1;
    }

    public void setJew1(int jew1) {
        this.jew1 = jew1;
    }

    public int getInv1() {
        return inv1;
    }

    public void setInv1(int inv1) {
        this.inv1 = inv1;
    }

    public int getInv2() {
        return inv2;
    }

    public void setInv2(int inv2) {
        this.inv2 = inv2;
    }

    public int getInv3() {
        return inv3;
    }

    public void setInv3(int inv3) {
        this.inv3 = inv3;
    }

    public int getInv4() {
        return inv4;
    }

    public void setInv4(int inv4) {
        this.inv4 = inv4;
    }

    public int getInv5() {
        return inv5;
    }

    public void setInv5(int inv5) {
        this.inv5 = inv5;
    }

    public int getInv6() {
        return inv6;
    }

    public void setInv6(int inv6) {
        this.inv6 = inv6;
    }

    public int getInv7() {
        return inv7;
    }

    public void setInv7(int inv7) {
        this.inv7 = inv7;
    }

    public int getInv8() {
        return inv8;
    }

    public void setInv8(int inv8) {
        this.inv8 = inv8;
    }

    public Long getWork_end() {
        return work_end;
    }

    public void setWork_end(Long work_end) {
        this.work_end = work_end;
    }

    public int getLevel() {
        return getExp() / 10;
    }


}
