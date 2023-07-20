package com.internship.database.application;

import com.internship.database.domain.dtos.CustomerDTO;
import com.internship.database.domain.dtos.ProductDTO;
import com.internship.database.domain.entities.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    CustomerDTO buyProduct(Long id, Product product);

    void deleteProduct(Long customerId, Long productId);

    void deleteProduct(Long productId);

    ProductDTO updateProduct(Long id, Product product);
}
