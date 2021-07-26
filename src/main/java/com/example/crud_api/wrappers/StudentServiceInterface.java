package com.example.crud_api.wrappers;

import com.example.crud_api.models.Student;
import com.example.crud_api.models.StudentProfile;

import java.util.List;

public interface StudentServiceInterface {
    public Student createStudent(Student student);
    public Student updateStudent(Student student);
    public Student getStudentById(Long id);
    public void deleteStudent(Long id);
    public List<Student> getAllStudent();
}
