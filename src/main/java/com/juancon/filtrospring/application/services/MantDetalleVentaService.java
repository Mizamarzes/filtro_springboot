package com.juancon.filtrospring.application.services;

import java.util.List;
import java.util.Optional;

import com.juancon.filtrospring.domain.models.DetalleVenta;

public interface MantDetalleVentaService {

    Optional<DetalleVenta> findById(Long id);

    List<DetalleVenta> findAll();

    DetalleVenta save(DetalleVenta detalleVenta);

    DetalleVenta update(Long id, DetalleVenta detalleVenta);

    void deleteById(Long id);
}
