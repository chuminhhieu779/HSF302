package com.demo2.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;


/**
 *  Composite key : not @Id because fields is key
 */

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Embeddable // value object not table
public class BookCategoryId implements Serializable {

    @Column(name = "book_id")
    private int bookId ;
    @Column(name = "category_id")
    private int categoryId ;


}
