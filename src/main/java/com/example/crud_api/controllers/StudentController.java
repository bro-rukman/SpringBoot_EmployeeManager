package com.example.crud_api.controllers;

import com.example.crud_api.exceptions.StudentNotFoundException;
import com.example.crud_api.models.Student;
import com.example.crud_api.models.StudentProfile;
import com.example.crud_api.services.StudentService;
import com.example.crud_api.repos.StudentRepo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> students = studentService.getAllStudent();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id){
        Student student = studentService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student, StudentProfile studentProfile)throws MethodArgumentNotValidException {
        Student student1 = studentService.addStudent(student);
        StudentProfile studentProfile1 = studentService.addProfile(studentProfile);
        return new ResponseEntity<>(student1, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        return new ResponseEntity<Student>(studentService.updateStudent(id,student),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<Student> deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
