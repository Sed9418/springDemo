package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorRepository authorRepository;

    @PostMapping("/addAuthor")
    public String add(@ModelAttribute Author author) {
        authorRepository.save(author);
        return "redirect:/home";
    }
}
