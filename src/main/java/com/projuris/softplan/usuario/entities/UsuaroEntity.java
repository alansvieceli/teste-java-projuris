package com.projuris.softplan.usuario.entities;

import java.time.LocalDateTime;

import com.projuris.softplan.core.entities.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class UsuaroEntity extends BaseEntity {

  @Column(nullable = false)
  private String usuario;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String password;

  @Column()
  private int idade;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @PreUpdate
  protected void onUpdate() {
    updatedAt = LocalDateTime.now();
  }

}
