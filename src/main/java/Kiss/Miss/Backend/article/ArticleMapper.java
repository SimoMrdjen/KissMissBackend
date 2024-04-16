package Kiss.Miss.Backend.article;

import org.springframework.stereotype.Component;

@Component
public class ArticleMapper {

    public Article toEntity(ArticleDTO dto) {

        return Article.builder()
                .id(dto.getId())
                .code(dto.getCode())
                .price(dto.getPrice())
                .build();
    }

    public ArticleDTO toDto(Article article) {
        return ArticleDTO.builder()
                .id(article.getId())
                .code(article.getCode())
                .price(article.getPrice())
                .build();
    }
}
