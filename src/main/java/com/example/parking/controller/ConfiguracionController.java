package com.example.parking.controller;

import com.example.parking.dto.ConfiguracionDTO;
import com.example.parking.mapper.ConfiguracionMapper;
import com.example.parking.model.Configuracion;
import com.example.parking.repo.ConfiguracionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/configuraciones")
// @CrossOrigin(origins = "http://186.64.113.173")
@CrossOrigin(origins = "${parking.server.url}")
// @CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class ConfiguracionController {

    private final ConfiguracionRepository repository;
    private final ConfiguracionMapper mapper;

    @GetMapping
    public List<ConfiguracionDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ConfiguracionDTO create(@RequestBody ConfiguracionDTO dto) {
        Configuracion entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @GetMapping("/{id}")
    public ConfiguracionDTO getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("No encontrado"));
    }

    @PutMapping("/{id}")
    public ConfiguracionDTO update(@PathVariable Long id, @RequestBody ConfiguracionDTO dto) {
        Configuracion entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}