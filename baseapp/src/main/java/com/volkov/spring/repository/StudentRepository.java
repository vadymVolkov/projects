package com.volkov.spring.repository;

import com.volkov.spring.model.Student;

import java.util.List;

public interface StudentRepository {
    public List<Student> getStudents();
}
