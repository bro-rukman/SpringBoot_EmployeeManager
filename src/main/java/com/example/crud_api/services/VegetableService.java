package com.example.crud_api.services;

import com.example.crud_api.exceptions.VegetableNotFound;
import com.example.crud_api.models.Vegetable;
import com.example.crud_api.repos.VegetableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VegetableService {
    private final VegetableRepo vegetableRepo;

    @Autowired
    public VegetableService(VegetableRepo vegetableRepo) {
        this.vegetableRepo = vegetableRepo;
    }
//    post
    public Vegetable addVegetable(Vegetable vegetable){
        return vegetableRepo.save(vegetable);
    }
//    get
    public List<Vegetable> findAllVegetable(){
        return vegetableRepo.findAll();
    }
//    update
    public Vegetable updateVegetable(Vegetable vegetable){
        return vegetableRepo.save(vegetable);
    }
//    findById
    public Vegetable findVegetableById(Long id){
        return vegetableRepo.findById(id).orElseThrow(()-> new VegetableNotFound("Vegetable with id"+id+"was no found !"));
    }
//    delete
    public void deleteVegetable(Long id){
        vegetableRepo.deleteById(id);
    }



}
