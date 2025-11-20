package com.example.parking.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConfiguracionDTO {
    private Long id;
    private boolean habilitado;
    private int valorDia;
    private int valorHora;
    private int valorMes;
    private int valorMinuto;
    private int tiempoMinimoMinutos;
    private int valorMinimo;
    private int tiempoAumento;
    private Long estacionamientoId;
}