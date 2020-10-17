package com.piyush.researchapp;

import java.io.Serializable;

public class ResearchData implements Serializable {

    private String userId;
    private String email;
    private int marks;

    public ResearchData(String userId, String email, int marks) {
        this.userId = userId;
        this.email = email;
        this.marks = marks;
    }

    public ResearchData(){

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
