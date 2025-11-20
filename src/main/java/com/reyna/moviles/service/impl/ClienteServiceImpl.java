package com.reyna.moviles.service.impl;

import com.reyna.moviles.dao.ClienteDao;
import com.reyna.moviles.domain.Cliente;
import com.reyna.moviles.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;

    @Override
    public Cliente create(Cliente cliente) {
        return clienteDao.create(cliente);
    }

    @Override
    public Cliente update(Cliente cliente) {
        return clienteDao.update(cliente);
    }

    @Override
    public void delete(Long id) {
        clienteDao.delete(id);
    }

    @Override
    public Optional<Cliente> read(Long id) {
        return clienteDao.read(id);
    }

    @Override
    public List<Cliente> readAll() {
        return clienteDao.readAll();
    }
}