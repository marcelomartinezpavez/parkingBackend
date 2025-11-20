package com.example.parking.mapper;

import com.example.parking.dto.EmpresaDTO;
import com.example.parking.model.Empresa;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-18T15:57:03-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.0.2 (Oracle Corporation)"
)
@Component
public class EmpresaMapperImpl implements EmpresaMapper {

    @Override
    public EmpresaDTO toDto(Empresa entity) {
        if ( entity == null ) {
            return null;
        }

        EmpresaDTO.EmpresaDTOBuilder empresaDTO = EmpresaDTO.builder();

        empresaDTO.id( entity.getId() );
        empresaDTO.direccion( entity.getDireccion() );
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

        empresa.id( dto.getId() );
        empresa.direccion( dto.getDireccion() );
        empresa.nombre( dto.getNombre() );
        empresa.rut( dto.getRut() );

        return empresa.build();
    }
}
