package com.kcs.springboot.example.data;

import java.util.Date;

public class StudentMark {
    private int id;
    private int studentId;
    private String title;
    private int mark;
    private Date date;

    public StudentMark(){

    }

    public StudentMark(int id, int studentId, String title, int mark, Date time_stamp) {
        this(studentId, title, mark, time_stamp);
        this.id = id;
    }

    public StudentMark(int studentId, String title, int mark, Date date) {
        this.studentId = studentId;
        this.title = title;
        this.mark = mark;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
