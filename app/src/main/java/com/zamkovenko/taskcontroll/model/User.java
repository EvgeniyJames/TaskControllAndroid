package com.zamkovenko.taskcontroll.model;

/**
 * User: EvgeniyJames
 * Date: 28.02.2017
 */

public class User {
    private String name;
    private String number;

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
