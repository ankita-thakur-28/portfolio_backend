package com.codewithankita.portfolioproject.model;

public class Contact {
    private  String name;
    private String email;
    private String message;

    public void setName( String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
