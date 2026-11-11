package com.example.parking.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
