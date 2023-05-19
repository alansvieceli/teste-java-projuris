package com.projuris.softplan.usuario.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUsuarioDto extends UsuarioDto {

  @NotEmpty
  @NotNull
  private String password;
}
