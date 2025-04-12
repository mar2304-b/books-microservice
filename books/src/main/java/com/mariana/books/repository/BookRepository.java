package com.mariana.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mariana.books.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    
    boolean existsByName(String name);

}
