package Kiss.Miss.Backend.customer;

import Kiss.Miss.Backend.article.ArticleMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class CustomerMapperTest {
    Customer customer;
    CustomerDTO customerDTO;

    @InjectMocks
    CustomerMapper mapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

       customer = new Customer();
        customer.setId(1L);
        customer.setCompany("Example Corp.");
        customer.setCity("New York");
        customer.setPerson("John Doe");

        customerDTO = new CustomerDTO();
        customerDTO.setId(1L);
        customerDTO.setCompany("Example Corp.");
        customerDTO.setCity("New York");
        customerDTO.setPerson("John Doe");

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void whenConvertCustomerEntityToCustomerDTO() {
      Customer expected = mapper.toEntity(customerDTO);
        assertEquals(expected.getId(), customer.getId());
        assertEquals(expected.getCity(), customer.getCity());
        assertEquals(expected.getCompany(), customer.getCompany());
        assertEquals(expected.getPerson(), customer.getPerson());



    }

    @Test
    void whenConvertCustomerDTOtoCustomerEntity() {
        assertEquals(mapper.toDto(customer), customerDTO);
    }
}