package com.kkb.solutionoftasks.models;


import java.sql.Date;

public class Tasks {

    private int task_id;

    private String title;

    private String description;

    private Date time;

    private String status;

    private int performer;

    public Tasks() {

    }

    public Tasks(int task_id, String title, String description, Date time, String status, int performer) {
        this.task_id = task_id;
        this.title = title;
        this.description = description;
        this.time = time;
        this.status = status;
        this.performer = performer;
    }

    public int getTask_id() {
        return task_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    public int getPerformer() {
        return performer;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPerformer(int performer) {
        this.performer = performer;
    }
}
