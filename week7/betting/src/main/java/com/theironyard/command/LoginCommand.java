package com.theironyard.command;

/**
 * Created by jeff on 1/10/17.
 */
public class LoginCommand {
    int id;
    String password;

    public LoginCommand() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
