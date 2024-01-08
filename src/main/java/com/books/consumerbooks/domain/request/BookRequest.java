package com.books.consumerbooks.domain.request;

import lombok.Data;

@Data
public class BookRequest {

    private String title;
    private String author;
    private String genre;

}
