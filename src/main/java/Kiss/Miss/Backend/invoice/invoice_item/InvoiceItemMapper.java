package Kiss.Miss.Backend.invoice.invoice_item;

import Kiss.Miss.Backend.invoice.Invoice;
import Kiss.Miss.Backend.invoice.InvoiceDTO;
import Kiss.Miss.Backend.invoice.InvoiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InvoiceItemMapper {

 //   private final InvoiceMapper invoiceMapper;

//    public List<InvoiceItem> toEntities(List<InvoiceItemDTO> invoiceItems) {
//        return invoiceItems.stream()
//                .map(i -> toEntity(i))
//                .toList();
//    }
    public List<InvoiceItem> toEntities(List<InvoiceItemDTO> invoiceItems, Invoice invoice) {
        return invoiceItems.stream()
                .map(i -> this.toEntity(i, invoice))
                .toList();
    }
//    private InvoiceItem toEntity(InvoiceItemDTO dto) {
//        Invoice invoice = invoiceMapper.toEntity(dto.getInvoiceDto());
//        return InvoiceItem.builder()
//                .id(dto.getId())
//                .invoice(invoice)
//                .articleType(dto.getArticleType())
//                .discount(dto.getDiscount())
//                .price(dto.getPrice())
//                .build();
//    }
    public InvoiceItem toEntity(InvoiceItemDTO dto, Invoice invoice) {
        return InvoiceItem.builder()
                .id(dto.getId())
                .invoice(invoice)
                .quantity(dto.getQuantity())
                .articleType(dto.getArticleType())
                .discount(dto.getDiscount())
                .price(dto.getPrice())
                .build();
    }
    public List<InvoiceItemDTO> toDtos(List<InvoiceItem> invoiceItems) {
        return invoiceItems.stream()
                .map(i -> toDto(i))
                .toList();
    }

    private InvoiceItemDTO toDto(InvoiceItem invoiceItem) {
//        InvoiceDTO invoiceDto = invoiceMapper.toDto(invoiceItem.getInvoice());
        return InvoiceItemDTO.builder()
                .id(invoiceItem.getId())
//                .invoiceDto(invoiceDTO)
                .articleType(invoiceItem.getArticleType())
                .discount(invoiceItem.getDiscount())
                .price(invoiceItem.getPrice())
                .build();
    }
}
