package com.example.crud_api.models;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Validated
public class StudentProfile implements Serializable {
    private Long id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "Jurusan field is required !")
    private String jurusan;
    @NotBlank(message = "Phone field is required !")
    @Size(min = 7)
    private String phone;
    @NotBlank(message = "Address field is required !")
    private String address;
    @NotBlank(message = "Date of Birth field is required !")
    @Column(name = "dateofbirth")
    private Date  dateOfBirth;
    @NotBlank(message = "Gender field is required !")
    private Gender gender;
//    @OneToOne(mappedBy = "StudentProfile")
//    @JoinColumn(name = "student", nullable = false)
    private Student student;

    public StudentProfile(Long id, String jurusan, String phone, String address, Date dateOfBirth, Gender gender,Student student) {
        this.id = id;
        this.jurusan = jurusan;
        this.phone = phone;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
