package Kiss.Miss.Backend.invoice;

import Kiss.Miss.Backend.customer.Customer;
import Kiss.Miss.Backend.customer.CustomerMapper;
import Kiss.Miss.Backend.invoice.invoice_item.InvoiceItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InvoiceMapper {
    private final CustomerMapper customerMapper;
    private final InvoiceItemMapper invoiceItemMapper;


    public Invoice toEntity(InvoiceDTO dto) {
        Customer customer  = customerMapper.toEntity(dto.getCustomerDto());
        return Invoice.builder()
                .id(dto.getId())
                .customer(customer)
                .date(dto.getDate())
                .invoiceItems(invoiceItemMapper.toEntities(dto.getInvoiceItems()))
                .build();
    }
}
