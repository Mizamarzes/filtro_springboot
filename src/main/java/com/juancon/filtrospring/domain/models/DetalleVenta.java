package com.juancon.filtrospring.domain.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name="detalles_ventas")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "bicicleta_id")
    private Bicicleta bicicleta_id;

    @OneToOne(cascade=CascadeType.REMOVE)
    @JoinColumn(name = "venta_id")
    private Venta venta_id;

    @Column(columnDefinition="INT", nullable = false)
    private Integer cantidad;

    @Column(columnDefinition = "DECIMAL(10,2)", nullable=false)
    private Float precio_unitario;



}
