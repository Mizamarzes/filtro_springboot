package com.juancon.filtrospring.application.services;

import java.util.List;
import java.util.Optional;

import com.juancon.filtrospring.domain.models.Venta;

public interface MantVentaService {

    Optional<Venta> findById(Long id);

    List<Venta> findAll();

    Venta save(Venta venta);

    Venta update(Long id, Venta venta);

    void deleteById(Long id);

}
