package com.juancon.filtrospring.domain.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name="modelo")
public class Modelo {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(100)", nullable= false, length=100)
    private String nombre;

    @Column(columnDefinition = "VARCHAR(200)", nullable= false, length=200)
    private String descripcion;

    @OneToMany(targetEntity=Bicicleta.class, mappedBy="modelo")
    private List<Bicicleta> bicicletas;
}
