package com.reyna.moviles.dao.impl;

import com.reyna.moviles.dao.PedidoDao;
import com.reyna.moviles.domain.Pedido;
import com.reyna.moviles.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PedidoDaoImpl implements PedidoDao {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public Pedido create(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido update(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public void delete(Long id) {
        pedidoRepository.deleteById(id);
    }

    @Override
    public Optional<Pedido> read(Long id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public List<Pedido> readAll() {
        return pedidoRepository.findAll();
    }
}