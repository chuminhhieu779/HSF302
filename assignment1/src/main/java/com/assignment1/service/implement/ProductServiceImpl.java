package com.assignment1.service.implement;

import com.assignment1.dto.request.ProductRequestDTO;
import com.assignment1.dto.response.ProductResponseDTO;
import com.assignment1.entity.Product;
import com.assignment1.exception.OutOfStockException;
import com.assignment1.mapper.ProductMapper;
import com.assignment1.repository.ProductRepository;
import com.assignment1.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository ;
    private final ProductMapper mapper ;

    public void saveProduct(ProductRequestDTO dto) {
        productRepository.save( mapper.toEntity(dto, productRepository.count()));
    }

    @Override
    public List<ProductResponseDTO> getAllProduct() {
        return productRepository.findAll().stream()
                .map(mapper::toProductDTO)
                .toList();
    }

    @Override
    public void checkQuantity(Product product){
        if(product.getQuantity() <= 0 ){
            throw new OutOfStockException("this" + product.getName() + "sold out");
        }
    }
}
