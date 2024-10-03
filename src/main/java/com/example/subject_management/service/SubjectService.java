package com.example.subject_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.subject_management.model.Subject;
import com.example.subject_management.repository.SubjectRepository;

@Service
public class SubjectService {
	
	@Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> findAllSubjects() {
        return subjectRepository.findAll();
    }

    public Optional<Subject> findSubjectById(int id) {
        return subjectRepository.findById(id);
    }

    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public void deleteSubject(int id) {
        subjectRepository.deleteById(id);
    }
}



