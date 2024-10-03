package com.unisales.microservicousuario.controllers;

import com.unisales.microservicousuario.domain.Cliente;
import com.unisales.microservicousuario.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping
    public List<Cliente> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody @Valid Cliente cliente) {
        return service.save(cliente);
    }

    @PutMapping("/{id}")
    public Cliente update(@PathVariable Long id, @RequestBody @Valid Cliente cliente) {
        return service.update(id, cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}