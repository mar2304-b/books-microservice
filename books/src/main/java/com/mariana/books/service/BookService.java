package com.mariana.books.service;

import java.util.List;

import com.mariana.books.dto.BookDTO;
import com.mariana.books.dto.CreateBookDTO;

public interface BookService {
    
    BookDTO createBook(CreateBookDTO createBookDTO);

    BookDTO updateBook(Long id, CreateBookDTO bookDTO);

    BookDTO getBookById(Long id);

    void deleteBookById(Long id);

    List<BookDTO> getAllBooks();

}
