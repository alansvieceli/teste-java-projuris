package com.projuris.softplan.usuario.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUsuarioDto {

  private String usuario;

  @Email(regexp = ".*|^$", message = "O campo deve ser um endereço de e-mail válido ou nulo")
  private String email;

  private String password;

  private int idade;

}
