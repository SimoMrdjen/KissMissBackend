package Kiss.Miss.Backend.invoice;

import Kiss.Miss.Backend.customer.Customer;
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
    @JoinColumn(name = "id")
    private Customer customer;

    @Column
    private LocalDate date;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id")
    private List<InvoiceItem> invoiceItems = new ArrayList<>();
}
