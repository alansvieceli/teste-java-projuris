package com.projuris.softplan.audit.services;

import java.util.Optional;
import java.util.Random;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Service;

@Service
public class AuditService implements AuditorAware<String> {

  String[] usuarios = { "Usuário X", "Usuário Y", "Usuário Z", "Usuário W", "Usuário LOL" };

  @Override
  public Optional<String> getCurrentAuditor() {
    Random random = new Random();
    int index = random.nextInt(usuarios.length);
    return Optional.of(usuarios[index]);
  }

}
