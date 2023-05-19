package com.projuris.softplan.usuario.dtos;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectUsuarioDto extends UsuarioDto {
  private Long id;

  private String createdBy;

  private LocalDateTime createdAt;

  private String updateBy;

  private LocalDateTime updatedAt;

}
