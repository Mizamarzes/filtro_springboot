package com.juancon.filtrospring.infrastructure.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juancon.filtrospring.application.services.MantVentaService;
import com.juancon.filtrospring.domain.models.Venta;
import com.juancon.filtrospring.infrastructure.repositories.MantVentaRepository;

@Service
public class MantVentaAdapter implements MantVentaService{

    @Autowired
    private MantVentaRepository mantVentaRepository;

    @Override
    public Optional<Venta> findById(Long id) {
        return mantVentaRepository.findById(id);
    }

    @Override
    public List<Venta> findAll() {
        return mantVentaRepository.findAll();
    }

    @Override
    public Venta save(Venta venta) {
        return mantVentaRepository.save(venta);
    }

    @Override
    public Venta update(Long id, Venta venta) {
        return mantVentaRepository.findById(id)
            .map(ventaexists -> {
                ventaexists.setFecha(venta.getFecha());
                ventaexists.setCliente_id(venta.getCliente_id());
                return mantVentaRepository.save(ventaexists);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        mantVentaRepository.deleteById(id);
    }

}
