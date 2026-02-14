package com.demo4.controller;

import com.demo4.model.dto.response.AuthorResponse;
import com.demo4.service.AuthorService;
import com.demo4.service.BookService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService ;
    private final BookService bookService ;


    @GetMapping("/author/showAuthor")
    public String showAuthor(Model model ){
        List<AuthorResponse> list = authorService.getAllAuthor();
        model.addAttribute("list", list);
        return "author";
    }

    @GetMapping("/author/findAuthor")
    public String  findAuthor(@RequestParam long id,  Model model){
        AuthorResponse authorResponse = authorService.getAuthorByid(id);
        model.addAttribute("author", authorResponse);
        return "author";
    }
}
