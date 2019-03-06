package com.example.owner.uniapp.dashboard;

public class Exams {

    private String Key;
    private String ExamName;
    private int ExamDate;
    private int ExamStartHour;
    private int ExamEndHour;
    public Exams(){

    }
    public int getExamEndHour() {
        return ExamEndHour;
    }

    public void setExamEndHour(int examEndHour) {
        ExamEndHour = examEndHour;
    }

    public String getExamName() {
        return ExamName;
    }

    public void setExamName(String examName) {
        ExamName = examName;
    }

    public int getExamDate() {
        return ExamDate;
    }

    public void setExamDate(int examDate) {
        ExamDate = examDate;
    }

    public int getExamStartHour() {
        return ExamStartHour;
    }

    public void setExamStartHour(int examHour) {
        ExamStartHour = examHour;
    }



    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }
}
