package com.airtribe.learntrack.entity;

public class Student extends Person{

    private String batch;
    private boolean active;

    public Student(int id,String firstName,String lastName,String email,String batch){
        super(id, firstName, lastName, email);
        this.active=true;
        this.batch=batch;
    }

    public Student(int id,String firstName,String lastName,String batch){
        super(id, firstName, lastName,"N/A");
        this.active=true;
        this.batch=batch;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public boolean isActive(){
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String getDisplayName(){
        return "[Student ID: " + getId() + "] " + super.getDisplayName() + " | Batch: " + batch + " | Active: " + active;
    }
}
