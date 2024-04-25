package Kiss.Miss.Backend.invoice.invoice_item;

import Kiss.Miss.Backend.invoice.Invoice;
import Kiss.Miss.Backend.invoice.InvoiceDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class InvoiceItemMapperTest {

    @InjectMocks InvoiceItemMapper mapper;
    InvoiceItemDTO dto;
    InvoiceItem item;
    Invoice invoice;
    InvoiceDTO invoiceDto;


    @BeforeEach
    void setUp() {
        invoice = new Invoice(1L, null, null,null);
        invoiceDto = new InvoiceDTO(1L, null, null,null);

        dto = InvoiceItemDTO.builder()
                .id(1L)
                .price(199.99)
                .quantity(2)
                .discount(10)
                .articleType("Dress")
                .invoiceDto(new InvoiceDTO(1L, null, null,null))
                .build();

        item = InvoiceItem.builder()
                .id(1L)
                .price(199.99)
                .quantity(2)
                .discount(10)
                .articleType("Dress")
                .invoice(new Invoice(1L, null, null,null))
                .build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shouldReturnEntities() {
        assertEquals(List.of(item), mapper.toEntities(List.of(dto), invoice));
    }

    @Test
    void shouldReturnEntity() {
        assertEquals(item, mapper.toEntity(dto, invoice));
    }

    @Test
    void toDtos() {
    }
}