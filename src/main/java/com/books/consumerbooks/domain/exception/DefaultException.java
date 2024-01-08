package com.books.consumerbooks.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Base class for exceptions associated with specific HTTP response status codes.
 */
@Getter
public class DefaultException extends RuntimeException {

  private static final long serialVersionUID = -7963947217892566012L;

  private final String reason;
  private final HttpStatus status;

  /**
   * @param status the HTTP response status code
   * @param reason the exception message
   * @param cause  the error cause
   */
  public DefaultException(HttpStatus status, String reason, Throwable cause) {
    super(reason, cause);
    this.status = status;
    this.reason = reason;
  }
}
