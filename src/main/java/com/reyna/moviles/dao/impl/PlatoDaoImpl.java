package com.reyna.moviles.dao.impl;

import com.reyna.moviles.dao.PlatoDao;
import com.reyna.moviles.domain.Plato;
import com.reyna.moviles.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PlatoDaoImpl implements PlatoDao {

    @Autowired
    private PlatoRepository platoRepository;

    @Override
    public Plato create(Plato plato) {
        return platoRepository.save(plato);
    }

    @Override
    public Plato update(Plato plato) {
        return platoRepository.save(plato);
    }

    @Override
    public void delete(Long id) {
        platoRepository.deleteById(id);
    }

    @Override
    public Optional<Plato> read(Long id) {
        return platoRepository.findById(id);
    }

    @Override
    public List<Plato> readAll() {
        return platoRepository.findAll();
    }
}