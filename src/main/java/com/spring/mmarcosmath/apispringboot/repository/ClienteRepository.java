package com.spring.mmarcosmath.apispringboot.repository;

import com.spring.mmarcosmath.apispringboot.model.Cliente;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

}
