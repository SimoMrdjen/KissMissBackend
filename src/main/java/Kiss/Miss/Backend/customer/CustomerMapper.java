package Kiss.Miss.Backend.customer;

import Kiss.Miss.Backend.article.Article;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer toEntity(CustomerDTO dto) {
        return Customer.builder()
                .id(dto.getId())
                .company(dto.getCompany())
                .city(dto.getCity())
                .person(dto.getPerson())
                .build();
    }

    public CustomerDTO toDto(Customer customer) {
        return CustomerDTO.builder()
                .id(customer.getId())
                .company(customer.getCompany())
                .city(customer.getCity())
                .person(customer.getPerson())
                .build();
    }
}
