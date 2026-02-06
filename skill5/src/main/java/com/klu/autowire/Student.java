package com.klu.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private int id;
    private String name;
    private String gender;

    @Autowired
    private Certification certification; // Autowired Object

    public Student() {
        this.id = 101;
        this.name = "Satish";
        this.gender = "Male";
    }

    public void display() {

        System.out.println("Student ID   : " + id);
        System.out.println("Name         : " + name);
        System.out.println("Gender       : " + gender);

        System.out.println("----- Certification Details -----");
        certification.display();
    }
}
