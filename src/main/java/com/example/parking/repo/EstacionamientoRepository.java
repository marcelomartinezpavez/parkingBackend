package com.example.parking.repo;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.parking.model.Estacionamiento;

@Repository
public interface EstacionamientoRepository extends JpaRepository<Estacionamiento, Long> {
    // Ejemplo: buscar por cupos disponibles
    List<Estacionamiento> findByCantidadLibre(int cantidadLibre);

    @Lock(jakarta.persistence.LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT e FROM Estacionamiento e WHERE e.id = :id")
    Estacionamiento findByIdForUpdate(@Param("id") Long id);

}
