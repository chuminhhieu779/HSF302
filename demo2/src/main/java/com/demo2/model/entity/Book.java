package com.demo2.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Table(name = "book")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title", length = 50)
    private String title;

    @Column(name = "quantity")
    private int quantity;

    // create relational table
//    @ManyToMany
//    @JoinTable(
//            // the name of relational table
//            name = "book_category",
//            // foreign key (book_id) references book(book_id)
//            joinColumns = @JoinColumn(
//                    name = "book_id",         // the name of FK column
//                    referencedColumnName = "id" // the name of PK column
//            ),
//            // foreign key ( category_id) references category(category_id)
//            inverseJoinColumns = @JoinColumn(
//                    name = "category_id",
//                    referencedColumnName = "id"
//            )
//    )
//      private Set<Category> categories;

    @ManyToOne
    @JoinColumn(
            name = "users_id",
            referencedColumnName = "id",
            nullable = false
    )
    private User user ;

    @OneToMany(mappedBy = "book")
    private Set<BookCategory> bookCategories ;
}
