package com.reqres;

public class User {
    private String name;
    private String job;

    public User(String name, String job) {
        setName(name);
        setJob(job);
    }
    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    private void setJob(String job) {
    }

    private void setName(String name) {
    }
}
