package com.airtribe.learntrack.entity;

public class Course {
    private int id;
    private String courseName;
    private String description;
    private int durationInWeeks;
    private boolean active;

    public Course(int id,String courseName,String description,int durationInWeeks){
        this.active=true;
        this.courseName=courseName;
        this.description=description;
        this.id=id;
        this.durationInWeeks=durationInWeeks;
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getDurationInWeeks() {
        return durationInWeeks;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString(){
        return "[Course ID: " + id + "] " + courseName + " (" + durationInWeeks + " weeks) - Active: " + active;
    }
}
