package com.example.parking.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstacionamientoDTO {
    private Long id;
    private int cantidadLibre;
    private int cantidadOcupado;
    private int cantidadTotal;
    private boolean habilitado;
    private Long empresaId;

}