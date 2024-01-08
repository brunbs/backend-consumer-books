package com.books.consumerbooks.domain.builder;

import com.books.consumerbooks.domain.response.ExceptionResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ExceptionResponseBuilder {

  public ExceptionResponse getExceptionResponse(String message) {
    return ExceptionResponse.builder()
            .timestamp(LocalDateTime.now())
            .message(message)
            .build();
  }

}
