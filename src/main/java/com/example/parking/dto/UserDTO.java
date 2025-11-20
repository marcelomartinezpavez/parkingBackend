package com.example.parking.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private boolean habilitado;
    private String pass;
    private String rol;
    private String users;
    private long empresaId;
}