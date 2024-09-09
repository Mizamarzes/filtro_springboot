package com.juancon.filtrospring.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="repuestos")
public class Repuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT")
    private Long id;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String nombre;

    @Column(columnDefinition = "VARCHAR(200)", nullable = false)
    private String descripcion;

    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private Float precio;

    @Column(columnDefinition = "INT", nullable = false)
    private int stock;

    @ManyToOne
    @JoinColumn(name = "proveedorId")
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "modelo")
    private Modelo modelo;

    @ManyToOne
    @JoinColumn(name = "marca")
    private Marca marca;

}
