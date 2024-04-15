package Kiss.Miss.Backend.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;

@RequiredArgsConstructor
@Service
@Component
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

    public Article addArticle(ArticleDTO dto) {
        return articleRepository.save(articleMapper.toEntity(dto));
    }

    public List<ArticleDTO> getAllArticles() {
        return articleRepository.findAll()
                .stream()
                .map(articleMapper::toDto)
                .toList();
    }
}
