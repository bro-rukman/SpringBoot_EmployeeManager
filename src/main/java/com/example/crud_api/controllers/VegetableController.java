package com.example.crud_api.controllers;

import com.example.crud_api.models.Vegetable;
import com.example.crud_api.services.VegetableService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/vegetable")
public class VegetableController {

    private final VegetableService vegetableService;

    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Vegetable>> getAllVegetable(){
        List<Vegetable> vegetables = vegetableService.findAllVegetable();
        return new ResponseEntity<>(vegetables, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Vegetable> getVegetableById(@PathVariable("id") Long id){
        Vegetable vegetable = vegetableService.findVegetableById(id);
        return new ResponseEntity<>(vegetable,HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Vegetable> addProduct(@RequestBody Vegetable vegetable){
        Vegetable vegetable1 = vegetableService.addVegetable(vegetable);
        return new ResponseEntity<>(vegetable1, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Vegetable> updateProduct(Vegetable vegetable){
        Vegetable vegetable2 = vegetableService.updateVegetable(vegetable);
        return new ResponseEntity<>(vegetable2,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Vegetable> deleteVegetable(@PathVariable("id") Long id){
        vegetableService.deleteVegetable(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
