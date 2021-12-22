package com.mycompany.credit.service;

import com.mycompany.credit.client.CustomerClient;
import com.mycompany.credit.client.ProductClient;
import com.mycompany.credit.mapper.MapperResponse;
import com.mycompany.credit.model.Credit;
import com.mycompany.credit.model.Customer;
import com.mycompany.credit.model.Product;
import com.mycompany.credit.repository.CreditRepository;
import com.mycompany.credit.service.dto.DataDto;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreditService {
    private final CreditRepository creditRepository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final MapperResponse mapper;
    private final static String URL_CUSTOMER = "http://customer:8082";
    private final static String URL_PRODUCT = "http://product:8083";

    public Long createCredit(DataDto request) {
        Credit credit = new Credit(request.getCredit().getCreditName());
        credit.setId(creditRepository.saveAndFlush(credit).getId());

        customerClient.createCustomer(mapper.mappingCustomer(request, credit), URL_CUSTOMER);
        productClient.createProduct(mapper.mappingProduct(request, credit), URL_PRODUCT);

        return credit.getId();
    }

    public List<DataDto> getCredits() {
        List<Credit> creditList = creditRepository.findAll();
        Set<Long> idList = creditList.stream().map(Credit::getId).collect(Collectors.toSet());
        List<Customer> customerList = customerClient.getCustomer(idList, URL_CUSTOMER);
        List<Product> productList = productClient.getProduct(idList, URL_PRODUCT);

        return mapper.buildResponseList(creditList, customerList, productList);
    }

}

