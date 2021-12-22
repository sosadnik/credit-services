package com.mycompany.credit.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CustomerDto {
    private String firstName;
    private String sureName;
    private String pesel;
}
