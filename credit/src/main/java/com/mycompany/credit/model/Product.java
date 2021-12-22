package com.mycompany.credit.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Product {

    public Product(String productName,
                   int value,
                   Credit credit) {
        this.credit = credit;
        this.productName = productName;
        this.value = value;
    }


    private Long id;
    private Credit credit;
    private String productName;
    private int value;


}