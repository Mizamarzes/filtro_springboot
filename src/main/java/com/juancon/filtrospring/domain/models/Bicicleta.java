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
@Table(name="bicicletas")
public class Bicicleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(targetEntity=Modelo.class)
    @JoinColumn(name = "modelo")
    private Modelo modelo;

    @ManyToOne(targetEntity=Marca.class)
    @JoinColumn(name = "marca")
    private Marca marca;

    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private Float precio;

    @Column(columnDefinition = "INT", nullable = false)
    private int stock;

}
