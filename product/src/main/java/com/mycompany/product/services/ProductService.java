package com.mycompany.product.services;

import com.mycompany.product.model.Product;
import com.mycompany.product.repository.CreditRepository;
import com.mycompany.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CreditRepository creditRepository;

    public void createProduct(Product product) {
        creditRepository.save(product.getCredit());
        productRepository.save(product);
    }

    public List<Product> getProductList(Set<Long> idList) {
        return productRepository.findAllByCredit_IdIn(idList);
    }
}
