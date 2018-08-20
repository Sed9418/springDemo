package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.User;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/")
    public String main() {
        return "index";
    }

    @GetMapping("/home")
    public String home(ModelMap modelMap) {
        List<User> users = userRepository.findAll();
        List<Book> books = bookRepository.findAll();
        List<Author> authors = authorRepository.findAll();
        modelMap.addAttribute("users",users);
        modelMap.addAttribute("books",books);
        modelMap.addAttribute("authors",authors);
        return "home";
    }
}
