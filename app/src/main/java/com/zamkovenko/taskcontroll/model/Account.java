package com.zamkovenko.taskcontroll.model;

/**
 * User: Yevgeniy Zamkovenko
 * Date: 09.05.2017
 */

public class Account {
    private String login;
    private String password;

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }
}
