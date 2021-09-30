package com.spring.mmarcosmath.apispringboot.controller;

import java.util.List;

import com.spring.mmarcosmath.apispringboot.model.Pet;
import com.spring.mmarcosmath.apispringboot.service.PetService;
import com.spring.mmarcosmath.apispringboot.utils.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping("/pet")
    public Pet save(@RequestBody Pet pet) {
        return petService.save(pet);
    }

    @GetMapping("/pet")
    public List<Pet> findAll() {
        return petService.findAll();
    }

    @GetMapping("/pet/{id}")
    public Pet findById(@PathVariable String id) {
        return petService.findById(id).get();
    }

    @GetMapping("/pet/status")
    public List<Pet> findByStatus(@RequestParam("status") Status status) {
        return petService.findByStatus(status);
    }

    @DeleteMapping("/pet/{id}")
    public void deleteById(@PathVariable String id) {
        petService.deleteById(id);
    }

    @PutMapping("/pet")
    public Pet update(@RequestBody Pet pet) {
        return petService.save(pet);
    }
}
