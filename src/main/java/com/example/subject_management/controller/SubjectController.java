package com.example.subject_management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.subject_management.model.Subject;
import com.example.subject_management.service.SubjectService;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectService.findAllSubjects();
    }

    @GetMapping("/{id}")
    public Optional<Subject> getSubjectById(@PathVariable int id) {
        return subjectService.findSubjectById(id);
    }

    @PostMapping
    public Subject createSubject(@RequestBody Subject subject) {
        return subjectService.saveSubject(subject);
    }

    @PutMapping("/{id}")
    public Subject updateSubject(@PathVariable int id, @RequestBody Subject subjectDetails) {
        Subject subject = subjectService.findSubjectById(id).orElseThrow(() -> new RuntimeException("Subject not found"));

        subject.setSubject(subjectDetails.getSubject());
        subject.setCredits(subjectDetails.getCredits());

        return subjectService.saveSubject(subject);
    }

    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable int id) {
        subjectService.deleteSubject(id);
    }
}

