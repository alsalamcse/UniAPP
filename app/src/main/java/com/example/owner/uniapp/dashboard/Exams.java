package com.example.owner.uniapp.dashboard;

public class Exams {
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

    public int getExamHour() {
        return ExamStartHour;
    }

    public void setExamHour(int examHour) {
        ExamStartHour = examHour;
    }


}
