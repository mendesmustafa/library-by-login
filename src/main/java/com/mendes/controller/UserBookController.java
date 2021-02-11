package com.mendes.controller;

import com.mendes.entity.Book;
import com.mendes.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mendesmustafa on 10.02.2021.
 */

@Controller
@RequestMapping("/user/book")
public class UserBookController {

    private BookService bookService;

    public UserBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Book> books = bookService.list();
        model.addAttribute("books", books);
        return "user/userBookList";
    }

    @RequestMapping("/basket/{id}")
    public String basketList(@PathVariable("id") Long id, Model model) {
        List<Book> books = new ArrayList<>();
        Book book = bookService.getById(id);
        books.add(book);
        model.addAttribute("books", books);
        return "user/userBasket";
    }
}
