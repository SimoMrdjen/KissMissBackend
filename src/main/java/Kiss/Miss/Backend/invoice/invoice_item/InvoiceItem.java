package Kiss.Miss.Backend.invoice.invoice_item;

import Kiss.Miss.Backend.customer.Customer;
import Kiss.Miss.Backend.invoice.Invoice;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "InvoiceItem")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double price;

    @Column
    private Integer quantity;

    @Column
    private Integer discount;

    @Column
    private String articleType;

    @ManyToOne
    @JoinColumn(name = "id")
    private Invoice invoice;
}
