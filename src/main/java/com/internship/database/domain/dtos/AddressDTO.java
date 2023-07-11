package com.internship.database.domain.dtos;

import lombok.Data;

@Data
public class AddressDTO {
        private String country;
        private String city;
        private String street;
        private Integer number;
        private String postalCode;
}

