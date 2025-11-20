package com.example.parking.mapper;

import com.example.parking.dto.EmpresaDTO;
import com.example.parking.model.Empresa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmpresaMapper {
    EmpresaDTO toDto(Empresa entity);

    Empresa toEntity(EmpresaDTO dto);
}