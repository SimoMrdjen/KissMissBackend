package Kiss.Miss.Backend.invoice;

import Kiss.Miss.Backend.customer.Customer;
import Kiss.Miss.Backend.invoice.invoice_item.InvoiceItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Invoice")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column
    private LocalDate date;

    @OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<InvoiceItem> invoiceItems = new ArrayList<>();
}
