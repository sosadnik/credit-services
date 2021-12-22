package com.mycompany.credit.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Customer {

    public Customer(String firstName,
                    String sureName,
                    String pesel,
                    Credit credit) {
        this.firstName = firstName;
        this.sureName = sureName;
        this.pesel = pesel;
        this.credit = credit;
    }

    private Long id;
    private Credit credit;
    private String firstName;
    private String sureName;
    private String pesel;


}