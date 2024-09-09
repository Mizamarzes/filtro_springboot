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
@Table(name="clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition="VARCHAR(100)", nullable=false)
    private String nombre;

    @Column(columnDefinition="VARCHAR(100)", nullable=false)
    private String email;

    @Column(columnDefinition="BIGINT", nullable=false)
    private Integer telefono;

    @Column(columnDefinition = "VARCHAR(100)", nullable= false)
    private String password;

    @ManyToOne(targetEntity=Ciudad.class)
    @JoinColumn(name= "ciudad_id")
    private Ciudad ciudad_id;

    @OneToMany(targetEntity=Venta.class, mappedBy="cliente_id")
    private List<Venta> ventas;

}
