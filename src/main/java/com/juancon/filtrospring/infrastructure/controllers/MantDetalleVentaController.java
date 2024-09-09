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

import com.juancon.filtrospring.application.services.MantDetalleVentaService;
import com.juancon.filtrospring.domain.models.DetalleVenta;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mant-detalle-venta")
public class MantDetalleVentaController {

    @Autowired
    private MantDetalleVentaService mantDetalleVentaService;

    @GetMapping
    public ResponseEntity<List<DetalleVenta>> findAll(){
        List<DetalleVenta> detalleVentas = mantDetalleVentaService.findAll();
        return new ResponseEntity<>(detalleVentas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleVenta> showDetalleVenta(@PathVariable Long id){
        return mantDetalleVentaService.findById(id)
            .map(detalleventa -> new ResponseEntity<>(detalleventa, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<DetalleVenta> saveDetalleVenta(@RequestBody DetalleVenta detalleVenta) {
        DetalleVenta newDetalleVenta = mantDetalleVentaService.save(detalleVenta);
        return new ResponseEntity<>(newDetalleVenta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleVenta> updateDetalleVenta(@PathVariable Long id, @RequestBody DetalleVenta detalleVenta) {
        DetalleVenta updateDetalleVenta = mantDetalleVentaService.update(id, detalleVenta);
        if (updateDetalleVenta != null) {
            return  new ResponseEntity<>(updateDetalleVenta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetalleVenta(@PathVariable Long id) {
        if(mantDetalleVentaService.findById(id).isPresent()) {
            mantDetalleVentaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
