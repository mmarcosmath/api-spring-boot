package com.spring.mmarcosmath.apispringboot.repository;

import java.util.List;

import com.spring.mmarcosmath.apispringboot.model.Pet;
import com.spring.mmarcosmath.apispringboot.utils.Status;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PetRepository extends MongoRepository<Pet, String> {
    public List<Pet> findByStatus(Status status);
}
