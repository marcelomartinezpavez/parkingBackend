package com.example.parking.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstacionadoDTO {
    private Long id;
    private Long estacionamientoId;
    private String estado;
    private LocalDateTime fechaIngreso;
    private LocalDateTime fechaSalida;
    private String patente;
    private double valorTotal;
    private int minutosEstacionado;
    private String tipoPago;
}