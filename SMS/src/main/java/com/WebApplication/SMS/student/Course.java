package com.WebApplication.SMS.student;
import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name="CourseDetails")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cousrseId;
    private  String courseName;
    @ManyToMany(mappedBy = "courses",fetch=FetchType.EAGER,
            cascade = CascadeType.PERSIST)
    private List<Student> students;
    public Course(){
    }
    public Course(String courseName, List<Student> students) {
        this.courseName = courseName;
        this.students = students;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
}