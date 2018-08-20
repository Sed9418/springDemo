package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;


    @PostMapping("/bookAdd")
    public String add(@RequestParam("title") String title,
                      @RequestParam("description") String description,
                      @RequestParam("price") int price, @RequestParam("authorId") int id) {

        Book book = Book.builder()
                .title(title)
                .description(description)
                .price(price)
                .author(authorRepository.getOne(id))
                .build();
        bookRepository.save(book);
        return "redirect:/home";
    }
}
