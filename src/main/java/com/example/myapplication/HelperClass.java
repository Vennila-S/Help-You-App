package com.example.myapplication;

public class HelperClass {
    String username, password,email;


    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public HelperClass(String username, String password, String email) {
        this.username=username;
        this.password=password;
        this.email=email;
    }
    public HelperClass(){

    }
}
