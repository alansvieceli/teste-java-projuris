package com.projuris.softplan.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UpdateException extends RuntimeException {
  public UpdateException(String errorMessage) {
    super(errorMessage);
  }
}
