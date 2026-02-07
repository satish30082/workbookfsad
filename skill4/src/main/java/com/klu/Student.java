package com.klu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component   // For Annotation DI
public class Student {

    private int studentId;
    private String name;
    private String course;
    private int year;

    // Constructor Injection
    public Student(
            @Value("101") int studentId,
            @Value("Satish") String name,
            @Value("Java Full Stack") String course,
            @Value("2026") int year) {

        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.year = year;
    }

    // Setter Injection
    public void setCourse(String course) {
        this.course = course;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Display Method
    public void display() {
        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + name);
        System.out.println("Course     : " + course);
        System.out.println("Year       : " + year);
    }
}
