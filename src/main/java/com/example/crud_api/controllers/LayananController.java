package com.example.crud_api.controllers;

import com.example.crud_api.models.Layanan;
import com.example.crud_api.services.LayananService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/layanan")
public class LayananController {
    private final LayananService layananService;

    public LayananController(LayananService layananService) {
        this.layananService = layananService;
    }
//    getAll
    @GetMapping("/all")
    public ResponseEntity<List<Layanan>> getAllLayanan(){
        try {
            List<Layanan> layanans = layananService.getAllLayanan();
            return new ResponseEntity<>(layanans,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
//    getById
    @GetMapping("/find/{id}")
    public ResponseEntity<Layanan> getLayananById(@PathVariable("id") Long id){
        try {
            Layanan layanan = layananService.getLayananById(id);
            return new ResponseEntity<>(layanan, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
//    post
    @PostMapping("/add")
    public ResponseEntity<Layanan> addLayanan(@RequestBody Layanan layanan){
//        try {
//         Layanan layanan1 = layananService.addLayanan(layanan);
//            return new ResponseEntity<>(layanan1,HttpStatus.CREATED);
//        }catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
        Layanan layanan1 = layananService.addLayanan(layanan);
        return new ResponseEntity<>(layanan1,HttpStatus.OK);
    }
//    update
    @PutMapping("/update/{id}")
    public ResponseEntity<Layanan> updateLayanan(@PathVariable("id") Long id, @RequestBody Layanan layanan){
        return new ResponseEntity<Layanan>(layananService.updateLayanan(id,layanan),HttpStatus.OK);
    }
//    delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Layanan> deleteLayananById(@PathVariable("id") Long id){
        layananService.deleteLayanan(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
