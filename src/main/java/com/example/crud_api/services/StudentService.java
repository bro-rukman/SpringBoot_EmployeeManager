package com.example.crud_api.services;

import com.example.crud_api.exceptions.StudentNotFoundException;
import com.example.crud_api.models.Student;
import com.example.crud_api.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepo studentRepo;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
//    post
    public Student addStudent(Student student){
        String encodedPassword  = this.passwordEncoder.encode(student.getPassword());
        student.setPassword(encodedPassword);
        return studentRepo.save(student);
    }
//    get
    public List<Student> getAllStudent(){
        return studentRepo.findAll();
    }
//    getById
    public Student getStudentById(Long id){
        return studentRepo.findById(id).orElseThrow(()->new StudentNotFoundException("Student with id" +id+"was not found !" ));
    }
//    update
    public Student updateStudent(Long id,Student student){
        Student student1 = studentRepo.findById(id).orElseThrow(()->new StudentNotFoundException("Student with id" +id+"was not found !" ));
        student1.setName(student.getName());
        student1.setNim(student.getNim());
        student1.setJurusan(student.getJurusan());
        student1.setEmail(student.getEmail());
        student1.setPassword(passwordEncoder.encode(student.getPassword()));
        return studentRepo.save(student1);
    }
//    delete
    public void deleteStudent(Long id){
        studentRepo.deleteById(id);
    }
}
