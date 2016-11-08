package com.volkov.spring.service;


import com.volkov.spring.model.Exam;
import com.volkov.spring.report.ExamsReport;
import com.volkov.spring.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExamService {

    @Autowired
    ExamRepository examRepository;

    public List<Exam> getExams() {
        return examRepository.getExams();
    }

    @Transactional
    public void addExam(Exam exam) {
        examRepository.addExam(exam);
    }
    public List<ExamsReport> getExamsResults(String firstname, String lastname) {
        return examRepository.getExamsResults(firstname, lastname);
    }

}
