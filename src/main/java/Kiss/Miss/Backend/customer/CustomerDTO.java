package Kiss.Miss.Backend.customer;

import Kiss.Miss.Backend.invoice.Invoice;
import Kiss.Miss.Backend.invoice.InvoiceDTO;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private Long id;

    private String company;

    private String city;

    private String person;

   // private List<InvoiceDTO> invoices = new ArrayList<>();
}
