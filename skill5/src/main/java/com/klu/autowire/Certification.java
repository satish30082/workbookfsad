package com.klu.autowire;

import org.springframework.stereotype.Component;

@Component
public class Certification {

    private int id;
    private String name;
    private String dateOfCompletion;

    public Certification() {
        this.id = 501;
        this.name = "Full Stack Certification";
        this.dateOfCompletion = "01-02-2026";
    }

    public void display() {
        System.out.println("Certification ID   : " + id);
        System.out.println("Certification Name : " + name);
        System.out.println("Completed On       : " + dateOfCompletion);
    }
}
