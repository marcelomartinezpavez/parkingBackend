package com.example.parking.mapper;

import com.example.parking.dto.EmpresaDTO;
import com.example.parking.model.Empresa;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-17T22:51:50-0400",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class EmpresaMapperImpl implements EmpresaMapper {

    @Override
    public EmpresaDTO toDto(Empresa entity) {
        if ( entity == null ) {
            return null;
        }

        EmpresaDTO.EmpresaDTOBuilder empresaDTO = EmpresaDTO.builder();

        empresaDTO.direccion( entity.getDireccion() );
        empresaDTO.id( entity.getId() );
        empresaDTO.nombre( entity.getNombre() );
        empresaDTO.rut( entity.getRut() );

        return empresaDTO.build();
    }

    @Override
    public Empresa toEntity(EmpresaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.direccion( dto.getDireccion() );
        empresa.id( dto.getId() );
        empresa.nombre( dto.getNombre() );
        empresa.rut( dto.getRut() );

        return empresa.build();
    }
}
