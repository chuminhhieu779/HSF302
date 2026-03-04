package com.demo4.service;

import com.demo4.mapper.BookMapper;
import com.demo4.model.dto.response.BookResponse;
import com.demo4.model.entity.Book;
import com.demo4.repository.BookRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Cacheable("books")
    public List<BookResponse> getBook() {
        return bookMapper.toBookResponse(bookRepository.findAll());
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public List<Book> findBooksUntrusted(String title) {

        // String sql = "SELECT * FROM books WHERE book_title = :title";
        // return entityManager.createNativeQuery(sql, Book.class)
        //         .setParameter("title", title)
        //         .getResultList();
        String sql = "SELECT * FROM books WHERE book_title = '" + title + "'";
        return entityManager.createNativeQuery(sql, Book.class).getResultList();
    }

    public void testSnyk(String title) {

        // String sql = "SELECT * FROM books WHERE book_title = ?";
        // jdbcTemplate.queryForList(sql, title);
        String sql = "SELECT * FROM books WHERE book_title = '" + title + "'";
        jdbcTemplate.execute(sql);
    }

    public String weakHashForTesting(String input) {
        try {
            // MessageDigest md = MessageDigest.getInstance("SHA-256");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hex = new StringBuilder();
            for (byte b : digest) {
                hex.append(String.format("%02x", b));
            }
            return hex.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("MD5 algorithm not available", e);
        }
    }

    public String weakHashForTestingV2(String input) {
        try {

            // MessageDigest md = MessageDigest.getInstance("SHA-256");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(("prefix-" + input).getBytes(StandardCharsets.UTF_8));
            StringBuilder hex = new StringBuilder();
            for (byte b : digest) {
                hex.append(String.format("%02x", b));
            }
            return hex.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("MD5 algorithm not available", e);
        }
    }

    public String weakHashForTestingV3(String input) {
        try {

            // MessageDigest md = MessageDigest.getInstance("SHA-256");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest((input + "-suffix").getBytes(StandardCharsets.UTF_8));
            StringBuilder hex = new StringBuilder();
            for (byte b : digest) {
                hex.append(String.format("%02x", b));
            }
            return hex.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("MD5 algorithm not available", e);
        }
    }

}
