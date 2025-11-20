package com.reyna.moviles.dao;
import com.reyna.moviles.domain.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoDao{
    Pedido create(Pedido pedido);
    Pedido update(Pedido pedido);
    void delete(Long id);
    Optional<Pedido> read(Long id);
    List<Pedido> readAll();
}