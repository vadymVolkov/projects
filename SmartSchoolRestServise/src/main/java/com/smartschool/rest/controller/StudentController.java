package com.smartschool.rest.controller;


import com.smartschool.rest.model.Student;
import com.smartschool.rest.servise.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("school")
public class StudentController {


    @Autowired
    StudentService studentService;


    @RequestMapping("/students")
    public List<Student> getStudentsByClassId(@RequestParam(value = "class", defaultValue = "1") int classId) {

        List<Student> students = studentService.getStudentsByClassId(classId);

        return students;
    }

}

