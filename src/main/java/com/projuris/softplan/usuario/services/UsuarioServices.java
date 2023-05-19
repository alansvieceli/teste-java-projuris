package com.projuris.softplan.usuario.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projuris.softplan.core.exceptions.DeleteException;
import com.projuris.softplan.core.exceptions.InsertionException;
import com.projuris.softplan.core.exceptions.NotFoundException;
import com.projuris.softplan.core.exceptions.SelectException;
import com.projuris.softplan.core.exceptions.UpdateException;
import com.projuris.softplan.usuario.dtos.CreateUsuarioDto;
import com.projuris.softplan.usuario.dtos.SelectUsuarioDto;
import com.projuris.softplan.usuario.dtos.UpdateUsuarioDto;
import com.projuris.softplan.usuario.entities.UsuaroEntity;
import com.projuris.softplan.usuario.repositories.UsuarioRepository;
import com.projuris.softplan.usuario.services.interfaces.IUsuarioService;

@Service
public class UsuarioServices implements IUsuarioService {

  @Autowired
  private final UsuarioRepository repository;

  @Autowired
  private ModelMapper modelMapper;

  public UsuarioServices(UsuarioRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<SelectUsuarioDto> findAll() {
    try {
      Iterable<UsuaroEntity> entities = this.repository.findAll();
      List<SelectUsuarioDto> dtos = this.modelMapper.map(entities, new TypeToken<List<SelectUsuarioDto>>() {
      }.getType());
      return dtos;

    } catch (Exception e) {
      throw new SelectException(e.getMessage());
    }
  }

  @Override
  public SelectUsuarioDto findById(Long id) {
    try {
      Optional<UsuaroEntity> data = this.repository.findById(id);
      if (data.isPresent()) {
        return this.modelMapper.map(this.repository.findById(id), SelectUsuarioDto.class);
      }
    } catch (Exception e) {
      throw new SelectException(e.getMessage());
    }
    throw new NotFoundException("Nenhum Registro encontrado");
  }

  @Override
  public Long insert(CreateUsuarioDto value) {
    try {
      UsuaroEntity newEntity = this.modelMapper.map(value, UsuaroEntity.class);
      UsuaroEntity entity = this.repository.save(newEntity);
      return entity.getId();
    } catch (Exception e) {
      throw new InsertionException(e.getMessage());
    }
  }

  @Override
  public SelectUsuarioDto update(Long id, UpdateUsuarioDto value) {
    try {

      Optional<UsuaroEntity> data = this.repository.findById(id);

      if (data.isPresent()) {
        this.modelMapper.map(value, data.get());
        UsuaroEntity updatedEntity = this.repository.save(data.get());
        return this.modelMapper.map(updatedEntity, SelectUsuarioDto.class);
      }

    } catch (Exception e) {
      throw new UpdateException(e.getMessage());
    }

    throw new NotFoundException("Nenhum Registro encontrado");
  }

  @Override
  public void delete(Long id) {
    try {
      this.repository.deleteById(id);
    } catch (Exception e) {
      throw new DeleteException(e.getMessage());
    }

  }
}
