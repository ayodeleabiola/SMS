package com.WebApplication.SMS.controller;

import com.WebApplication.SMS.Service.CourseService;
import com.WebApplication.SMS.student.Course;
import com.WebApplication.SMS.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("course/get")
    public ResponseEntity<List<Course>> getAllCourse(Student student){
        return courseService.getAllCourses();
    }
    //@GetMapping("/")
    @PostMapping("course/save")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course){
        return courseService.saveCourse(course);
    }
    @PutMapping("course/update/{id}")
    public ResponseEntity<Course> upDateCourse(@PathVariable Long id,
                                               @RequestBody Course course){
        return courseService.updateCourse(id,course);
    }
    @DeleteMapping("course/delete")
    public  ResponseEntity<Course> delete(@PathVariable Long id,Course course){
        return courseService.updateCourse(id,course);
    }


}
