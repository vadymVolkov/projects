package com.smartschool.rest.controller;

import com.smartschool.rest.model.StudentParent;
import com.smartschool.rest.servise.StudentParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("school")
public class StudentParentController {
    @Autowired
    StudentParentService studentParentService;


    @RequestMapping("/parents")
    public List<StudentParent> getParentByClassId(@RequestParam(value = "class", defaultValue = "1") int classId) {

        List<StudentParent> studentParents = studentParentService.getParentsByClassId(classId);

        return studentParents;
    }
}
