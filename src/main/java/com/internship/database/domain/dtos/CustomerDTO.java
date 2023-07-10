package com.internship.database.domain.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerDTO {
    private String name;
    private LocalDate dateOfBirth;
    private AddressDTO addressDTO;
}
