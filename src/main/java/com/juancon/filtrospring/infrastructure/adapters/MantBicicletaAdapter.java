package com.juancon.filtrospring.infrastructure.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juancon.filtrospring.application.services.MantBicicletaService;
import com.juancon.filtrospring.domain.models.Bicicleta;
import com.juancon.filtrospring.infrastructure.repositories.MantBicicletaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MantBicicletaAdapter implements MantBicicletaService{

    @Autowired
    private MantBicicletaRepository mantBicicletaRepository;

    @Override
    public Optional<Bicicleta> findById(Long id) {
        return mantBicicletaRepository.findById(id);
    }

    @Override
    public List<Bicicleta> findAll() {
        return mantBicicletaRepository.findAll();
    }

    @Override
    public Bicicleta save(Bicicleta bicicleta) {
        return mantBicicletaRepository.save(bicicleta);
    }

    @Override
    public Bicicleta update(Long id, Bicicleta bicicleta) {
        return mantBicicletaRepository.findById(id)
            .map(bicicletaexist -> {
                bicicletaexist.setModelo(bicicleta.getModelo());
                bicicletaexist.setMarca(bicicleta.getMarca());
                bicicletaexist.setPrecio(bicicleta.getPrecio());
                bicicletaexist.setStock(bicicleta.getStock());
                return mantBicicletaRepository.save(bicicletaexist);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        mantBicicletaRepository.deleteById(id);
    }

}
