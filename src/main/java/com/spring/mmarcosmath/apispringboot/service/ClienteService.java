package com.spring.mmarcosmath.apispringboot.service;

import java.util.List;
import java.util.Optional;

import com.spring.mmarcosmath.apispringboot.model.Cliente;
import com.spring.mmarcosmath.apispringboot.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente save(Cliente cliente) {
        Optional<Cliente> clienteAfter = clienteRepository.findById(cliente.getId());
        if (clienteAfter.isPresent()) {
            Cliente clienteUpadate = clienteAfter.get();
            clienteUpadate.setNome(cliente.getNome());
            clienteUpadate.setEndereco(cliente.getEndereco());
            clienteUpadate.setTelefone(cliente.getTelefone());
            return clienteRepository.save(clienteUpadate);
        }
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(String id) {
        return clienteRepository.findById(id);
    }

    public void deleteById(String id) {
        clienteRepository.deleteById(id);
    }

}
