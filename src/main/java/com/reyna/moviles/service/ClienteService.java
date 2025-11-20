package com.reyna.moviles.service;

import com.reyna.moviles.domain.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    Cliente create(Cliente cliente);

    Cliente update(Cliente cliente);

    void delete(Long id);

    Optional<Cliente> read(Long id);

    List<Cliente> readAll();
}