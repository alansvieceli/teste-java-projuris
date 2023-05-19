package com.projuris.softplan.usuario.dtos;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class UsuarioDto {

  @NotEmpty
  @NotNull
  private String usuario;

  @Email
  @NotNull
  private String email;

  @Positive(message = "O campo deve ser um número inteiro maior que zero")
  private int idade;

}
