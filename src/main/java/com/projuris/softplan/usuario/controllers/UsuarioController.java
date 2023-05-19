package com.projuris.softplan.usuario.controllers;

import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.projuris.softplan.usuario.dtos.CreateUsuarioDto;
import com.projuris.softplan.usuario.dtos.UpdateUsuarioDto;
import com.projuris.softplan.usuario.services.interfaces.IUsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

  private IUsuarioService service;

  public UsuarioController(IUsuarioService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<?> insert(@RequestHeader(value = "Content-Type") String contentType,
      @Valid @RequestBody CreateUsuarioDto value, UriComponentsBuilder uriBuilder) {
    if (!MediaType.APPLICATION_JSON_VALUE.equals(contentType)) {
      throw new IllegalArgumentException("O cabeçalho Content-Type deve ser application/json");
    }

    Long id = this.service.insert(value);
    URI uri = uriBuilder.path("/api/table").path("/{id}").buildAndExpand(id).toUri();
    return ResponseEntity.created(uri).build();
  }

  @PutMapping("{id}")
  public ResponseEntity<?> update(@RequestHeader(value = "Content-Type") String contentType,
      @PathVariable("id") Long id, @Valid @RequestBody UpdateUsuarioDto value) {
    if (!MediaType.APPLICATION_JSON_VALUE.equals(contentType)) {
      throw new IllegalArgumentException("O cabeçalho Content-Type deve ser application/json");
    }

    this.service.update(id, value);
    return ResponseEntity.ok().build();
  }

  @GetMapping
  public ResponseEntity<?> geteAll() {
    return ResponseEntity.ok(this.service.findAll());
  }

  @GetMapping("{id}")
  public ResponseEntity<?> getById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(this.service.findById(id));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
    this.service.delete(id);
    return ResponseEntity.ok().build();
  }

}
