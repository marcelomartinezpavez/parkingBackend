package com.example.parking.controller;

import com.example.parking.dto.EstacionamientoDTO;
import com.example.parking.mapper.EstacionamientoMapper;
import com.example.parking.model.Estacionamiento;
import com.example.parking.repo.EstacionamientoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/estacionamientos")
@CrossOrigin(origins = "${parking.server.url}")
// @CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class EstacionamientoController {
    private final EstacionamientoRepository repository;
    private final EstacionamientoMapper mapper;

    @GetMapping
    public List<EstacionamientoDTO> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @PostMapping
    public EstacionamientoDTO create(@RequestBody EstacionamientoDTO dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @GetMapping("/{id}")
    public EstacionamientoDTO getById(@PathVariable Long id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow();
    }

    @PutMapping("/{id}")
    public EstacionamientoDTO update(@PathVariable Long id, @RequestBody EstacionamientoDTO dto) {
        Estacionamiento entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}