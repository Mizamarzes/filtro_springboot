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

import com.juancon.filtrospring.application.services.MantVentaService;
import com.juancon.filtrospring.domain.models.Venta;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mant-venta")
public class MantVentaController {

    @Autowired
    private MantVentaService mantVentaService;

    @GetMapping
    public ResponseEntity<List<Venta>> findAll(){
        List<Venta> ventas = mantVentaService.findAll();
        return new ResponseEntity<>(ventas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> showVenta(@PathVariable Long id){
        return mantVentaService.findById(id)
            .map(venta -> new ResponseEntity<>(venta, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Venta> saveVenta(@RequestBody Venta venta) {
        Venta newVenta = mantVentaService.save(venta);
        return new ResponseEntity<>(newVenta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> updateVenta(@PathVariable Long id, @RequestBody Venta venta) {
        Venta updateVenta = mantVentaService.update(id, venta);
        if (updateVenta != null) {
            return  new ResponseEntity<>(updateVenta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenta(@PathVariable Long id) {
        if(mantVentaService.findById(id).isPresent()) {
            mantVentaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
