package com.example.user.cookbook;

import java.io.Serializable;

/**
 * Created by User on 10.07.2017.
 */

public class Recipe implements Serializable{

    private String name;
    private String time;
    private String difficulty;
    private String shortDescription;
    private String description;

    public Recipe(String name, String time, String difficulty, String shortDescription, String description) {
        this.name = name;
        this.time = time;
        this.difficulty = difficulty;
        this.shortDescription = shortDescription;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
