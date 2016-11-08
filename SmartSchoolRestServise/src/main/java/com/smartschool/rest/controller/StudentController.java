package com.smartschool.rest.controller;


import com.smartschool.rest.model.Greeting;
import com.smartschool.rest.model.Student;
import com.smartschool.rest.servise.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("school")
public class StudentController {


    @Autowired
    StudentService studentService;


    @RequestMapping("/students")
    public List<Student> getStudents(@RequestParam(value = "class", defaultValue = "1") int classId) {

        List<Student> students = studentService.getStudentsByClassId(classId);

        return students;
    }

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting2(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

}

