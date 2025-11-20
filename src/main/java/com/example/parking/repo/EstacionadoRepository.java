package com.example.parking.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.parking.model.Estacionado;

@Repository
public interface EstacionadoRepository extends JpaRepository<Estacionado, Long> {
    List<Estacionado> findByEstado(Estacionado.EstadoEstacionamiento estado);

    Estacionado findByEstadoAndPatente(Estacionado.EstadoEstacionamiento estadoEnum, String patente);

    List<Estacionado> findByFechaIngresoBetween(LocalDateTime from, LocalDateTime to);

}
