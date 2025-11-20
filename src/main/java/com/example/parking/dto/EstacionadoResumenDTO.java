package com.example.parking.dto;

import java.util.List;

import com.example.parking.model.Estacionado;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstacionadoResumenDTO {

    private List<Estacionado> estacionados;

    private double totalRecaudado;
    private int totalTransacciones;

    private double totalDebito;
    private int transaccionesDebito;

    private double totalCredito;
    private int transaccionesCredito;

    private double totalEfectivo;
    private int transaccionesEfectivo;

    private double totalTarjeta;
    private int transaccionesTarjeta;

    // Getters y setters o usar @Data si usas Lombok

}