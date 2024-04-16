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
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        return ResponseEntity.ok(invoiceService.getAllCustomer());
    }

    @PutMapping
    public ResponseEntity<CustomerDTO> editCustomer(@RequestBody CustomerDTO dto) throws Exception {
        return ResponseEntity.ok(invoiceService.editCustomer(dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String>deleteCustomer(@RequestParam(name = "id") Long id) throws Exception {
        return ResponseEntity.ok(invoiceService.deleteCustomer(id));
    }
}
