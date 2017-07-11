package com.example.user.sharedpreferences;

import java.util.Calendar;

/**
 * Created by User on 11.07.2017.
 */

public class User {

    private String name;
    private String surname;
    private String address;
    private String photoPath;
    private long lastLogin;

    public User(String name, String surname, String address, long lastLogin) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.lastLogin = lastLogin;
    }

    public long getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(long lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
