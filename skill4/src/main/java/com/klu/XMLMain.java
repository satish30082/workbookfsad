package com.klu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMLMain {

    public static void main(String[] args) {

        // Load XML Container
        ApplicationContext context =
                new ClassPathXmlApplicationContext("student-beans.xml");

        // Get Bean
        Student student = (Student) context.getBean("student");

        // Display
        System.out.println("----- XML Configuration Output -----");
        student.display();
    }
}
