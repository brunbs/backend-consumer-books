package com.books.consumerbooks.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class DatabaseException extends DefaultException {

    private static final long serialVersionUID = 1L;


    public DatabaseException(HttpStatus status, String reason, Throwable cause) {
        super(status, reason, cause);
    }
}
