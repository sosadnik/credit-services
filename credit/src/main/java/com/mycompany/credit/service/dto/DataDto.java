package com.mycompany.credit.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DataDto {

    private CreditDto credit;
    private CustomerDto customer;
    private ProductDto product;
}
