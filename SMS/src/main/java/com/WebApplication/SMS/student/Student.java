package com.WebApplication.SMS.student;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="stu_record")
public class Student {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Long studentId;
    private String studentName;
    private String studentEmail;
    private String  studentPhoneNumber;

    @ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.PERSIST)
    @JoinTable(name="student_course",
                joinColumns =@JoinColumn(name="student_id"),
                inverseJoinColumns = @JoinColumn(name="course_id")
    )
    private List<Course> courses;

    public Student() {

    }
    public Student(String studentName, String studentEmail, String studentPhoneNumber, List<Course> courses) {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentPhoneNumber = studentPhoneNumber;
        this.courses = courses;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentPhoneNumber() {
        return studentPhoneNumber;
    }

    public void setStudentPhoneNumber(String studentPhoneNumber) {
        this.studentPhoneNumber = studentPhoneNumber;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}