package com.smartschool.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parents")
public class Parent {
    @Id
    @GeneratedValue
    private int student_id;

    private String parent_mobnum;

    private String parent_fname;

    private String parent_lname;

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getParent_mobnum() {
        return parent_mobnum;
    }

    public void setParent_mobnum(String parent_mobnum) {
        this.parent_mobnum = parent_mobnum;
    }

    public String getParent_fname() {
        return parent_fname;
    }

    public void setParent_fname(String parent_fname) {
        this.parent_fname = parent_fname;
    }

    public String getParent_lname() {
        return parent_lname;
    }

    public void setParent_lname(String parent_lname) {
        this.parent_lname = parent_lname;
    }
}
