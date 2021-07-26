package com.example.crud_api.services;

import com.example.crud_api.exceptions.LayananNotFoundException;
import com.example.crud_api.models.Layanan;
import com.example.crud_api.models.LayananImage;
import com.example.crud_api.repos.LayananImageRepo;
import com.example.crud_api.repos.LayananRepo;
import com.example.crud_api.wrappers.LayananImageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class LayananService {
    private final Layanan layanan = new Layanan();
//    private final LayananImage layananImage = new LayananImage();
    @Autowired
    private LayananImageRepo layananImageRepo;
    @Autowired
    private LayananRepo layananRepo;
    public LayananService(LayananRepo layananRepo) {
        this.layananRepo = layananRepo;
    }
//    post
    public Layanan addLayanan(Layanan layanan){
        return layananRepo.save(layanan);
    }
//    getall
    public List<Layanan> getAllLayanan(){
        return layananRepo.findAll();
    }
//    getById
    public Layanan getLayananById(Long id){
        return layananRepo.findById(id).orElseThrow(()-> new LayananNotFoundException("Layanan dengan id "+id+ "tidak ditemukan !"));
    }
//    update
    public Layanan updateLayanan(Long id, Layanan layanan){
        Layanan layanan1 = layananRepo.findById(id).orElseThrow(()->new LayananNotFoundException("Layanan dengan id "+id+ "tidak ditemukan !"));
        layanan1.setTitle(layanan.getTitle());
        layanan1.setDescription(layanan.getDescription());
        return layananRepo.save(layanan1);
    }
//    delete
    public void deleteLayanan(Long id) {
        layananRepo.findById(id).orElseThrow(()-> new LayananNotFoundException("Layanan no " + id + "tidak ditemukan !"));
        layananRepo.deleteById(id);
    }
//    public LayananImage UploadImage(@Valid LayananImage layananImageWrapper){
//        LayananImage layananImage = new LayananImage();
//        layananImage.setLayanan(layananRepo.findById(layananImageWrapper.getImageId()).get());
//        layananImage.setContentType(layananImageWrapper.getContentType());
//        layananImage.setBase64(layananImageWrapper.getBase64());
//        return layananImageRepo.save(layananImage);
//    }
}
