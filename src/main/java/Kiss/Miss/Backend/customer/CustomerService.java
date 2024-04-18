package Kiss.Miss.Backend.customer;

import Kiss.Miss.Backend.article.Article;
import Kiss.Miss.Backend.article.ArticleMapper;
import Kiss.Miss.Backend.exceptions.CustomerException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Component
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerDTO addCustomer(CustomerDTO dto) {
        Customer customer = customerRepository.save(customerMapper.toEntity(dto));
        return   customerMapper.toDto(customer);
    }

    public List<CustomerDTO> getAllCustomer() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toDto)
                .toList();
    }

    public CustomerDTO editCustomer(CustomerDTO dto) throws Exception {
        if(customerRepository.findById(dto.getId()).isPresent()) {
            Customer customer = customerRepository.save(customerMapper.toEntity(dto));
            return   customerMapper.toDto((customer));
        } else {
            throw new CustomerException("Kupac ne postoji");
        }
    }

    public String deleteCustomer(Long id) throws Exception {
        if(customerRepository.findById(id).isPresent()) {
            customerRepository.deleteById(id);
            return   "Kupac je uspesno obrisan";
        } else {
            throw new CustomerException("Kupac ne postoji");
        }
    }
}
