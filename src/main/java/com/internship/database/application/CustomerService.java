package com.internship.database.application;

import com.internship.database.domain.entities.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    Customer createCustomer(Customer customer);

    Customer getCustomer(Long id);

    Customer updateCustomer(Long id, Customer customer);

    void deleteCustomer(Long id);
}
