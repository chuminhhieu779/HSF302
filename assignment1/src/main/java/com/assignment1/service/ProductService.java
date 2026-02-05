package com.assignment1.service;


import com.assignment1.dto.request.ProductRequestDTO;
import com.assignment1.dto.response.ProductResponseDTO;
import com.assignment1.entity.Product;

import java.util.List;

public interface ProductService {
    void saveProduct(ProductRequestDTO dto);
    List<ProductResponseDTO> getAllProduct();
    void checkQuantity(Product product);
}
