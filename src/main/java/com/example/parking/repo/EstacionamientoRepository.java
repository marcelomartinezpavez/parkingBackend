package com.example.parking.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.parking.model.Estacionamiento;

@Repository
public interface EstacionamientoRepository extends JpaRepository<Estacionamiento, Long> {
    // Ejemplo: buscar por cupos disponibles
    List<Estacionamiento> findByCantidadLibre(int cantidadLibre);
}
