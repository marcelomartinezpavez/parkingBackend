package com.example.parking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Configuracion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private boolean habilitado;

    @Column(name = "valor_dia")
    private int valorDia;

    @Column(name = "valor_hora")
    private int valorHora;

    @Column(name = "valor_mes")
    private int valorMes;

    @Column(name = "valor_minuto")
    private int valorMinuto;

    @Column(name = "tiempo_minimo_minutos")
    private int tiempoMinimoMinutos;

    @Column(name = "valor_minimo")
    private int valorMinimo;

    @Column(name = "tiempo_aumento")
    private int tiempoAumento;

    @OneToOne
    @JoinColumn(name = "estacionamiento_id", referencedColumnName = "id")
    private Estacionamiento estacionamiento;

}
