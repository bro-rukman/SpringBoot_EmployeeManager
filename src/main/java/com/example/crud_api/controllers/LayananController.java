package com.example.crud_api.controllers;

import com.example.crud_api.exceptions.LayananBadRequestException;
import com.example.crud_api.exceptions.LayananNotFoundException;
import com.example.crud_api.models.Layanan;
import com.example.crud_api.models.LayananImage;
import com.example.crud_api.services.LayananService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        List<Layanan> layanans = layananService.getAllLayanan();
        return new ResponseEntity<>(layanans, HttpStatus.OK);
    }
//    getById
    @GetMapping("/find/{id}")
    public ResponseEntity<Layanan> getLayananById(@PathVariable("id") Long id) throws LayananNotFoundException{
        Layanan layanan = layananService.getLayananById(id);
        return new ResponseEntity<>(layanan, HttpStatus.OK);
    }
//    post
    @PostMapping("/add")
    public ResponseEntity<Layanan> addLayanan(@Valid @RequestBody Layanan layanan) throws MethodArgumentNotValidException {
        Layanan layanan1 = layananService.addLayanan(layanan);
        return new ResponseEntity<>(layanan1,HttpStatus.CREATED);
    }
//    postImage
//    @PostMapping("/addImage")
//    public ResponseEntity<LayananImage> addLayananImage(@Valid @RequestBody LayananImage layananImage){
//        LayananImage layananImage1 = layananService.UploadImage(layananImage);
//    }
//    update
    @PutMapping("/update/{id}")
    public ResponseEntity<Layanan> updateLayanan(@PathVariable("id") Long id, @Valid @RequestBody Layanan layanan){
        return new ResponseEntity<Layanan>(layananService.updateLayanan(id,layanan),HttpStatus.OK);
    }
//    delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Layanan> deleteLayananById(@PathVariable("id") Long id) throws LayananNotFoundException{
        layananService.deleteLayanan(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
