package com.internship.database.domain.dtos;

import lombok.Data;

@Data
public class AddressDTO {
    private String city;
    private String postalCode;
    private String street;
    private Integer number;
    private String country;
}
