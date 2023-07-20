package com.internship.database.application;

import com.internship.database.adapter.repository.AddressRepository;
import com.internship.database.adapter.repository.CustomerRepository;
import com.internship.database.adapter.repository.ProductRepository;
import com.internship.database.domain.dtos.AddressDTO;
import com.internship.database.domain.dtos.CustomerDTO;
import com.internship.database.domain.dtos.ProductDTO;
import com.internship.database.domain.entities.Address;
import com.internship.database.domain.entities.Customer;
import com.internship.database.domain.entities.Product;
import com.internship.database.domain.exceptions.CustomerNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;

    private final ProductRepository productRepository;

    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, AddressRepository addressRepository, ProductRepository productRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CustomerDTO createCustomer(Customer customer) {
        customerRepository.save(customer);
        if(Objects.nonNull(customer.getProducts())) {
            for(Product product : customer.getProducts()) {
                product.setCustomer(customer);
                productRepository.save(product);
            }
        }
        addressRepository.save(customer.getAddress());
        return modelMapper.map(customerRepository.save(customer), CustomerDTO.class);
    }

    @Override
    public CustomerDTO getCustomer(Long id) {
        return modelMapper.map(customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not found!")), CustomerDTO.class);
    }

    @Override
    public CustomerDTO updateCustomer(Long id, Customer customer) {
        customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not found!"));
        return modelMapper.map(customerRepository.save(customer), CustomerDTO.class);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not found!"));
        customerRepository.deleteById(id);
    }
}
