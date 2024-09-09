package com.juancon.filtrospring.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juancon.filtrospring.domain.models.Venta;

public interface MantVentaRepository extends JpaRepository<Venta, Long>{

}
