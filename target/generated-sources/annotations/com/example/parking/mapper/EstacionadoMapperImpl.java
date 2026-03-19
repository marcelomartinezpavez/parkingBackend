package com.example.parking.mapper;

import com.example.parking.dto.EstacionadoDTO;
import com.example.parking.model.Estacionado;
import com.example.parking.model.Estacionamiento;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-20T17:28:48-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.0.2 (Oracle Corporation)"
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
        estacionadoDTO.id( entity.getId() );
        if ( entity.getEstado() != null ) {
            estacionadoDTO.estado( entity.getEstado().name() );
        }
        estacionadoDTO.fechaIngreso( entity.getFechaIngreso() );
        estacionadoDTO.fechaSalida( entity.getFechaSalida() );
        estacionadoDTO.patente( entity.getPatente() );
        estacionadoDTO.valorTotal( entity.getValorTotal() );
        estacionadoDTO.minutosEstacionado( entity.getMinutosEstacionado() );
        if ( entity.getTipoPago() != null ) {
            estacionadoDTO.tipoPago( entity.getTipoPago().name() );
        }

        return estacionadoDTO.build();
    }

    @Override
    public Estacionado toEntity(EstacionadoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Estacionado.EstacionadoBuilder estacionado = Estacionado.builder();

        estacionado.id( dto.getId() );
        if ( dto.getEstado() != null ) {
            estacionado.estado( Enum.valueOf( Estacionado.EstadoEstacionamiento.class, dto.getEstado() ) );
        }
        estacionado.fechaIngreso( dto.getFechaIngreso() );
        estacionado.fechaSalida( dto.getFechaSalida() );
        estacionado.patente( dto.getPatente() );
        estacionado.valorTotal( dto.getValorTotal() );
        estacionado.minutosEstacionado( dto.getMinutosEstacionado() );
        if ( dto.getTipoPago() != null ) {
            estacionado.tipoPago( Enum.valueOf( Estacionado.TipoPago.class, dto.getTipoPago() ) );
        }

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
