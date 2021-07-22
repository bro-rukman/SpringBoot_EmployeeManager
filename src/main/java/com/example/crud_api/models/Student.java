package com.example.crud_api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String name;
    private String nim;
    private String jurusan;
    private String email;
    @JsonIgnore
    private String password;

    public Student(){}
    public Student(Long id, String name, String nim, String jurusan, String email, String password) {
        this.id = id;
        this.name = name;
        this.nim = nim;
        this.jurusan = jurusan;
        this.email = email;
        this.password = password;
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

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "Student{"+
                "id="+id+
                ",name='"+name+'\''+
                ",nim='"+nim+'\''+
                ",jurusan='"+jurusan+'\''+
                ",email='"+email+'\''+
                ",password='"+password+'\''+'}';
    }
}
