package com.example.parking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estacionamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cantidad_libre")
    private int cantidadLibre;

    @Column(name = "cantidad_ocupado")
    private int cantidadOcupado;

    @Column(name = "cantidad_total")
    private int cantidadTotal;

    @Column(nullable = false)
    private boolean habilitado;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

}
