package com.internship.database.application;

import com.internship.database.adapter.repository.CustomerRepository;
import com.internship.database.adapter.repository.ProductRepository;
import com.internship.database.domain.dtos.CustomerDTO;
import com.internship.database.domain.dtos.ProductDTO;
import com.internship.database.domain.entities.Customer;
import com.internship.database.domain.entities.Product;
import com.internship.database.domain.exceptions.CustomerNotFoundException;
import com.internship.database.domain.exceptions.ProductNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CustomerDTO buyProduct(Long id, Product product) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not found!"));
        product.setCustomer(customer);
        customer.getProducts().add(product);
        productRepository.save(product);
        return modelMapper.map(customerRepository.save(customer), CustomerDTO.class);
    }

    @Override
    public void deleteProduct(Long customerId, Long productId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer not found!"));
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found!"));
        customer.getProducts().remove(product);
        productRepository.delete(product);
        customerRepository.save(customer);
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found!"));
        Customer customer = product.getCustomer();
        customer.getProducts().remove(product);
        productRepository.delete(product);
        customerRepository.save(customer);
    }

    @Override
    public ProductDTO updateProduct(Long id, Product product) {
        Product product1 = productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        product.setId(product1.getId());
        product.setCustomer(product1.getCustomer());
        return modelMapper.map(productRepository.save(product), ProductDTO.class);
    }


}
