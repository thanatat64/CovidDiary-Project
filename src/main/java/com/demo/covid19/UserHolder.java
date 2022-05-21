package com.demo.covid19;

public class UserHolder {
    private static UserHolder instance;

    private int id = 0;

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

}
