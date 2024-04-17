package Kiss.Miss.Backend.article;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ArticleMapperTest {

    Article article;
    ArticleDTO dto;

    @InjectMocks
    ArticleMapper mapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    article = Article.builder()
                .id(1L)
                .code("A001")
                .price(15.75)
                .build();
       dto = ArticleDTO.builder()
                .id(1L)
                .code("A001")
                .price(15.75)
                .build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shouldReturnEntity() {
        assertEquals(mapper.toEntity(dto), article);
    }

    @Test
    void shouldReturnDto() {
        assertEquals(mapper.toDto(article), dto);
    }
}