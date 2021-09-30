package com.spring.mmarcosmath.apispringboot.controller;

import java.util.List;

import com.spring.mmarcosmath.apispringboot.model.Cliente;
import com.spring.mmarcosmath.apispringboot.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cliente")
    public Cliente save(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @GetMapping("/cliente")
    public List<Cliente> findAll() {
        return clienteService.findAll();
    }

    @GetMapping("/cliente/{id}")
    public Cliente findById(@PathVariable String id) {
        return clienteService.findById(id).get();
    }

    @DeleteMapping("/cliente/{id}")
    public void deleteById(@PathVariable String id) {
        clienteService.deleteById(id);
    }

    @PutMapping("/cliente")
    public Cliente update(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }
}
