package com.example.parking.mapper;

import com.example.parking.dto.ConfiguracionDTO;
import com.example.parking.model.Configuracion;
import com.example.parking.model.Estacionamiento;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-24T10:24:07-0400",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class ConfiguracionMapperImpl implements ConfiguracionMapper {

    @Override
    public ConfiguracionDTO toDto(Configuracion entity) {
        if ( entity == null ) {
            return null;
        }

        ConfiguracionDTO.ConfiguracionDTOBuilder configuracionDTO = ConfiguracionDTO.builder();

        configuracionDTO.estacionamientoId( entityEstacionamientoId( entity ) );
        configuracionDTO.habilitado( entity.isHabilitado() );
        configuracionDTO.id( entity.getId() );
        configuracionDTO.tiempoAumento( entity.getTiempoAumento() );
        configuracionDTO.tiempoMinimoMinutos( entity.getTiempoMinimoMinutos() );
        configuracionDTO.valorDia( entity.getValorDia() );
        configuracionDTO.valorHora( entity.getValorHora() );
        configuracionDTO.valorMes( entity.getValorMes() );
        configuracionDTO.valorMinimo( entity.getValorMinimo() );
        configuracionDTO.valorMinuto( entity.getValorMinuto() );

        return configuracionDTO.build();
    }

    @Override
    public Configuracion toEntity(ConfiguracionDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Configuracion.ConfiguracionBuilder configuracion = Configuracion.builder();

        configuracion.estacionamiento( configuracionDTOToEstacionamiento( dto ) );
        configuracion.habilitado( dto.isHabilitado() );
        configuracion.id( dto.getId() );
        configuracion.tiempoAumento( dto.getTiempoAumento() );
        configuracion.tiempoMinimoMinutos( dto.getTiempoMinimoMinutos() );
        configuracion.valorDia( dto.getValorDia() );
        configuracion.valorHora( dto.getValorHora() );
        configuracion.valorMes( dto.getValorMes() );
        configuracion.valorMinimo( dto.getValorMinimo() );
        configuracion.valorMinuto( dto.getValorMinuto() );

        return configuracion.build();
    }

    private Long entityEstacionamientoId(Configuracion configuracion) {
        if ( configuracion == null ) {
            return null;
        }
        Estacionamiento estacionamiento = configuracion.getEstacionamiento();
        if ( estacionamiento == null ) {
            return null;
        }
        Long id = estacionamiento.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Estacionamiento configuracionDTOToEstacionamiento(ConfiguracionDTO configuracionDTO) {
        if ( configuracionDTO == null ) {
            return null;
        }

        Estacionamiento.EstacionamientoBuilder estacionamiento = Estacionamiento.builder();

        estacionamiento.id( configuracionDTO.getEstacionamientoId() );

        return estacionamiento.build();
    }
}
