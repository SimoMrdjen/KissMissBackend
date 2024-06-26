package Kiss.Miss.Backend.invoice.invoice_item;

import Kiss.Miss.Backend.invoice.InvoiceDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceItemDTO {

    private Long id;

    private Double price;

    private Integer quantity;

    private Integer discount;

    private String articleType;

    private InvoiceDTO invoiceDto;
}
