package com.volkov.spring.service;

import com.volkov.spring.model.Student;

import java.util.List;

public interface UniversityService {
    public List<Student> getAvailableStudents();
}
