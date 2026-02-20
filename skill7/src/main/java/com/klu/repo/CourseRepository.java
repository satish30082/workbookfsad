package com.klu.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findByTitleIgnoreCase(String title);
}