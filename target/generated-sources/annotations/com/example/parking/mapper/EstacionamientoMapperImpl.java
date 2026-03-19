package com.example.parking.mapper;

import com.example.parking.dto.EstacionamientoDTO;
import com.example.parking.model.Empresa;
import com.example.parking.model.Estacionamiento;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-20T17:28:48-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.0.2 (Oracle Corporation)"
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
        estacionamientoDTO.id( entity.getId() );
        estacionamientoDTO.cantidadLibre( entity.getCantidadLibre() );
        estacionamientoDTO.cantidadOcupado( entity.getCantidadOcupado() );
        estacionamientoDTO.cantidadTotal( entity.getCantidadTotal() );
        estacionamientoDTO.habilitado( entity.isHabilitado() );

        return estacionamientoDTO.build();
    }

    @Override
    public Estacionamiento toEntity(EstacionamientoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Estacionamiento.EstacionamientoBuilder estacionamiento = Estacionamiento.builder();

        estacionamiento.id( dto.getId() );
        estacionamiento.cantidadLibre( dto.getCantidadLibre() );
        estacionamiento.cantidadOcupado( dto.getCantidadOcupado() );
        estacionamiento.cantidadTotal( dto.getCantidadTotal() );
        estacionamiento.habilitado( dto.isHabilitado() );

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
