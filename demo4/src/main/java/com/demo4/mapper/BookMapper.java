package com.demo4.mapper;


import com.demo4.model.dto.response.BookResponse;
import com.demo4.model.dto.response.PublisherResponse;
import com.demo4.model.entity.Book;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookMapper {
    public List<BookResponse> toBookResponse(List<Book> bookList){
        return bookList.stream()
                .map(entity -> BookResponse.builder()
                        .bookTitle(entity.getBookTitle())
                        .publishedYear(entity.getPublishedYear())
                        .imageUrl(entity.getImageUrl())
                        .publisherResponse(PublisherResponse.builder()
                                .build()
                        ).build()
                ).toList();
    }
}
