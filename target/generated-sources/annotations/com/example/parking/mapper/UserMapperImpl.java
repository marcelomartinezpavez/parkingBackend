package com.example.parking.mapper;

import com.example.parking.dto.UserDTO;
import com.example.parking.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-15T12:27:06-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.100.v20260826-1225, environment: Java 21.0.12.1 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDTO.UserDTOBuilder userDTO = UserDTO.builder();

        userDTO.empresaId( entity.getEmpresaId() );
        userDTO.habilitado( entity.isHabilitado() );
        userDTO.id( entity.getId() );
        userDTO.pass( entity.getPass() );
        userDTO.rol( entity.getRol() );
        userDTO.users( entity.getUsers() );

        return userDTO.build();
    }

    @Override
    public User toEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.empresaId( dto.getEmpresaId() );
        user.habilitado( dto.isHabilitado() );
        user.id( dto.getId() );
        user.pass( dto.getPass() );
        user.rol( dto.getRol() );
        user.users( dto.getUsers() );

        return user.build();
    }
}
