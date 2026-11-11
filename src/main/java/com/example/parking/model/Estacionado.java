package com.example.parking.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estacionado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estacionamiento_id")
    private Estacionamiento estacionamiento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoEstacionamiento estado;

    @Column(name = "fecha_ingreso")
    private LocalDateTime fechaIngreso;

    @Column(name = "fecha_salida")
    private LocalDateTime fechaSalida;

    @Column(length = 10)
    private String patente;

    @Column(name = "valor_total")
    private double valorTotal;

    @Column(name = "minutos_estacionado")
    private int minutosEstacionado;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_pago")
    private TipoPago tipoPago;

    public enum EstadoEstacionamiento {
        ESTACIONADO,
        COBRADO,
        SALIDA,
        BORRADO
    }

    public enum TipoPago {
        EFECTIVO,
        DEBITO,
        CREDITO
    }

}
