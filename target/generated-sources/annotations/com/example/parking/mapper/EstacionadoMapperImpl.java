package com.example.parking.mapper;

import com.example.parking.dto.EstacionadoDTO;
import com.example.parking.model.Estacionado;
import com.example.parking.model.Estacionamiento;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-17T22:51:51-0400",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class EstacionadoMapperImpl implements EstacionadoMapper {

    @Override
    public EstacionadoDTO toDto(Estacionado entity) {
        if ( entity == null ) {
            return null;
        }

        EstacionadoDTO.EstacionadoDTOBuilder estacionadoDTO = EstacionadoDTO.builder();

        estacionadoDTO.estacionamientoId( entityEstacionamientoId( entity ) );
        if ( entity.getEstado() != null ) {
            estacionadoDTO.estado( entity.getEstado().name() );
        }
        estacionadoDTO.fechaIngreso( entity.getFechaIngreso() );
        estacionadoDTO.fechaSalida( entity.getFechaSalida() );
        estacionadoDTO.id( entity.getId() );
        estacionadoDTO.minutosEstacionado( entity.getMinutosEstacionado() );
        estacionadoDTO.patente( entity.getPatente() );
        if ( entity.getTipoPago() != null ) {
            estacionadoDTO.tipoPago( entity.getTipoPago().name() );
        }
        estacionadoDTO.valorTotal( entity.getValorTotal() );

        return estacionadoDTO.build();
    }

    @Override
    public Estacionado toEntity(EstacionadoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Estacionado.EstacionadoBuilder estacionado = Estacionado.builder();

        if ( dto.getEstado() != null ) {
            estacionado.estado( Enum.valueOf( Estacionado.EstadoEstacionamiento.class, dto.getEstado() ) );
        }
        estacionado.fechaIngreso( dto.getFechaIngreso() );
        estacionado.fechaSalida( dto.getFechaSalida() );
        estacionado.id( dto.getId() );
        estacionado.minutosEstacionado( dto.getMinutosEstacionado() );
        estacionado.patente( dto.getPatente() );
        if ( dto.getTipoPago() != null ) {
            estacionado.tipoPago( Enum.valueOf( Estacionado.TipoPago.class, dto.getTipoPago() ) );
        }
        estacionado.valorTotal( dto.getValorTotal() );

        estacionado.estacionamiento( estacionamientoFromId(dto.getEstacionamientoId()) );

        return estacionado.build();
    }

    private Long entityEstacionamientoId(Estacionado estacionado) {
        if ( estacionado == null ) {
            return null;
        }
        Estacionamiento estacionamiento = estacionado.getEstacionamiento();
        if ( estacionamiento == null ) {
            return null;
        }
        Long id = estacionamiento.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
