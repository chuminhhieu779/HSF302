package com.assignment1.mapper;

import com.assignment1.dto.request.ProductRequestDTO;
import com.assignment1.dto.response.ProductResponseDTO;
import com.assignment1.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequestDTO dto, Long coundID){
        Product product = new Product();
        String id  = product.createID("PRDOO",coundID);
        return Product.builder()
                .id(id)
                .name(dto.name())
                .quantity(dto.quantity())
                .build();
    }

    public ProductResponseDTO toProductDTO(Product product){
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getQuantity()
        );
    }
}
