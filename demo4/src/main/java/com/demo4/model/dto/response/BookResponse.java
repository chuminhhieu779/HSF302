package com.demo4.model.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BookResponse {
    private Integer id;
    private String bookTitle;
    private int publishedYear;
    private String imageUrl ;
    private PublisherResponse publisherResponse;

}
