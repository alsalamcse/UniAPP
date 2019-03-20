package com.example.owner.uniapp;

public class Courses {
    private String Key;

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    private String CourseName;
    private String CourseDay;
    private int StartHour;
    private int EndHour;
    public Courses(){

    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getCourseDay() {
        return CourseDay;
    }

    public void setCourseDay(String courseDay) {
        CourseDay = courseDay;
    }

    public int getStartHour() {
        return StartHour;
    }

    public void setStartHour(int startHour) {
        StartHour = startHour;
    }

    public int getEndHour() {
        return EndHour;
    }

    public void setEndHour(int endHour) {
        EndHour = endHour;
    }
}
