package com.spring.mmarcosmath.apispringboot.model;

import com.spring.mmarcosmath.apispringboot.utils.Status;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "Pets")
@Data
public class Pet {
    @Id
    private String id;
    private String nome;
    private Status status;
    private Cliente cliente;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        if (status != null)
            this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        if (cliente != null)
            this.cliente = cliente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null)
            this.nome = nome;
    }

}
