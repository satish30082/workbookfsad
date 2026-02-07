package com.klu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationMain {

    public static void main(String[] args) {

        // Load Annotation Container
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // Get Bean
        Student student = context.getBean(Student.class);

        // Display
        System.out.println("----- Annotation Configuration Output -----");
        student.display();
    }
}
