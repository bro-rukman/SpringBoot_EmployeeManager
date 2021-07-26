package com.example.crud_api.services;

import com.example.crud_api.exceptions.LayananNotFoundException;
import com.example.crud_api.models.Layanan;
import com.example.crud_api.repos.LayananRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LayananService {
    private final Layanan layanan = new Layanan();
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
//        try{
//            layananRepo.findById(id);
//            layananRepo.deleteById(id);
//        }catch (LayananNotFoundException exception){
//            throw new  LayananNotFoundException("Layanan dengan id "+id+"tidak ditemukan !");
//        }

        layananRepo.findById(id).orElseThrow(()-> new LayananNotFoundException("Layanan no " + id + "tidak ditemukan !"));
        layananRepo.deleteById(id);
    }
}
