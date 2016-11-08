package com.smartschool.rest.servise;


import com.smartschool.rest.model.Student;
import com.smartschool.rest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.getStudents();
    }

    public List<Student> getStudentsByClassId(int id) {
        return studentRepository.getStudentsByClassId(id);
    }
}
