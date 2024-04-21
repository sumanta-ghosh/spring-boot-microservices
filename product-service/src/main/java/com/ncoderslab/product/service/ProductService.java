package com.ncoderslab.product.service;

import com.ncoderslab.product.dto.ProductRequest;
import com.ncoderslab.product.dto.ProductResponse;
import com.ncoderslab.product.model.Product;
import com.ncoderslab.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productReq) {
        Product product = Product.builder()
                .name(productReq.name())
                .description(productReq.description())
                .price(productReq.price())
                .build();
        Product savedProduct = productRepository.save(product);
        log.info("Product created with id {}", savedProduct.getId());
        return new ProductResponse(
                savedProduct.getId(),
                savedProduct.getName(),
                savedProduct.getDescription(),
                savedProduct.getPrice()
        );
    }

    public List<ProductResponse> getAllProducts() {

        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice()
                ))
                .toList();
    }
}
