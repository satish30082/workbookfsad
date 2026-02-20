package com.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.model.Course;
import com.klu.repo.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repo;

    public Course addCourse(Course course) {
        return repo.save(course);
    }

    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    public Course getCourseById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Course updateCourse(int id, Course course) {

        Course old = repo.findById(id).orElse(null);

        if (old != null) {
            old.setTitle(course.getTitle());
            old.setDuration(course.getDuration());
            old.setFee(course.getFee());
            return repo.save(old);
        }

        return null;
    }

    public boolean deleteCourse(int id) {

        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }

        return false;
    }

    public List<Course> searchByTitle(String title) {
        return repo.findByTitleIgnoreCase(title);
    }
}