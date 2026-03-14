package com.klu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.model.Student;
import com.klu.repo.StudentRepository;
import com.klu.exception.StudentNotFoundException;

@Service
public class StudentService 
{

    @Autowired
    StudentRepository repo;

    public Student getStudentById(int id)
    {
        return repo.findById(id)
                .orElseThrow(() -> 
                new StudentNotFoundException("Student with ID " + id + " not found"));
    }

}