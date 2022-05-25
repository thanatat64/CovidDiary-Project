package com.demo.covid19.classes;

public class UserHolder {
    private static UserHolder instance;
    private int id = 0;
    public static String username;

    public static UserHolder getInstance() {
        if (instance == null) {
            instance = new UserHolder();
        }

        return instance;
    }

    public void setUserId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return id;
    }
    //add username
    public void setUsername(String username){this.username = username;}

    public String getUsername(){return username;}

}
