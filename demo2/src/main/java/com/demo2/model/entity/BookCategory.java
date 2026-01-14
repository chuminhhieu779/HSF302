package com.demo2.model.entity;

import jakarta.persistence.*;

@Table(name = "book_category")
@Entity
public class BookCategory {
    @EmbeddedId
    private BookCategoryId id ;

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book ;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category ;
}
