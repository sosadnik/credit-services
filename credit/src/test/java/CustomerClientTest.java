import com.mycompany.credit.client.CustomerClient;
import com.mycompany.credit.model.Credit;
import com.mycompany.credit.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerExtension;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerClientTest {

    private CustomerClient customerClient;
    private RestTemplate restTemplate;

    @BeforeEach
    public void setup(){
        restTemplate = new RestTemplate();
        customerClient = new CustomerClient(restTemplate);
    }

    @RegisterExtension
    public StubRunnerExtension stubRunner = new StubRunnerExtension()
            .downloadStub("org.creditservices", "customer", "1.0-SNAPSHOT", "stubs")
            .withPort(8100)
            .stubsMode(StubRunnerProperties.StubsMode.LOCAL);


    @Test
    void getCustomer_shouldReturnCustomerList() {
        Set<Long> idList = Set.of(1L, 2L);
        ArrayList<Customer> expected = new ArrayList<>();
        expected.add(new Customer(1L, new Credit(1L, "bulka"), "tarta", "wytarta", "9898"));
        expected.add(new Customer(2L, new Credit(2L, "test2"), "first1", "sur2", "9898"));

        List<Customer> actual = customerClient.getCustomer(idList, "http://localhost:8100");

        assertEquals(expected, actual);
    }


    @Test
    void createCustomer_shouldReturnNull(){
        Customer customer = new Customer(1L, new Credit(1L, "bulka"), "tarta", "wytarta", "9898");

        ResponseEntity responseEntity = restTemplate.postForObject("http://localhost:8100/customer/create", customer, ResponseEntity.class);

        assertEquals(null,responseEntity );
    }


}
