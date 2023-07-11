package com.internship.database.adapter.rest;

import com.internship.database.application.CustomerService;
import com.internship.database.application.ProductService;
import com.internship.database.domain.dtos.CustomerDTO;
import com.internship.database.domain.dtos.ProductDTO;
import com.internship.database.domain.entities.Customer;
import com.internship.database.domain.entities.Product;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("internship2023/v1/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final ProductService productService;

    public CustomerController(CustomerService customerService, ProductService productService, ModelMapper modelMapper) {
        this.customerService = customerService;
        this.productService = productService;
    }

    @PostMapping
    public CustomerDTO createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomer(@PathVariable("id") Long id) {
        return customerService.getCustomer(id);
    }

    @PutMapping("/{id}")
    public CustomerDTO updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
    }

    @PutMapping("/{id}/products")
    public CustomerDTO buyProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.buyProduct(id, product);
    }

    @DeleteMapping("/{customerId}/products/{productId}")
    public void deleteProduct(@PathVariable("customerId") Long customerId, @PathVariable("productId") Long productId) {
        productService.deleteProduct(customerId, productId);
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId) {
        productService.deleteProduct(productId);
    }

    @PutMapping("/products/{productId}")
    public ProductDTO updateProduct(@PathVariable("productId") Long productId, @RequestBody Product product){
        return productService.updateProduct(productId, product);
    }
}
