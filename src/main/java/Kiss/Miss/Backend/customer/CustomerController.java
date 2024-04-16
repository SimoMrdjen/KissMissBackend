package Kiss.Miss.Backend.customer;

import Kiss.Miss.Backend.article.ArticleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO dto) {
        return ResponseEntity.ok(customerService.addCustomer(dto));
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @PutMapping
    public ResponseEntity<CustomerDTO> editCustomer(@RequestBody CustomerDTO dto) throws Exception {
        return ResponseEntity.ok(customerService.editCustomer(dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String>deleteCustomer(@RequestParam(name = "id") Long id) throws Exception {
        return ResponseEntity.ok(customerService.deleteCustomer(id));
    }
}
