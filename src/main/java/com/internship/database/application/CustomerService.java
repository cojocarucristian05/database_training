package com.internship.database.application;

import com.internship.database.domain.dtos.CustomerDTO;
import com.internship.database.domain.entities.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    CustomerDTO createCustomer(Customer customer);

    CustomerDTO getCustomer(Long id);

    CustomerDTO updateCustomer(Long id, Customer customer);

    void deleteCustomer(Long id);
}
