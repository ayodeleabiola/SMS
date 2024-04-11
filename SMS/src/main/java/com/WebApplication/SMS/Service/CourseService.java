package com.WebApplication.SMS.Service;

import com.WebApplication.SMS.repository.CourseRepository;
import com.WebApplication.SMS.student.Course;
import com.WebApplication.SMS.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public ResponseEntity<Course> saveCourse(Course course){
        List<Student> students= new ArrayList<>();
        Student student= new Student();
        course.setStudents(course.getStudents());
        Course saveCourse= courseRepository.save(course);

        return new ResponseEntity<>(saveCourse, HttpStatus.CREATED);
    }

    public  ResponseEntity<List<Course>> getAllCourses(){

        List<Course> getCourse= courseRepository.findAll();
        return  new ResponseEntity<>(getCourse,HttpStatus.OK);
    }

    public Course getCourseById(Long id,HttpStatus httpStatus){
        Optional<Course>course=courseRepository.findById(id);
        return course.orElseThrow(()-> new NoSuchElementException("Courese not found"+id));
        }
    public void deleteById(Long id){
        Optional<Course> course=courseRepository.findById(id);
        if(course.isPresent()){
            courseRepository.delete(course.get());
        }
    }

    public ResponseEntity<Course> updateCourse(Long id,Course course){
        Optional<Course>course1=courseRepository.findById(id);
        if(course1.isPresent()){
            Course course2=course1.get();
            course2.setCourseName(course.getCourseName());
            return new ResponseEntity<>(course2,HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

}
