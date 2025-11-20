package com.reyna.moviles.dao;
import com.reyna.moviles.domain.Plato;

import java.util.List;
import java.util.Optional;

public interface PlatoDao{
    Plato create(Plato plato);
    Plato update(Plato plato);
    void delete(Long id);
    Optional<Plato> read(Long id);
    List<Plato> readAll();
}