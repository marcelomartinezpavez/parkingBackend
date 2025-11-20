package com.example.parking.mapper;

import com.example.parking.dto.ConfiguracionDTO;
import com.example.parking.model.Configuracion;
import com.example.parking.model.Estacionamiento;

import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ConfiguracionMapper {
    @Mapping(source = "estacionamiento.id", target = "estacionamientoId")
    ConfiguracionDTO toDto(Configuracion entity);

    @Mapping(source = "estacionamientoId", target = "estacionamiento.id")
    Configuracion toEntity(ConfiguracionDTO dto);

    default Estacionamiento estacionamientoFromId(Long id) {
        if (id == null)
            return null;
        return Estacionamiento.builder().id(id).build();
    }

}