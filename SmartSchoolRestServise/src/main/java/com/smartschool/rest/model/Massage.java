package com.smartschool.rest.model;

import javax.persistence.*;

@Entity
@Table(name = "massages")
public class Massage {
    @Id
    @GeneratedValue
    private int massage_id;

    private int teacher_id;

    private int parent_id;

    private int class_id;

    private String massage_text;

    public int getMassage_id() {
        return massage_id;
    }

    public void setMassage_id(int massage_id) {
        this.massage_id = massage_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getParrent_id() {
        return parent_id;
    }

    public void setParrent_id(int parrent_id) {
        this.parent_id = parrent_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getMassage_text() {
        return massage_text;
    }

    public void setMassage_text(String massage_text) {
        this.massage_text = massage_text;
    }
}
