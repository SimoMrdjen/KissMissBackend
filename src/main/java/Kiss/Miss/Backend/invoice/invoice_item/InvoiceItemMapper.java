package Kiss.Miss.Backend.invoice.invoice_item;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InvoiceItemMapper {


    public List<InvoiceItem> toEntities(List<InvoiceItemDTO> invoiceItems) {
        return invoiceItems.stream()
                .map(this::toEntity)
                .toList();
    }

    private InvoiceItem toEntity(InvoiceItemDTO dto) {
        return InvoiceItem.builder()
                .id(dto.getId())
                .invoice()
                .build();
    }
}
