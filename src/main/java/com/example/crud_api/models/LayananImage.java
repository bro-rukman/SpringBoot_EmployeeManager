package com.example.crud_api.models;

import javax.persistence.*;

@Entity
public class LayananImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Layanan layanan;
    @Lob
    private String base64;
    private String contentType;

    public LayananImage(Long id, Layanan layanan, String base64, String contentType) {
        this.id = id;
        this.layanan = layanan;
        this.base64 = base64;
        this.contentType = contentType;
    }

    public LayananImage() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Layanan getLayanan() {
        return layanan;
    }

    public void setLayanan(Layanan layanan) {
        this.layanan = layanan;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }


}
