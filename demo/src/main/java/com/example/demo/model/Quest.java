package com.example.demo.model;

public class Quest {

    private int id;
    private String description;
    private int reward;
    private int workingMinutes;
    private String finishTime;

    public Quest(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getWorkingMinutes() {
        return workingMinutes;
    }

    public void setWorkingMinutes(int workingMinutes) {
        this.workingMinutes = workingMinutes;
    }


    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }



}
