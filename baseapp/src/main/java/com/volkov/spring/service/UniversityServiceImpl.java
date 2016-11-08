package com.volkov.spring.service;

import com.volkov.spring.model.Student;
import com.volkov.spring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("universityService")
public class UniversityServiceImpl implements UniversityService {
    @Autowired
    StudentRepository studentRepository;

    public UniversityServiceImpl() {
    }

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getAvailableStudents() {
        return studentRepository.getStudents();
    }
}
