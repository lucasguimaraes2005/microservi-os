package com.unisales.microservicoproduto.controllers;

import com.unisales.microservicoproduto.domain.Produto;
import com.unisales.microservicoproduto.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<Produto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Produto findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/search")
    public List<Produto> findByNome(@RequestParam String nome) {
        return service.findByNome(nome);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto save(@RequestBody @Valid Produto produto) {
        return service.save(produto);
    }

    @PutMapping("/{id}")
    public Produto update(@PathVariable Long id, @RequestBody @Valid Produto produto) {
        return service.update(id, produto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
