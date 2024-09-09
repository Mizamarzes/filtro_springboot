package com.juancon.filtrospring.application.services;

import java.util.List;
import java.util.Optional;

import com.juancon.filtrospring.domain.models.Bicicleta;

public interface MantBicicletaService {

    Optional<Bicicleta> findById(Long id);

    List<Bicicleta> findAll();

    Bicicleta save(Bicicleta bicicleta);

    Bicicleta update(Long id, Bicicleta bicicleta);

    void deleteById(Long id);

}
