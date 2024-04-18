package Kiss.Miss.Backend.invoice.invoice_item;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class InvoiceItemMapperTest {

    @InjectMocks InvoiceItemMapper mapper;
    InvoiceItemDTO dto;
    InvoiceItem item;

    @BeforeEach
    void setUp() {
        dto = InvoiceItemDTO.builder()
                .id(1L)
                .price(199.99)
                .quantity(2)
                .discount(10)
                .articleType("Dress")
//                .invoiceDto(dto) // Assuming this is correctly instantiated somewhere else.
                .build();

        item = InvoiceItem.builder()
                .id(1L)
                .price(199.99)
                .quantity(2)
                .discount(10)
                .articleType("Dress")
//                .invoice(invoice) // Assuming this is correctly instantiated somewhere else.
                .build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shouldReturnEntities() {

    }

    @Test
    void shouldReturnEntity() {
    }

    @Test
    void toDtos() {
    }
}