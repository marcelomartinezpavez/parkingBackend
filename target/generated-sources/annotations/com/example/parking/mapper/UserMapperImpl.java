package com.example.parking.mapper;

import com.example.parking.dto.UserDTO;
import com.example.parking.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-20T17:28:48-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDTO.UserDTOBuilder userDTO = UserDTO.builder();

        userDTO.id( entity.getId() );
        userDTO.habilitado( entity.isHabilitado() );
        userDTO.pass( entity.getPass() );
        userDTO.rol( entity.getRol() );
        userDTO.users( entity.getUsers() );
        userDTO.empresaId( entity.getEmpresaId() );

        return userDTO.build();
    }

    @Override
    public User toEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( dto.getId() );
        user.habilitado( dto.isHabilitado() );
        user.pass( dto.getPass() );
        user.rol( dto.getRol() );
        user.users( dto.getUsers() );
        user.empresaId( dto.getEmpresaId() );

        return user.build();
    }
}
