package com.projuris.softplan.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DeleteException extends RuntimeException {
  public DeleteException(String errorMessage) {
    super(errorMessage);
  }
}
