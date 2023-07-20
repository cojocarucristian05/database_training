package com.internship.database.domain.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CustomerDTO{
    private Long id;
    private String name;
    private String email;
    private LocalDate dateOfBirth;
    private AddressDTO address;
    private List<ProductDTO> products;
}
