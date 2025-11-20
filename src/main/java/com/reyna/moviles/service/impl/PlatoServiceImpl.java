package com.reyna.moviles.service.impl;

import com.reyna.moviles.dao.PlatoDao;
import com.reyna.moviles.domain.Plato;
import com.reyna.moviles.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatoServiceImpl implements PlatoService {

    @Autowired
    private PlatoDao platoDao;

    @Override
    public Plato create(Plato plato) {
        return platoDao.create(plato);
    }

    @Override
    public Plato update(Plato plato) {
        return platoDao.update(plato);
    }

    @Override
    public void delete(Long id) {
        platoDao.delete(id);
    }

    @Override
    public Optional<Plato> read(Long id) {
        return platoDao.read(id);
    }

    @Override
    public List<Plato> readAll() {
        return platoDao.readAll();
    }
}