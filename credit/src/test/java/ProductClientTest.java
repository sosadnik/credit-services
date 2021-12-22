import com.mycompany.credit.client.ProductClient;
import com.mycompany.credit.model.Credit;
import com.mycompany.credit.model.Product;
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

public class ProductClientTest {

    private RestTemplate restTemplate;
    private ProductClient productClient;

    @BeforeEach
    public void setup() {
        restTemplate = new RestTemplate();
        productClient = new ProductClient(restTemplate);
    }

    @RegisterExtension
    public StubRunnerExtension stubRunner = new StubRunnerExtension()
            .downloadStub("org.creditservices", "product", "1.0-SNAPSHOT", "stubs")
            .withPort(8100)
            .stubsMode(StubRunnerProperties.StubsMode.LOCAL);

    @Test
    void getProduct_shouldReturnProductList() {
        Set<Long> idList = Set.of(1L, 2L);
        ArrayList<Product> expected = new ArrayList<>();
        expected.add(new Product(1L, new Credit(1L, "bulka"), "panierka", 3));
        expected.add(new Product(2L, new Credit(2L, "pies"), "kot", 3));

        List<Product> actual = productClient.getProduct(idList, "http://localhost:8100");

        assertEquals(expected, actual);
    }

    @Test
    void createProduct_shouldReturnNull() {
        Product product = (new Product(1L, new Credit(1L, "bulka"), "panierka", 3));


        ResponseEntity responseEntity = restTemplate.postForObject("http://localhost:8100/product/create", product, ResponseEntity.class);

        assertEquals(null, responseEntity);
    }


}
