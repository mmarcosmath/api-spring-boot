package com.spring.mmarcosmath.apispringboot.service;

import java.util.List;
import java.util.Optional;

import com.spring.mmarcosmath.apispringboot.model.Pet;
import com.spring.mmarcosmath.apispringboot.model.Cliente;
import com.spring.mmarcosmath.apispringboot.repository.ClienteRepository;
import com.spring.mmarcosmath.apispringboot.repository.PetRepository;
import com.spring.mmarcosmath.apispringboot.utils.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Pet save(Pet pet) {
        Optional<Pet> petAfter = petRepository.findById(pet.getId());
        if (petAfter.isPresent()) {
            Pet petUpadate = petAfter.get();
            Cliente cliente = clienteRepository.findById(petUpadate.getCliente().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Cliente não existe"));
            petUpadate.setNome(pet.getNome());
            petUpadate.setStatus(pet.getStatus());
            petUpadate.setCliente(cliente);
            return petRepository.save(petUpadate);
        }
        Cliente cliente = clienteRepository.findById(pet.getCliente().getId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não existe"));
        pet.setCliente(cliente);
        return petRepository.save(pet);
    }

    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    public List<Pet> findByStatus(Status status) {
        return petRepository.findByStatus(status);
    }

    public Optional<Pet> findById(String id) {
        return petRepository.findById(id);
    }

    public void deleteById(String id) {
        petRepository.deleteById(id);
    }

}
