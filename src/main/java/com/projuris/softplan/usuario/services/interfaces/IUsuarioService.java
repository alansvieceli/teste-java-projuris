package com.projuris.softplan.usuario.services.interfaces;

import java.util.List;

import com.projuris.softplan.usuario.dtos.CreateUsuarioDto;
import com.projuris.softplan.usuario.dtos.SelectUsuarioDto;
import com.projuris.softplan.usuario.dtos.UpdateUsuarioDto;

public interface IUsuarioService {

  List<SelectUsuarioDto> findAll();

  SelectUsuarioDto findById(Long id);

  Long insert(CreateUsuarioDto value);

  SelectUsuarioDto update(Long id, UpdateUsuarioDto value);

  void delete(Long id);

}
