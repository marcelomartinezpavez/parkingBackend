package com.example.parking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.parking.model.Configuracion;

@Repository
public interface ConfiguracionRepository extends JpaRepository<Configuracion, Long> {
    // Puedes agregar métodos personalizados si lo necesitas

    // Optional<Configuracion> findByIdEmpresa(long empresaId);
}
