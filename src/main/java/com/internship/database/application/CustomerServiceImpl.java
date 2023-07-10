package com.internship.database.application;

import com.internship.database.adapter.repository.AddressRepository;
import com.internship.database.adapter.repository.CustomerRepository;
import com.internship.database.domain.entities.Customer;
import com.internship.database.domain.exceptions.CustomerNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, AddressRepository addressRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        addressRepository.save(customer.getAddress());
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not found!"));
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not found!"));
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not found!"));
        customerRepository.deleteById(id);
    }
}
