package com.smartschool.rest.controller;

import com.smartschool.rest.model.Massage;
import com.smartschool.rest.servise.MassageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("school")
public class MassageController {
    @Autowired
    MassageService massageService;

    @RequestMapping("/massages")
    public List<Massage> getAllMassageForClassByClassId(@RequestParam(value = "class", defaultValue = "1") int classId) {

        List<Massage> massages = massageService.getAllMassageForClassByClassId(classId);

        return massages;
    }
}
