package com.piyush.researchapp;

import java.io.Serializable;

public class ResearchData implements Serializable {

    private String userId;
    private String email;
    private int marks;
    private int posttestmarks;
    private Boolean pretest;
    private Boolean posttest;

    public ResearchData(String userId, String email, int marks, Boolean pretest, int posttestmarks) {
        this.userId = userId;
        this.email = email;
        this.marks = marks;
        this.pretest = pretest;
        this.posttestmarks = posttestmarks;
    }

    public ResearchData(){

    }

    public ResearchData(Boolean pretest) {
        this.pretest = pretest;
    }
    public ResearchData(Boolean posttest, String userId) {
        this.posttest = posttest;
        this.userId = userId;
    }

    public ResearchData(String userId,int posttestmarks) {
        this.userId = userId;
        this.posttestmarks = posttestmarks;
    }

    public ResearchData(String userId, String email) {
        this.userId = userId;
        this.email = email;
    }

    public ResearchData(String userId, String email, Boolean pretest) {
        this.userId = userId;
        this.email = email;
        this.pretest = pretest;
    }

    public ResearchData(int marks) {
        this.marks = marks;
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

    public Boolean getPretest() {
        return pretest;
    }

    public void setPretest(Boolean pretest) {
        this.pretest = pretest;
    }

    public int getPosttestmarks() {
        return posttestmarks;
    }

    public void setPosttestmarks(int posttestmarks) {
        this.posttestmarks = posttestmarks;
    }

    public Boolean getPosttest() {
        return posttest;
    }

    public void setPosttest(Boolean posttest) {
        this.posttest = posttest;
    }
}
