package Kiss.Miss.Backend.invoice;

import Kiss.Miss.Backend.customer.Customer;
import Kiss.Miss.Backend.customer.CustomerDTO;
import Kiss.Miss.Backend.customer.CustomerMapper;
import Kiss.Miss.Backend.invoice.invoice_item.InvoiceItem;
import Kiss.Miss.Backend.invoice.invoice_item.InvoiceItemDTO;
import Kiss.Miss.Backend.invoice.invoice_item.InvoiceItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class InvoiceMapper {
    private final CustomerMapper customerMapper;
    private final InvoiceItemMapper invoiceItemMapper;


    public Invoice toEntity(InvoiceDTO dto) {
//        List<InvoiceItem> invoiceItems = dto.getInvoiceItemsDto().stream()
//                .map(itemDto -> invoiceItemMapper.toEntity(itemDto, null)) // Null or handle differently
//                .collect(Collectors.toList());
        Customer customer  = customerMapper.toEntity(dto.getCustomerDto());
        return Invoice.builder()
                .id(dto.getId())
                .customer(customer)
                .date(dto.getDate())
//                .invoiceItems(invoiceItems)
                .build();
    }

    public InvoiceDTO toDto(Invoice invoice) {
        CustomerDTO customerDTO = customerMapper.toDto(invoice.getCustomer());
        List<InvoiceItemDTO> itemsDto = invoiceItemMapper.toDtos(invoice.getInvoiceItems());
        return InvoiceDTO.builder()
                .id(invoice.getId())
                .customerDto(customerDTO)
                .date(invoice.getDate())
                .invoiceItemsDto(itemsDto)
                .build();
    }
}
