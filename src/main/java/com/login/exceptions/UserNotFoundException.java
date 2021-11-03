package com.login.exceptions;

public class UserNotFoundException extends Exception {

    private String message;

    public UserNotFoundException() {
        this.message = "User not found";
    }
}
