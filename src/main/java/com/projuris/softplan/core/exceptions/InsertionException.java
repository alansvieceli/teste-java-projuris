package com.projuris.softplan.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InsertionException extends RuntimeException {
  public InsertionException(String errorMessage) {
    super(errorMessage);
  }
}
