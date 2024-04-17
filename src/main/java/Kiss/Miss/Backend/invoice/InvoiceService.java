package Kiss.Miss.Backend.invoice;

import Kiss.Miss.Backend.customer.Customer;
import Kiss.Miss.Backend.exceptions.InvoiceException;
import Kiss.Miss.Backend.invoice.invoice_item.InvoiceItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Component
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;
    private final InvoiceItemService invoiceItemService;

    public InvoiceDTO addInvoice(InvoiceDTO dto) {
        Invoice invoice = invoiceRepository.save(invoiceMapper.toEntity(dto));
        invoiceItemService.saveAll(dto.getInvoiceItemsDto(), invoice);
        return   invoiceMapper.toDto(invoice);
    }

    public List<InvoiceDTO> getAllInvoices() {
        return invoiceRepository.findAll()
                .stream()
                .map(invoiceMapper::toDto)
                .toList();
    }

    public InvoiceDTO editInvoice(InvoiceDTO dto) throws Exception {
        if(invoiceRepository.findById(dto.getId()).isPresent()) {
            Invoice invoice = invoiceRepository.save(invoiceMapper.toEntity(dto));
            return   invoiceMapper.toDto((invoice));
        } else {
            throw new InvoiceException("Otpremnica ne postoji");
        }
    }

    public String deleteInvoice(Long id) throws InvoiceException {
        if(invoiceRepository.findById(id).isPresent()) {
            invoiceRepository.deleteById(id);
            return   "Otprmnica  je uspesno obrisana!";        } else {
            throw new InvoiceException("Otpremnica ne postoji");
        }
    }
}
