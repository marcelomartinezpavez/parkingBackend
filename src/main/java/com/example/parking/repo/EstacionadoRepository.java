package com.example.parking.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.parking.model.Estacionado;

@Repository
public interface EstacionadoRepository extends JpaRepository<Estacionado, Long> {
    List<Estacionado> findByEstado(Estacionado.EstadoEstacionamiento estado);

    Estacionado findByEstadoAndPatente(Estacionado.EstadoEstacionamiento estadoEnum, String patente);

    @Lock(jakarta.persistence.LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT e FROM Estacionado e WHERE e.estado = :estado AND e.patente = :patente")
    Estacionado findByEstadoAndPatenteForUpdate(@Param("estado") Estacionado.EstadoEstacionamiento estadoEnum,
            @Param("patente") String patente);

    List<Estacionado> findByFechaIngresoBetween(LocalDateTime from, LocalDateTime to);

}
