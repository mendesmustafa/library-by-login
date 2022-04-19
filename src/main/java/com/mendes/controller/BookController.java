package com.mendes.controller;

import com.mendes.entity.Book;
import com.mendes.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by mendesmustafa on 09.02.2021.
 */

@Controller
@RequestMapping("/admin")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("books", bookService.list());
        return "admin/bookList";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("book") Book book) {
        bookService.save(book);
        return "redirect:/admin/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        bookService.delete(id);
        return "redirect:/admin/";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", bookService.getById(id));
        return "admin/newBook";
    }

    @GetMapping("/addBookForm")
    public String add(Model model) {
        model.addAttribute("book", new Book());
        return "admin/newBook";
    }
}
