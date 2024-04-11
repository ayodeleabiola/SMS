package com.WebApplication.SMS.controller;

import com.WebApplication.SMS.Service.StudentService;
import com.WebApplication.SMS.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins ="http://localhost:4200")
@RestController
//@RequestMapping("api/vi")
public class StudentController{
    @Autowired
    private StudentService studentService;


    @GetMapping("student/get")
    public ResponseEntity<List> getAllStudet(){
        return studentService.getAllStudent();
    }
    @PostMapping("student/save")
    public ResponseEntity<Student>savePost(@RequestBody Student student){
        return studentService.savePost(student);
    }

    @PutMapping("student/update")
    public  ResponseEntity<Student> updateStudent(@PathVariable Long id,
                                                  @RequestBody Student student){

        return studentService.updateDateStudent(id,student);
    }
    @DeleteMapping("/delete")
    public  String deleteById (Long id){
        studentService.deleteById(id);

        return "student with "+id+ "is successfully deleted";
    }

}
