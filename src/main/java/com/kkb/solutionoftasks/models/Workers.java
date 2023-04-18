package com.kkb.solutionoftasks.models;

public class Workers {

    private int worker_id;

    private String name;

    private String position;

    private String avatar;

    public Workers(int worker_id, String name, String position, String avatar) {
        this.worker_id = worker_id;
        this.name = name;
        this.position = position;
        this.avatar = avatar;
    }

    public int getWorker_id() {
        return worker_id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setWorker_id(int worker_id) {
        this.worker_id = worker_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
