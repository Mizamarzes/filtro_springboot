package com.juancon.filtrospring.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juancon.filtrospring.domain.models.DetalleVenta;

public interface MantDetalleVentaRepository extends JpaRepository<DetalleVenta, Long>{

}
