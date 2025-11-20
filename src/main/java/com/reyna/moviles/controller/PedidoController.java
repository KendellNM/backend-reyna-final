package com.reyna.moviles.controller;

import com.reyna.moviles.domain.Pedido;
import com.reyna.moviles.exception.ResourceNotFoundException;
import com.reyna.moviles.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> readAll() {
        List<Pedido> pedidos = pedidoService.readAll();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pedido> create(@Valid @RequestBody Pedido pedido) {
        pedido.setIdPedido(null); // Asegurar que sea un nuevo registro
        Pedido pedidoCreated = pedidoService.create(pedido);
        return new ResponseEntity<>(pedidoCreated, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getById(@PathVariable("id") Long id) {
        Pedido pedido = pedidoService.read(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado con id: " + id));
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        pedidoService.read(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado con id: " + id));
        pedidoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> update(@PathVariable("id") Long id, @Valid @RequestBody Pedido pedido) {
        pedidoService.read(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado con id: " + id));
        pedido.setIdPedido(id);
        Pedido pedidoUpdated = pedidoService.update(pedido);
        return new ResponseEntity<>(pedidoUpdated, HttpStatus.OK);
    }
}