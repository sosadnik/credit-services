package com.mycompany.product;

import com.mycompany.product.controller.ProductController;
import com.mycompany.product.model.Credit;
import com.mycompany.product.model.Product;
import com.mycompany.product.services.ProductService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class BaseContractTest {

    @BeforeEach
    public void setup(){
        ArrayList<Product> productsList = new ArrayList<>();
        productsList.add(new Product(1L, new Credit(1L, "bulka"), "panierka", 3));
        productsList.add(new Product(2L, new Credit(2L, "pies"), "kot", 3));

        ProductService productService = mock(ProductService.class);
        given(productService.getProductList(any())).willReturn(productsList);

        RestAssuredMockMvc.standaloneSetup(new ProductController(productService));
    }
}
