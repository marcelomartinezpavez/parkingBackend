package com.example.parking.controller;

import com.example.parking.dto.EmpresaDTO;
import com.example.parking.mapper.EmpresaMapper;
import com.example.parking.model.Empresa;
import com.example.parking.repo.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/empresas")
@CrossOrigin(origins = "http://186.64.113.173")
// @CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class EmpresaController {
    private final EmpresaRepository repository;
    private final EmpresaMapper mapper;

    @GetMapping
    public List<EmpresaDTO> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @PostMapping
    public EmpresaDTO create(@RequestBody EmpresaDTO dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @GetMapping("/{id}")
    public EmpresaDTO getById(@PathVariable Long id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow();
    }

    @PutMapping("/{id}")
    public EmpresaDTO update(@PathVariable Long id, @RequestBody EmpresaDTO dto) {
        Empresa entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}