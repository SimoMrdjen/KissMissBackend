package Kiss.Miss.Backend.article;

import Kiss.Miss.Backend.exceptions.ArticleException;
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

    public ArticleDTO addArticle(ArticleDTO dto) {
        Article article = articleRepository.save(articleMapper.toEntity(dto));
        return   articleMapper.toDto((article));    }

    public List<ArticleDTO> getAllArticles() {
        return articleRepository.findAll()
                .stream()
                .map(articleMapper::toDto)
                .toList();
    }

    public ArticleDTO editArticle(ArticleDTO dto) throws Exception {
        if(articleRepository.findById(dto.getId()).isPresent()) {
            Article article = articleRepository.save(articleMapper.toEntity(dto));
            return   articleMapper.toDto((article));
        } else {
            throw new ArticleException("Artikal ne postoji");
        }

    }

    public String deleteArticle(Long id) throws Exception {
        if(articleRepository.findById(id).isPresent()) {
            articleRepository.deleteById(id);
            return   "Artikal je uspesno obrisan";
        } else {
            throw new ArticleException("Artikal ne postoji");
        }
    }
}
