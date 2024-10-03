package com.unisales.microservicousuario.services;

import com.unisales.microservicousuario.domain.Cliente;
import com.unisales.microservicousuario.domain.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new Error("Cliente não encontrado"));
    }

    public Cliente save(Cliente cliente) {
        if (repository.findByCpf(cliente.getCpf()).isPresent()) {
            throw new Error("CPF já cadastrado");
        }
        return repository.save(cliente);
    }

    public Cliente update(Long id, Cliente cliente) {
        Cliente existingCliente = findById(id);
        BeanUtils.copyProperties(cliente, existingCliente, "id");
        return repository.save(existingCliente);
    }

    public void delete(Long id) {
        Cliente cliente = findById(id);
        repository.delete(cliente);
    }
}
