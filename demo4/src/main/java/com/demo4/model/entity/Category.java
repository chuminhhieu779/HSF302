package com.demo4.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "categories")
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id ;
    @Column(name = "category_name", length = 150, nullable = false)
    private String categoryName ;
    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    private Category parent ;
    // 1 parent category - N child category
    @OneToMany(mappedBy = "parent")
    private List<Category> children ;
}
