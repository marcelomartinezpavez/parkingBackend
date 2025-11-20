package com.example.parking.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private boolean habilitado;

  @Column(nullable = false)
  private String pass;

  @Column(nullable = false)
  private String rol;

  @Column(unique = true, nullable = false)
  private String users;

  @Column(name = "empresa_id")
  private long empresaId;

}
