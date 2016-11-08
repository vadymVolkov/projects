package com.volkov.spring;

import com.volkov.spring.model.Student;
import com.volkov.spring.service.UniversityService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainAplication {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");

        UniversityService universityService = applicationContext.getBean("universityService", UniversityService.class);

        List<Student> students = universityService.getAvailableStudents();

        for (Student student : students) {
            System.out.println(student.getLastName() +
                    " " + student.getFirstName() +
                    " " + student.getAge() + " years old");
        }

    }
}
