package com.smartschool.rest.servise;

import com.smartschool.rest.model.StudentParent;
import com.smartschool.rest.repository.StudentParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentParentService {
    @Autowired
    private StudentParentRepository studentParentRepository;

    public List<StudentParent> getParentsByClassId(int id) {


        return studentParentRepository.getParentByClassId(id);
    }
}
