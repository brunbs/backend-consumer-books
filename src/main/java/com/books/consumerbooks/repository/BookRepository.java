package com.books.consumerbooks.repository;

import com.books.consumerbooks.domain.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {



}
