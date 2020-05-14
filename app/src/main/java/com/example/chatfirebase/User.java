package com.example.chatfirebase;

public class User {

    private  String uuid;
    private  String username;
    private  String profileUrl;

    public User(){

    }

    public String getUuid() {
        return uuid;
    }

    public String getUsername() {
        return username;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public User(String uuid, String username, String profileUrl) {
        this.uuid = uuid;
        this.username = username;
        this.profileUrl = profileUrl;

    }
}
