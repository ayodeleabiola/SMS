package com.WebApplication.SMS.Service;

import com.WebApplication.SMS.student.Student;
import com.WebApplication.SMS.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public ResponseEntity<List> getAllStudent(){
        List<Student> students=studentRepository.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    public ResponseEntity<Student> savePost(Student students){
        Student student=studentRepository.save(students);

        return new ResponseEntity<>(student,HttpStatus.CREATED);

    }
    public  void deleteById(Long id){
        Optional<Student> studentId=studentRepository.findById(id);
        if(studentId.isPresent()){
            studentRepository.delete(studentId.get());
        }
    }

    public  ResponseEntity<Student> updateDateStudent(Long id,Student student){
        Optional<Student> studentUpdate=studentRepository.findById(id);
        if (studentUpdate.isPresent()){
            Student studentExist=studentUpdate.get();
            studentExist.setStudentName(student.getStudentName());
            studentExist.setStudentEmail(student.getStudentEmail());
            studentExist.setStudentPhoneNumber(student.getStudentPhoneNumber());
            return new ResponseEntity<>(studentExist,HttpStatus.OK);
        }

        return ResponseEntity.notFound().build();


    }


}
