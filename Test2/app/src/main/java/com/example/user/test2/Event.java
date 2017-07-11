package com.example.user.test2;

/**
 * Created by User on 10.07.2017.
 */

public class Event {

    private String description;
    private String about;
    private String image;

    public Event(String description, String about, String image) {
        this.description = description;
        this.about = about;
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
