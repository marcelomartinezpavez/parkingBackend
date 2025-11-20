package com.example.parking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parking.model.Estacionamiento;
import com.example.parking.repo.EstacionamientoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EstacionamientoService {

    @Autowired
    private EstacionamientoRepository estacionamientoRepository;

    public Estacionamiento guardarEstacionamiento(Estacionamiento estacionamiento) {
        return estacionamientoRepository.save(estacionamiento);
    }

    public Optional<Estacionamiento> obtenerPorId(Long id) {
        return estacionamientoRepository.findById(id);
    }

    public List<Estacionamiento> listarTodos() {
        return estacionamientoRepository.findAll();
    }

    public void eliminarEstacionamiento(Long id) {
        estacionamientoRepository.deleteById(id);
    }

    public List<Estacionamiento> buscarPorCuposDisponibles(int cuposMinimos) {
        return estacionamientoRepository.findByCantidadLibre(cuposMinimos);
    }
}
