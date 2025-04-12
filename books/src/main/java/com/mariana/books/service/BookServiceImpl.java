package com.mariana.books.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mariana.books.dto.BookDTO;
import com.mariana.books.dto.CreateBookDTO;
import com.mariana.books.entity.BookEntity;
import com.mariana.books.exception.ConflictException;
import com.mariana.books.exception.ResourceNotFoundException;
import com.mariana.books.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDTO createBook(CreateBookDTO createBookDTO) {
        if (bookRepository.existsByName(createBookDTO.name())) {
            throw new ConflictException("Libro con el nombre " + createBookDTO.name() + " ya existe");
        }

        BookEntity book = new BookEntity();
        book.setName(createBookDTO.name());
        book.setAuthor(createBookDTO.author());
        book.setPages(createBookDTO.pages());

        book = bookRepository.save(book);
        return new BookDTO(book.getId(), book.getName(), book.getAuthor(), book.getPages());
    }

    @Override
    public BookDTO updateBook(Long id, CreateBookDTO bookDTO) {
        BookEntity book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Libro con el id " + id + " no se encontró"));

        if (!book.getName().equals(bookDTO.name()) && bookRepository.existsByName(bookDTO.name())) {
            throw new ConflictException("Libro con el nombre: " + bookDTO.name() + " ya existe");
        }

        book.setName((bookDTO.name()));
        book = bookRepository.save(book);

        return new BookDTO(book.getId(), book.getName(), book.getAuthor(), book.getPages());

    }

    @Override
    public BookDTO getBookById(Long id) {
        BookEntity book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Libro con el id " + id + " no se encontró"));

        return new BookDTO(book.getId(), book.getName(), book.getAuthor(), book.getPages());
    }

    @Override
    public void deleteBookById(Long id) {
        BookEntity book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Libro con el id " + id + " no se encontró"));
        bookRepository.delete(book);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<BookEntity> books = bookRepository.findAll();
        return books.stream()
            .map(book -> new BookDTO(book.getId(), book.getName(), book.getAuthor(), book.getPages()))
            .toList();
    }

}
