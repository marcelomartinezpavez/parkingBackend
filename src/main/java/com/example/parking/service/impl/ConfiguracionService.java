package com.example.parking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.parking.model.Configuracion;
import com.example.parking.repo.ConfiguracionRepository;

@Service
public class ConfiguracionService {

    @Autowired
    private ConfiguracionRepository configuracionRepository;

    public Configuracion guardarConfiguracion(Configuracion configuracion) {
        return configuracionRepository.save(configuracion);
    }

    public Optional<Configuracion> obtenerPorId(Long id) {
        return configuracionRepository.findById(id);
    }

    public List<Configuracion> listarTodas() {
        return configuracionRepository.findAll();
    }

    public void eliminarConfiguracion(Long id) {
        configuracionRepository.deleteById(id);
    }
}
