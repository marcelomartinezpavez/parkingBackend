package com.example.parking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parking.model.Estacionado;

import com.example.parking.repo.EstacionadoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EstacionadoService {

    @Autowired
    private EstacionadoRepository estacionadoRepository;

    public Estacionado guardarEstacionado(Estacionado estacionado) {
        return estacionadoRepository.save(estacionado);
    }

    public Optional<Estacionado> obtenerPorId(Long id) {
        return estacionadoRepository.findById(id);
    }

    public List<Estacionado> listarTodos() {
        return estacionadoRepository.findAll();
    }

    public void eliminarEstacionado(Long id) {
        estacionadoRepository.deleteById(id);
    }

    public List<Estacionado> buscarPorEstado(Estacionado.EstadoEstacionamiento estado) {
        return estacionadoRepository.findByEstado(estado);
    }

    public Estacionado buscarPorEstadoYPatente(Estacionado.EstadoEstacionamiento estado, String patente) {
        return estacionadoRepository.findByEstadoAndPatente(estado, patente);
    }

}
