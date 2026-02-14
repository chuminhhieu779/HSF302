package com.demo4.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Table(name = "books")
@Entity
@Getter
@NoArgsConstructor
@Setter
@Builder
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer id ;
    @Column(name = "book_title" , length = 200 , nullable = true)
    private String bookTitle ;

    @Column(name = "publishedYear", nullable = false)
    private int publishedYear ;

    @OneToMany(mappedBy = "book")
    private List<RentalItem> rentalItemList ;

    @ManyToMany(mappedBy = "bookSet")
    private Set<Tag> tagList = new HashSet<>();

    @Column(name = "image_url" , nullable = false, length = 150)
    private String imageUrl ;
    @Column(name = "image_id" , nullable = false, length = 150)
    private String imageId ;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Book book)) return false;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
