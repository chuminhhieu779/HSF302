package com.demo4.controller;


import com.demo4.model.dto.response.BookResponse;
import com.demo4.model.entity.Book;
import com.demo4.service.BookService;
import com.demo4.service.UploadImageService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("books")
public class BookController {
    private final BookService bookService;
    private final UploadImageService uploadImageService;
    private final  ExecutorService pool = Executors.newFixedThreadPool(5);

    @GetMapping("/show")
    public String showBook(Model model) {
        List<BookResponse> bookResponseList = bookService.getBook();
        model.addAttribute("bookList", bookResponseList);
        return "show_book";
    }

    @GetMapping("/add")
    public String addBook() {
        return "book";
    }

    @PostMapping("/add")
    public String addBook(@RequestParam String title, @RequestParam MultipartFile file, @RequestParam int published_year) throws IOException, ExecutionException, InterruptedException {
        Map<String, Object> result = uploadImageService.uploadFile(file);;
        String imgURL = result.get("secure_url").toString();
        String imageID = result.get("public_id").toString();
        bookService.saveBook(Book.builder()
                .bookTitle(title)
                .publishedYear(published_year)
                .imageUrl(imgURL)
                .imageId(imageID)
                .build());
        return "redirect:/books/show";
    }

}
