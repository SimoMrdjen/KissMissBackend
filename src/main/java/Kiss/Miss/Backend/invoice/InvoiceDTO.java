package Kiss.Miss.Backend.invoice;

import Kiss.Miss.Backend.customer.Customer;
import Kiss.Miss.Backend.customer.CustomerDTO;
import Kiss.Miss.Backend.invoice.invoice_item.InvoiceItemDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDTO {

    private Long id;
    private CustomerDTO customerDto;
    private LocalDate date;
    private List<InvoiceItemDTO> invoiceItemsDto = new ArrayList<>();
}
