package com.example.parking.mapper;

import com.example.parking.dto.EstacionamientoDTO;
import com.example.parking.model.Empresa;
import com.example.parking.model.Estacionamiento;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-15T12:27:06-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.100.v20260826-1225, environment: Java 21.0.12.1 (Eclipse Adoptium)"
)
@Component
public class EstacionamientoMapperImpl implements EstacionamientoMapper {

    @Override
    public EstacionamientoDTO toDto(Estacionamiento entity) {
        if ( entity == null ) {
            return null;
        }

        EstacionamientoDTO.EstacionamientoDTOBuilder estacionamientoDTO = EstacionamientoDTO.builder();

        estacionamientoDTO.empresaId( entityEmpresaId( entity ) );
        estacionamientoDTO.cantidadLibre( entity.getCantidadLibre() );
        estacionamientoDTO.cantidadOcupado( entity.getCantidadOcupado() );
        estacionamientoDTO.cantidadTotal( entity.getCantidadTotal() );
        estacionamientoDTO.habilitado( entity.isHabilitado() );
        estacionamientoDTO.id( entity.getId() );

        return estacionamientoDTO.build();
    }

    @Override
    public Estacionamiento toEntity(EstacionamientoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Estacionamiento.EstacionamientoBuilder estacionamiento = Estacionamiento.builder();

        estacionamiento.cantidadLibre( dto.getCantidadLibre() );
        estacionamiento.cantidadOcupado( dto.getCantidadOcupado() );
        estacionamiento.cantidadTotal( dto.getCantidadTotal() );
        estacionamiento.habilitado( dto.isHabilitado() );
        estacionamiento.id( dto.getId() );

        estacionamiento.empresa( empresaFromId(dto.getEmpresaId()) );

        return estacionamiento.build();
    }

    private Long entityEmpresaId(Estacionamiento estacionamiento) {
        if ( estacionamiento == null ) {
            return null;
        }
        Empresa empresa = estacionamiento.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        Long id = empresa.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
