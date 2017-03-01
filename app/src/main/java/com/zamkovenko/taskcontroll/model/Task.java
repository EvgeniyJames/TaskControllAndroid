package com.zamkovenko.taskcontroll.model;

/**
 * User: EvgeniyJames
 * Date: 01.03.2017
 */

public class Task {
    private String theme;

    public Task(String theme) {
        this.theme = theme;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
