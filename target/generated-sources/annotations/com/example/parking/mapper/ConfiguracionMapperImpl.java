package com.example.parking.mapper;

import com.example.parking.dto.ConfiguracionDTO;
import com.example.parking.model.Configuracion;
import com.example.parking.model.Estacionamiento;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-18T15:57:03-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.0.2 (Oracle Corporation)"
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
        configuracionDTO.id( entity.getId() );
        configuracionDTO.habilitado( entity.isHabilitado() );
        configuracionDTO.valorDia( entity.getValorDia() );
        configuracionDTO.valorHora( entity.getValorHora() );
        configuracionDTO.valorMes( entity.getValorMes() );
        configuracionDTO.valorMinuto( entity.getValorMinuto() );
        configuracionDTO.tiempoMinimoMinutos( entity.getTiempoMinimoMinutos() );
        configuracionDTO.valorMinimo( entity.getValorMinimo() );
        configuracionDTO.tiempoAumento( entity.getTiempoAumento() );

        return configuracionDTO.build();
    }

    @Override
    public Configuracion toEntity(ConfiguracionDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Configuracion.ConfiguracionBuilder configuracion = Configuracion.builder();

        configuracion.estacionamiento( configuracionDTOToEstacionamiento( dto ) );
        configuracion.id( dto.getId() );
        configuracion.habilitado( dto.isHabilitado() );
        configuracion.valorDia( dto.getValorDia() );
        configuracion.valorHora( dto.getValorHora() );
        configuracion.valorMes( dto.getValorMes() );
        configuracion.valorMinuto( dto.getValorMinuto() );
        configuracion.tiempoMinimoMinutos( dto.getTiempoMinimoMinutos() );
        configuracion.valorMinimo( dto.getValorMinimo() );
        configuracion.tiempoAumento( dto.getTiempoAumento() );

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
