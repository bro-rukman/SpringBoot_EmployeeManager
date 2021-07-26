package com.example.crud_api.services;

import com.example.crud_api.exceptions.StudentNotFoundException;
import com.example.crud_api.models.Student;
import com.example.crud_api.models.StudentProfile;
import com.example.crud_api.repos.StudentProfileRepo;
import com.example.crud_api.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentService{
    @Autowired
    private final StudentRepo studentRepo;
    private final StudentProfileRepo studentProfileRepo;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public StudentService(StudentRepo studentRepo, StudentProfileRepo studentProfileRepo) {
        this.studentRepo = studentRepo;
        this.studentProfileRepo = studentProfileRepo;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
//    post detail
    public StudentProfile addProfile(StudentProfile studentProfile){
        return studentProfileRepo.save(studentProfile);
    }
//    post
    public Student addStudent(Student student) {
        String encodedPassword  = this.passwordEncoder.encode(student.getPassword());
        student.setPassword(encodedPassword);
        student.setCreated_at(new Date());
        student.setUpdated_at(new Date());
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
        student1.setEmail(student.getEmail());
        student1.setPassword(passwordEncoder.encode(student.getPassword()));
        return studentRepo.save(student1);
    }
//    delete
    public void deleteStudent(Long id){
        studentRepo.deleteById(id);
    }
}
