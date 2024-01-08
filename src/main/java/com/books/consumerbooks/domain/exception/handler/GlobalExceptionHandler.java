package com.books.consumerbooks.domain.exception.handler;

import com.books.consumerbooks.domain.builder.ExceptionResponseBuilder;
import com.books.consumerbooks.domain.exception.DatabaseException;
import com.books.consumerbooks.domain.exception.KafkaException;
import com.books.consumerbooks.domain.response.ExceptionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.books.consumerbooks.util.ConstantUtils.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private ExceptionResponseBuilder responseBuilder;

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ExceptionResponse handleInternalServerError(Exception exception) {

        ExceptionResponse exceptionResponse =
                responseBuilder.getExceptionResponse(INTERNAL_SERVER_ERROR);

        return exceptionResponse;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(KafkaException.class)
    public ExceptionResponse handleKafkaException(KafkaException exception) {

        ExceptionResponse exceptionResponse =
                responseBuilder.getExceptionResponse(INTERNAL_SERVER_ERROR);

        return exceptionResponse;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DatabaseException.class)
    public ExceptionResponse handleDatabaseException(DatabaseException exception) {

        ExceptionResponse exceptionResponse =
                responseBuilder.getExceptionResponse(exception.getMessage());

        return exceptionResponse;
    }


}
