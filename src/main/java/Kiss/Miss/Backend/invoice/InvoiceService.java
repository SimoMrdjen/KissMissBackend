package Kiss.Miss.Backend.invoice;

import Kiss.Miss.Backend.customer.Customer;
import Kiss.Miss.Backend.exceptions.InvoiceException;
import Kiss.Miss.Backend.invoice.invoice_item.InvoiceItem;
import Kiss.Miss.Backend.invoice.invoice_item.InvoiceItemDTO;
import Kiss.Miss.Backend.invoice.invoice_item.InvoiceItemMapper;
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
    private final InvoiceItemMapper invoiceItemMapper;

    public InvoiceDTO addInvoice(InvoiceDTO dto) {
        Invoice invoice = invoiceMapper.toEntity(dto);
        List<InvoiceItemDTO> items = invoiceItemService.saveAll(dto.getInvoiceItemsDto(), invoice);
        InvoiceDTO invoiceDTO = invoiceMapper.toDto(invoice);
        invoiceDTO.setInvoiceItemsDto(items);
        return invoiceDTO;
    }

    public List<InvoiceDTO> getAllInvoices() {
        return invoiceRepository.findAll()
                .stream()
                .map(invoiceMapper::toDto)
                .toList();
    }

    public InvoiceDTO editInvoice(InvoiceDTO dto) throws Exception {
        if(invoiceRepository.findById(dto.getId()).isPresent()) {
            Invoice invoice =
                    invoiceRepository.save(invoiceMapper.toEntity(dto));
            List<InvoiceItemDTO> itemDtos =
                    invoiceItemMapper.toDtos(invoice.getInvoiceItems());
            InvoiceDTO dtoResponse = invoiceMapper.toDto((invoice));
            dtoResponse.setInvoiceItemsDto(itemDtos);
            return  dtoResponse ;
        } else {
            throw new InvoiceException("Otpremnica ne postoji");
        }
    }

    public String deleteInvoice(Long id) throws InvoiceException {
        if(invoiceRepository.findById(id).isPresent()) {
            invoiceRepository.deleteById(id);
            return   "Otpremnica  je uspesno obrisana!";
        } else {
            throw new InvoiceException("Otpremnica ne postoji");
        }
    }
}
