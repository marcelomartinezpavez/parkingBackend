package com.example.parking.mapper;

import com.example.parking.dto.EstacionamientoDTO;
import com.example.parking.model.Estacionamiento;
import com.example.parking.model.Empresa;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface EstacionamientoMapper {

    @Mapping(source = "empresa.id", target = "empresaId")
    EstacionamientoDTO toDto(Estacionamiento entity);

    @Mapping(target = "empresa", expression = "java(empresaFromId(dto.getEmpresaId()))")
    Estacionamiento toEntity(EstacionamientoDTO dto);

    default Empresa empresaFromId(Long id) {
        if (id == null)
            return null;
        return Empresa.builder().id(id).build();
    }
}