package com.mycompany.credit.client;

import com.mycompany.credit.model.Customer;
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
public class CustomerClient {

    private final RestTemplate restTemplate;

    public void createCustomer(Customer customer, String url) {
        System.out.println(url + "/customer/create");
        restTemplate.postForLocation(url + "/customer/create", customer);
    }

    public List<Customer> getCustomer(Set<Long> idList, String url) {
        ResponseEntity<Customer[]> responseEntity = restTemplate.postForEntity(
                url + "/customer/get",
                idList,
                Customer[].class);
        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }


}

