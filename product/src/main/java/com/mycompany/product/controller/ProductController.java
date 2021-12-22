package com.mycompany.product.controller;

import com.mycompany.product.model.Product;
import lombok.RequiredArgsConstructor;
import com.mycompany.product.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public void createProduct(@RequestBody Product product){
        productService.createProduct(product);
    }

    @PostMapping("/get")
    public List<Product> getProduct(@RequestBody Set<Long> idList){
        return productService.getProductList(idList);
    }
}
