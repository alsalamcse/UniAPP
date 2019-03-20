package com.example.owner.uniapp.dashboard;

public class Exams {

    private String Key;
    private String ExamName;
    private String ExamDate;

    public String getExamName() {
        return ExamName;
    }

    public void setExamName(String examName) {
        ExamName = examName;
    }

    public String getExamDate() {
        return ExamDate;
    }

    public void setExamDate(String examDate) {
        ExamDate = examDate;
    }

    public String getExamStartHour() {
        return ExamStartHour;
    }

    public void setExamStartHour(String examStartHour) {
        ExamStartHour = examStartHour;
    }

    public String getExamEndHour() {
        return ExamEndHour;
    }

    public void setExamEndHour(String examEndHour) {
        ExamEndHour = examEndHour;
    }

    private String ExamStartHour;
    private String ExamEndHour;
    public Exams(){

    }



    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }
}
