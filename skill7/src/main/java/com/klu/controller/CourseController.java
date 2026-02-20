package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Course;
import com.klu.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    // Add Course
    @PostMapping("/add")
    public ResponseEntity<String> addCourse(@RequestBody Course course) {

        if (course == null) {
            return new ResponseEntity<>("Invalid Data", HttpStatus.BAD_REQUEST);
        }

        service.addCourse(course);
        return new ResponseEntity<>("Course Added Successfully", HttpStatus.CREATED);
    }

    // Get All Courses
    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAll() {

        List<Course> list = service.getAllCourses();

        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // Get By Id
    @GetMapping("/{id}")
    public ResponseEntity<Course> getById(@PathVariable int id) {

        Course course = service.getCourseById(id);

        if (course == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    // Update Course
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id,
                                         @RequestBody Course course) {

        Course updated = service.updateCourse(id, course);

        if (updated == null) {
            return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Course Updated", HttpStatus.OK);
    }

    // Delete Course
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {

        boolean deleted = service.deleteCourse(id);

        if (!deleted) {
            return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Course Deleted", HttpStatus.OK);
    }

    // Search By Title
    @GetMapping("/search/{title}")
    public ResponseEntity<List<Course>> search(@PathVariable String title) {

        List<Course> result = service.searchByTitle(title);

        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}