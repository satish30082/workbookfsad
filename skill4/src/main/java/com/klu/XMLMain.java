package com.klu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLMain {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("student-beans.xml");

        Student student = (Student) context.getBean("student");

        System.out.println("----- XML Configuration Output -----");
        student.display();
    }
}
