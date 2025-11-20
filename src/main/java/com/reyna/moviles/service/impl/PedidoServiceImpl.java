package com.reyna.moviles.service.impl;

import com.reyna.moviles.dao.PedidoDao;
import com.reyna.moviles.domain.Pedido;
import com.reyna.moviles.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoDao pedidoDao;

    @Override
    public Pedido create(Pedido pedido) {
        return pedidoDao.create(pedido);
    }

    @Override
    public Pedido update(Pedido pedido) {
        return pedidoDao.update(pedido);
    }

    @Override
    public void delete(Long id) {
        pedidoDao.delete(id);
    }

    @Override
    public Optional<Pedido> read(Long id) {
        return pedidoDao.read(id);
    }

    @Override
    public List<Pedido> readAll() {
        return pedidoDao.readAll();
    }
}