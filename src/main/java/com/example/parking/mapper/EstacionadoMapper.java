package com.example.parking.mapper;

import com.example.parking.dto.EstacionadoDTO;
import com.example.parking.model.Estacionado;
import com.example.parking.model.Estacionamiento;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface EstacionadoMapper {

    @Mapping(source = "estacionamiento.id", target = "estacionamientoId")
    EstacionadoDTO toDto(Estacionado entity);

    @Mapping(target = "estacionamiento", expression = "java(estacionamientoFromId(dto.getEstacionamientoId()))")
    Estacionado toEntity(EstacionadoDTO dto);

    default Estacionamiento estacionamientoFromId(Long id) {
        if (id == null)
            return null;
        return Estacionamiento.builder().id(id).build();
    }
}