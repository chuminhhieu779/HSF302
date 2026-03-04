package com.demo4.controller;

import jakarta.servlet.http.HttpServletResponse;
import com.demo4.model.dto.response.BookResponse;
import com.demo4.model.entity.Book;
import com.demo4.service.UploadImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Controller
@RequiredArgsConstructor
@RequestMapping("books")
public class BookController {
    private final BookService bookService;
    private final UploadImageService uploadImageService;

    @GetMapping("/show")
    public String showBook(Model model) {
        List<BookResponse> bookResponseList = bookService.getBook();
        model.addAttribute("bookList", bookResponseList);
        return "show_book";
    }

    @GetMapping("/add")
    public String addBook() {
        return "book";
    }

    @PostMapping("/add")
    public String addBook(@RequestParam String title, @RequestParam MultipartFile file, @RequestParam int published_year) throws IOException, ExecutionException, InterruptedException {
        Map<String, Object> result = uploadImageService.uploadFile(file);
        String imgURL = result.get("secure_url").toString();
        String imageID = result.get("public_id").toString();
        bookService.saveBook(Book.builder()
                .bookTitle(title)
                .publishedYear(published_year)
                .imageUrl(imgURL)
                .imageId(imageID)
                .build());
        return "redirect:/books/show";
    }

    @GetMapping("/snyk/native")
    @ResponseBody
    public String testSnykNativeQuery(@RequestParam String title) {
        int rowCount = bookService.findBooksUntrusted(title).size();
        return "Native query executed. Rows found: " + rowCount;
    }



    @GetMapping("/snyk/weak-hash")
    @ResponseBody
    public String testSnykWeakHash(@RequestParam String value) {
        return bookService.weakHashForTesting(value);
    }

    @GetMapping("/snyk/weak-hash-2")
    @ResponseBody
    public String testSnykWeakHash2(@RequestParam String value) {
        return bookService.weakHashForTestingV2(value);
    }

    @GetMapping("/snyk/weak-hash-3")
    @ResponseBody
    public String testSnykWeakHash3(@RequestParam String value) {
        return bookService.weakHashForTestingV3(value);
    }

    @GetMapping("/snyk/open-redirect-1")
    public void testSnykOpenRedirect1(@RequestParam String next, HttpServletResponse response) throws IOException {

        // String safe = (next != null && next.startsWith("/books/") && !next.startsWith("//") && !next.contains("://"))
        //         ? next : "/books/show";
        // response.sendRedirect(safe);
        response.sendRedirect(next);
    }

    @GetMapping("/snyk/open-redirect-2")
    public void testSnykOpenRedirect2(@RequestParam String target, HttpServletResponse response) throws IOException {

        // response.sendRedirect(safeRedirectTarget(target));
        response.sendRedirect(target);
    }

    @GetMapping("/snyk/open-redirect-3")
    public void testSnykOpenRedirect3(@RequestParam String url, HttpServletResponse response) throws IOException {

        // response.sendRedirect(safeRedirectTarget(url));
        response.sendRedirect(url);
    }

    @GetMapping("/snyk/error-leak")
    @ResponseBody
    public String testErrorLeak(@RequestParam String input) {
        try {
            Integer.parseInt(input);
            return "OK";
        } catch (Exception e) {
            // return "Internal error";
            return "Internal error: " + e.getMessage();
        }
    }

    @GetMapping("/snyk/insecure-random")
    @ResponseBody
    public String testInsecureRandom() {

        // java.security.SecureRandom r = new java.security.SecureRandom();
        java.util.Random r = new java.util.Random();
        int otp = 100000 + r.nextInt(900000);
        return String.valueOf(otp);
    }

    @GetMapping("/snyk/xss-new")
    @ResponseBody
    public String testXssNew(@RequestParam String q) {
        // return "<h1>" + org.springframework.web.util.HtmlUtils.htmlEscape(q) + "</h1>";
        return "<h1>" + q + "</h1>";
    }

    @GetMapping("/snyk/command-new")
    @ResponseBody
    public String testCommandInjectionNew(@RequestParam String cmd) {
        // return "Endpoint disabled";
        try {
            Runtime.getRuntime().exec(cmd);
            return "Command executed.";
        } catch (IOException e) {
            return "Command failed: " + e.getMessage();
        }
    }

    @GetMapping("/snyk/deserialization-new")
    @ResponseBody
    public String testDeserializationNew(@RequestParam String payload) {
        // return "Endpoint disabled";
        try {
            byte[] bytes = Base64.getDecoder().decode(payload);
            try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes))) {
                return String.valueOf(ois.readObject());
            }
        } catch (Exception e) {
            return "Deserialize failed: " + e.getMessage();
        }
    }


//     private String safeRedirectTarget(String target) {
//         if (target == null || target.isBlank()) return "/books/show";
//         if (target.startsWith("/books/") && !target.startsWith("//") && !target.contains("://")) return target;
//         return "/books/show";
//     }
}
