package com.mycompany.credit.client;

import com.mycompany.credit.model.Product;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class ProductClient {

    private final RestTemplate restTemplate;

    public void createProduct(Product product, String url) {
        restTemplate.postForLocation(url + "/product/create", product);
    }

    public List<Product> getProduct(Set<Long> idList, String url) {

        ResponseEntity<Product[]> responseEntity = restTemplate.postForEntity(
                url + "/product/get",
                idList,
                Product[].class);
        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }
}

