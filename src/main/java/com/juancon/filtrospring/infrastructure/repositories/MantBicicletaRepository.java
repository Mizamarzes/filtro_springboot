package com.juancon.filtrospring.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juancon.filtrospring.domain.models.Bicicleta;

public interface MantBicicletaRepository extends JpaRepository<Bicicleta, Long> {

}
