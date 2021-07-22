package com.example.crud_api.services;

import com.example.crud_api.exceptions.LayananNotFoundException;
import com.example.crud_api.models.Layanan;
import com.example.crud_api.repos.LayananRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LayananService {

    private LayananRepo layananRepo;
    @Autowired
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
        return layananRepo.findById(id).orElseThrow(()-> new LayananNotFoundException("Layanan with id"+id+ "was not found!"));

    }
//    update
    public Layanan updateLayanan(Long id, Layanan layanan){
        Layanan layanan1 = layananRepo.findById(id).orElseThrow(()->new LayananNotFoundException("Layanan with id"+id+ "was not found!"));
        layanan1.setTitle(layanan.getTitle());
        layanan1.setDescription(layanan.getDescription());
        return layananRepo.save(layanan1);
    }
//    delete
    public void deleteLayanan(Long id){
        layananRepo.deleteById(id);
    }
}
