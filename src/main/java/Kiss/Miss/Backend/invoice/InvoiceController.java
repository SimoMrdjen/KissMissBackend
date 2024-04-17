package Kiss.Miss.Backend.invoice;

import Kiss.Miss.Backend.customer.CustomerDTO;
import Kiss.Miss.Backend.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/invoice")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<InvoiceDTO> addInvoice(@RequestBody InvoiceDTO dto) {
        return ResponseEntity.ok(invoiceService.addInvoice(dto));
    }

    @GetMapping
    public ResponseEntity<List<InvoiceDTO>> getAllInvoicess() {
        return ResponseEntity.ok(invoiceService.getAllInvoices());
    }

    @PutMapping
    public ResponseEntity<InvoiceDTO> editInvoice(@RequestBody InvoiceDTO dto) throws Exception {
        return ResponseEntity.ok(invoiceService.editInvoice(dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String>deleteInvoice(@RequestParam(name = "id") Long id) throws Exception {
        return ResponseEntity.ok(invoiceService.deleteInvoice(id));
    }
}
