package com.juancon.filtrospring.domain.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="ciudades")
public class Ciudad {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition= "VARCHAR(100)", nullable = false)
    private String nombre;

    @ManyToOne(targetEntity=Pais.class)
    @JoinColumn(name = "pais_id")
    private Pais pais_id;

    @OneToMany(targetEntity=Proveedor.class, mappedBy="ciudad")
    private List<Proveedor> proveedores;

    @OneToMany(targetEntity=Cliente.class, mappedBy="ciudad_id")
    private List<Cliente> clientes;


}
