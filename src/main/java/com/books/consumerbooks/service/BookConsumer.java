package com.books.consumerbooks.service;

import com.books.consumerbooks.domain.entity.BookEntity;
import com.books.consumerbooks.domain.exception.DatabaseException;
import com.books.consumerbooks.domain.request.BookRequest;
import com.books.consumerbooks.repository.BookRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.books.consumerbooks.util.ConstantUtils.DB_PERSISTENCE_ERROR;

@Component
public class BookConsumer {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ObjectMapper objectMapper;


    @KafkaListener(topics = "kafka-register-book-topic")
    public void consumeCreateBook(@Payload String string, Acknowledgment ack) throws JsonProcessingException {
        BookRequest bookRequest = objectMapper.readValue(string, BookRequest.class);
        createBook(bookRequest);
        ack.acknowledge();
    }

    public void createBook(BookRequest bookRequest) {
        BookEntity bookEntity = new BookEntity(bookRequest);
        try {
            bookRepository.save(bookEntity);
        } catch (Exception e) {
            throw new DatabaseException(HttpStatus.INTERNAL_SERVER_ERROR, DB_PERSISTENCE_ERROR, e.getCause());
        }
    }

}
