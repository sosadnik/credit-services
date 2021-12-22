package com.mycompany.credit.mapper;


import com.mycompany.credit.model.Credit;
import com.mycompany.credit.model.Customer;
import com.mycompany.credit.model.Product;
import com.mycompany.credit.service.dto.CreditDto;
import com.mycompany.credit.service.dto.CustomerDto;
import com.mycompany.credit.service.dto.DataDto;
import com.mycompany.credit.service.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MapperResponse {

    public Customer mappingCustomer(DataDto request, Credit credit) {
        return new Customer(
                request.getCustomer().getFirstName(),
                request.getCustomer().getSureName(),
                request.getCustomer().getPesel(),
                credit);
    }

    public Product mappingProduct(DataDto request, Credit credit) {
        return new Product(
                request.getProduct().getProductName(),
                request.getProduct().getValue(),
                credit);
    }

    public DataDto mappingDataResponse(Credit credit, Optional<Customer> customer, Optional<Product> product) {
        return new DataDto(
                new CreditDto(credit.getCreditName()),
                new CustomerDto(customer.get().getFirstName(), customer.get().getSureName(), customer.get().getPesel()),
                new ProductDto(product.get().getProductName(), product.get().getValue()));
    }

    public List<DataDto> buildResponseList(List<Credit> creditList, List<Customer> customerList, List<Product> productList) {
        List<DataDto> responseList = new ArrayList<>();
        for (Credit credit : creditList) {
            Optional<Customer> customer2 = customerList.stream().filter(customer1 -> customer1.getCredit().getId().equals(credit.getId())).findFirst();
            Optional<Product> product1 = productList.stream().filter(product -> product.getCredit().getId().equals(credit.getId())).findFirst();
            responseList.add(mappingDataResponse(credit, customer2, product1));
        }
        return responseList;
    }
}
