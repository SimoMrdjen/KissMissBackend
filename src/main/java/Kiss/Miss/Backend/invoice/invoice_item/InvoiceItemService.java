package Kiss.Miss.Backend.invoice.invoice_item;

import Kiss.Miss.Backend.invoice.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Component
public class InvoiceItemService {


    private final InvoiceItemMapper invoiceItemMapper;
    private final InvoiceItemRepository invoiceItemRepository;

    public List<InvoiceItemDTO> saveAll(List<InvoiceItemDTO> invoiceItemsDto, Invoice invoice) {

        List<InvoiceItem> invoiceItemList = invoiceItemRepository
                .saveAll(invoiceItemMapper.toEntities(invoiceItemsDto, invoice));

        return invoiceItemMapper.toDtos(invoiceItemList);
    }
}
