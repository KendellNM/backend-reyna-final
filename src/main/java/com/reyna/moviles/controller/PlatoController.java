package com.reyna.moviles.controller;

import com.reyna.moviles.domain.Plato;
import com.reyna.moviles.exception.ResourceNotFoundException;
import com.reyna.moviles.service.PlatoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("api/plato")
public class PlatoController {

    @Autowired
    private PlatoService platoService;

    @GetMapping
    public ResponseEntity<List<Plato>> readAll() {
        List<Plato> platos = platoService.readAll();
        return new ResponseEntity<>(platos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Plato> create(@Valid @RequestBody Plato plato) {
        plato.setIdPlato(null); // Asegurar que sea un nuevo registro
        Plato platoCreated = platoService.create(plato);
        return new ResponseEntity<>(platoCreated, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plato> getById(@PathVariable("id") Long id) {
        Plato plato = platoService.read(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plato no encontrado con id: " + id));
        return new ResponseEntity<>(plato, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        platoService.read(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plato no encontrado con id: " + id));
        platoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plato> update(@PathVariable("id") Long id, @Valid @RequestBody Plato plato) {
        platoService.read(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plato no encontrado con id: " + id));
        plato.setIdPlato(id);
        Plato platoUpdated = platoService.update(plato);
        return new ResponseEntity<>(platoUpdated, HttpStatus.OK);
    }
}