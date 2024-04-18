package Kiss.Miss.Backend.customer;

import Kiss.Miss.Backend.exceptions.ArticleException;
import Kiss.Miss.Backend.exceptions.CustomerException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

   @Mock CustomerRepository repository;
   @Mock CustomerMapper mapper;
   @InjectMocks CustomerService service;
   Customer customer;
   CustomerDTO customerDTO;

    @BeforeEach
    void setUp() {
//        MockitoAnnotations.openMocks(this);
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
    void shouldAddCustomer() {
        when(repository.save(customer)).thenReturn(customer);
        when(mapper.toEntity(customerDTO)).thenReturn(customer);
        when(mapper.toDto(customer)).thenReturn(customerDTO);

        assertEquals(service.addCustomer(customerDTO), customerDTO);
        verify(repository).save(customer);
        verify(mapper).toDto(customer);
        verify(mapper).toEntity(customerDTO);

    }

    @Test
    void shouldGetAllCustomer() {
        when(repository.findAll()).thenReturn(List.of(customer));
        when(mapper.toDto(any(Customer.class))).thenReturn(customerDTO);
        assertEquals(service.getAllCustomer(), List.of( customerDTO));
    }

    @Test
    void shouldEditCustomer() throws Exception {
        when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(customer));
        when(repository.save(customer)).thenReturn(customer);
        when(mapper.toEntity(customerDTO)).thenReturn(customer);
        when(mapper.toDto(customer)).thenReturn(customerDTO);
        assertEquals(service.editCustomer(customerDTO), customerDTO);
    }

    @Test
    void shouldThrowWhenEditCustomer() {
        when(repository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrowsExactly(CustomerException.class,
                () -> service.editCustomer(customerDTO));

    }
    @Test
    void shouldDeleteCustomer() throws Exception {
        when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(customer));
        assertEquals("Kupac je uspesno obrisan", service.deleteCustomer(1L));
        verify(repository).deleteById(1L);
    }

    @Test
    void shouldThrowExceptionWhenCustomerDoesNotExist() {
        when(repository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrowsExactly(CustomerException.class,
                () -> service.deleteCustomer(anyLong()));
    }
}