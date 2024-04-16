package Kiss.Miss.Backend.invoice;

import Kiss.Miss.Backend.customer.Customer;
import Kiss.Miss.Backend.customer.CustomerMapper;
import Kiss.Miss.Backend.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Component
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;

    public InvoiceDTO addInvoice(InvoiceDTO dto) {
        Invoice invoice = invoiceRepository.save(invoiceMapper.toEntity(dto));
        return   invoiceMapper.toDto(invoice);
    }
}
