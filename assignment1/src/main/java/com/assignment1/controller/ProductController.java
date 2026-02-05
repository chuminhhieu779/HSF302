package com.assignment1.controller;


import com.assignment1.dto.request.ProductRequestDTO;
import com.assignment1.dto.response.ProductResponseDTO;
import com.assignment1.service.ProductService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService ;
    @RequestMapping("/create")
    public String createProduct(){
        return "product/product_form";
    }

    @PostMapping("/create")
    public String saveProduct(ProductRequestDTO dto, RedirectAttributes redirectAttributes){
        productService.saveProduct(dto);
        redirectAttributes.addFlashAttribute("notification", "added");
        return "redirect:/products/create";
    }

    @GetMapping
    public String showProductList(Model model){
        productService.getAllProduct();
        List<ProductResponseDTO> list = Collections.unmodifiableList(productService.getAllProduct());
        model.addAttribute("productDTO", list);
       return "product/product_list";
    }

}
