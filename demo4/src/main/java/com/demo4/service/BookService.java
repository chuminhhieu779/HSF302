package com.demo4.service;

import com.demo4.mapper.BookMapper;
import com.demo4.model.dto.response.BookResponse;
import com.demo4.model.entity.Book;
import com.demo4.repository.BookRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository ;
    private final BookMapper bookMapper ;
    @Cacheable("books")
    public List<BookResponse> getBook(){
        return bookMapper.toBookResponse(bookRepository.findAll());
    }
    public void saveBook(Book book){
        bookRepository.save(book);
    }
}
