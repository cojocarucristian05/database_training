package com.internship.database.adapter.rest;

import com.internship.database.application.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("internship2023/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

}
