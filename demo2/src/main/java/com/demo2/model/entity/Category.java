package com.demo2.model.entity;

import com.demo2.enums.BookType;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id ;

    @Enumerated(EnumType.STRING)
    @Column(name = "title", length = 20 )
    private BookType title ;

   // categories : the field name in java

//    @ManyToMany(mappedBy = "categories")
//    private Set<Book> books ;

    @OneToMany(mappedBy = "category")
    private Set<BookCategory> bookCategories;
}
