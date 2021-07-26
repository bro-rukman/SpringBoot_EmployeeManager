package com.example.crud_api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Validated
@Entity
@Table(name = "students")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name field is required !")
    private String name;
    @NotBlank(message = "NIM field is required !")
    private String nim;
    @NotBlank(message = "Email field is required !")
    @Email
    @Column(unique = true)
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "Password field is required !")
    private String password;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date created_at;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date updated_at;
    @OneToOne(fetch = FetchType.LAZY,targetEntity =StudentProfile.class ,cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id", referencedColumnName = "id")
    private StudentProfile studentProfile;
    public Student(){}
    public Student(Long id, String name, String nim, String email, String password, Date created_at, Date updated_at,StudentProfile studentProfile) {
        this.id = id;
        this.name = name;
        this.nim = nim;
        this.email = email;
        this.password = password;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.studentProfile = studentProfile;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated_at() {
        return created_at;
    }
    public Date getUpdated_at() {
        return updated_at;
    }
    public void setCreated_at(Date created_at){
        this.created_at = created_at;
    }
    public void setUpdated_at(Date updated_at){
        this.updated_at = updated_at;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nim='" + nim + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", studentProfile=" + studentProfile +
                '}';
    }
}
