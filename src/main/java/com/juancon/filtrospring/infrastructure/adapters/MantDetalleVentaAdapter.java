package com.juancon.filtrospring.infrastructure.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juancon.filtrospring.application.services.MantDetalleVentaService;
import com.juancon.filtrospring.domain.models.DetalleVenta;
import com.juancon.filtrospring.infrastructure.repositories.MantDetalleVentaRepository;

@Service
public class MantDetalleVentaAdapter implements MantDetalleVentaService {

    @Autowired
    private MantDetalleVentaRepository mantDetalleVentaRepository;

    @Override
    public Optional<DetalleVenta> findById(Long id) {
        return mantDetalleVentaRepository.findById(id);
    }

    @Override
    public List<DetalleVenta> findAll() {
        return mantDetalleVentaRepository.findAll();
    }

    @Override
    public DetalleVenta save(DetalleVenta detalleVenta) {
        return mantDetalleVentaRepository.save(detalleVenta);
    }

    @Override
    public DetalleVenta update(Long id, DetalleVenta detalleVenta) {
        return mantDetalleVentaRepository.findById(id)
            .map(detalleventaexists -> {
                detalleventaexists.setBicicleta_id(detalleVenta.getBicicleta_id());
                detalleventaexists.setVenta_id(detalleVenta.getVenta_id());
                detalleventaexists.setCantidad(detalleVenta.getCantidad());
                detalleventaexists.setPrecio_unitario(detalleVenta.getPrecio_unitario());
                return mantDetalleVentaRepository.save(detalleventaexists);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
    }

}
