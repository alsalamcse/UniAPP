package com.example.owner.uniapp.data;

public class StudentEvent {
    private String Key;

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    private String Type;
   private String CourseTitle;
   private String LecturerName;
   private String FreeText;
   private long EventTime;

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getCourseTitle() {
        return CourseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        CourseTitle = courseTitle;
    }

    public String getLecturerName() {
        return LecturerName;
    }

    public void setLecturerName(String lecturerName) {
        LecturerName = lecturerName;
    }

    public String getFreeText() {
        return FreeText;
    }

    public void setFreeText(String freeText) {
        FreeText = freeText;
    }

    public long getEventTime() {
        return EventTime;
    }

    public void setEventTime(long eventTime) {
        EventTime = eventTime;
    }


}
