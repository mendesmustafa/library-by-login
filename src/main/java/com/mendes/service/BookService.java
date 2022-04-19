package com.mendes.service;

import com.mendes.entity.Book;
import com.mendes.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by mendesmustafa on 09.02.2021.
 */

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findById(Long id) {
        Book book = null;
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            book = bookOptional.get();
        }
        return book;
    }

    public Book save(Book model) {
        Book book = new Book();
        if (model.getId() != null) {
            Optional<Book> bookOptional = bookRepository.findById(model.getId());
            if (bookOptional.isPresent()) {
                book = bookOptional.get();
            }
        }
        fillBook(book, model);
        bookRepository.save(book);
        return book;
    }

    public void fillBook(Book book, Book model) {
        book.setBookName(model.getBookName());
        book.setSerialNumber(model.getSerialNumber());
        book.setAuthorName(model.getAuthorName());
    }

    public Book getById(Long id) {
        Book model = null;
        Book book = findById(id);
        if (book != null) {
            model = fillModel(book);
        }
        return model;
    }

    public Book fillModel(Book book) {
        Book model = new Book();
        model.setId(book.getId());
        model.setBookName(book.getBookName());
        model.setSerialNumber(book.getSerialNumber());
        model.setAuthorName(book.getAuthorName());
        return model;
    }

    public void delete(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            bookRepository.deleteById(id);
            System.out.println("Book deleted " + id);
        } else {
            System.out.println("Book did't found " + id);
        }
    }

    public List<Book> list() {
        return bookRepository.findAll();
    }
}
