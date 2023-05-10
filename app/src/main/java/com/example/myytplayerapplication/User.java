package com.example.myytplayerapplication;

import java.io.Serializable;
import java.util.ArrayList;

public class User{

    //Instance variables
    private int userID;
    private String username, password, fullname;
    private ArrayList<String> playlist;

    //Constructor for initialization
    public User(String username, String password, String fullname, ArrayList<String> playlist) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.playlist = playlist;

    }

    //Getters and setters
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }
    public void setFullname(String username) { this.fullname = fullname; }

    public ArrayList<String> getPlaylist() {
        return playlist;
    }
    public void setPlaylist(ArrayList<String> playlist) {
        this.playlist = playlist;
    }
}
