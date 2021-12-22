package com.mycompany.customer;

import com.mycompany.customer.controller.CustomerController;
import com.mycompany.customer.model.Credit;
import com.mycompany.customer.model.Customer;
import com.mycompany.customer.services.CustomerService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class BaseContractTest {


    @BeforeEach
    public void setup() {
        ArrayList<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(1L,new Credit(1L, "bulka"),"tarta", "wytarta", "9898" ));
        customerList.add(new Customer(2L,new Credit(2L, "test2"),"first1", "sur2", "9898" ));

        CustomerService customerService = mock(CustomerService.class);
        given(customerService.getCustomerList(any())).willReturn(customerList);

        RestAssuredMockMvc.standaloneSetup(new CustomerController(customerService));

    }
}
