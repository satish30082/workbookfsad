package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Student;
import com.klu.service.StudentService;

@RestController
public class StudentController 
{

    @Autowired
    StudentService service;

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id)
    {
        return service.getStudentById(id);
    }

}