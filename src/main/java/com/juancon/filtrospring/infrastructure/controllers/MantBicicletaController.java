package com.juancon.filtrospring.infrastructure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juancon.filtrospring.application.services.MantBicicletaService;
import com.juancon.filtrospring.domain.models.Bicicleta;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mant-bicicleta")
public class MantBicicletaController {

    @Autowired
    private MantBicicletaService mantBicicletaService;

    @GetMapping
    public ResponseEntity<List<Bicicleta>> findAll(){
        List<Bicicleta> bicicletas = mantBicicletaService.findAll();
        return new ResponseEntity<>(bicicletas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bicicleta> showBicicleta(@PathVariable Long id){
        return mantBicicletaService.findById(id)
            .map(bicicleta -> new ResponseEntity<>(bicicleta, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Bicicleta> saveBicicleta(@RequestBody Bicicleta bicicleta) {
        Bicicleta newBicicleta = mantBicicletaService.save(bicicleta);
        return new ResponseEntity<>(newBicicleta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bicicleta> updateBicicleta(@PathVariable Long id, @RequestBody Bicicleta bicicleta) {
        Bicicleta updateBicicleta = mantBicicletaService.update(id, bicicleta);
        if (updateBicicleta != null) {
            return  new ResponseEntity<>(updateBicicleta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBicicleta(@PathVariable Long id) {
        if(mantBicicletaService.findById(id).isPresent()) {
            mantBicicletaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
