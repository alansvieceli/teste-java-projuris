package com.projuris.softplan.usuario.dtos;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectUsuarioDto extends UsuarioDto {
  private Long id;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

}
