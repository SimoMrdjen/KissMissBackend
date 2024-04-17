package Kiss.Miss.Backend.article;

import Kiss.Miss.Backend.exceptions.ArticleException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ArticleServiceTest {

    @Mock
    ArticleMapper mapper;

    @Mock
    ArticleRepository repository;

    @InjectMocks
    ArticleService service;

    Article article;
    ArticleDTO dto;

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
    void shouldAddArticle() {
        when(repository.save(article)).thenReturn(article);
        when(mapper.toEntity(dto)).thenReturn(article);
        when(mapper.toDto(article)).thenReturn(dto);
        assertEquals(service.addArticle(dto), dto);
    }

    @Test
    void shouldGetAllArticles() {
        when(repository.findAll()).thenReturn(List.of(article));
        when(mapper.toEntity(dto)).thenReturn(article);
        when(mapper.toDto(article)).thenReturn(dto);
        assertEquals(service.getAllArticles(), List.of( dto));
        assertThat(service.getAllArticles()).isEqualTo(List.of( dto));
    }

    @Test
    void shouldEditArticle() throws Exception {
        when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(article));
        when(repository.save(article)).thenReturn(article);
        when(mapper.toEntity(dto)).thenReturn(article);
        when(mapper.toDto(article)).thenReturn(dto);

        assertEquals(service.editArticle(dto), dto);
        //assertThat(service.getAllArticles()).isEqualTo(List.of( dto));
    }

    @Test
    void shouldThrowWhenEditArticle() {
        when(repository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrowsExactly(ArticleException.class,
                () -> service.editArticle(dto));

    }

    @Test
    void shouldDeleteArticle() throws Exception {
        when(repository.findById(anyLong())).thenReturn(Optional.ofNullable(article));
        assertEquals("Artikal je uspesno obrisan", service.deleteArticle(1L));
        verify(repository).deleteById(1L);
    }

    void shouldThrowExceptionWhenArticleDoesNotExist() {
        when(repository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrowsExactly(ArticleException.class,
                () -> service.deleteArticle(anyLong()));
    }
}