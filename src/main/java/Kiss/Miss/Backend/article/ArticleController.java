package Kiss.Miss.Backend.article;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping
    public ResponseEntity<ArticleDTO> addArticle(@RequestBody ArticleDTO dto) {
        return ResponseEntity.ok(articleService.addArticle(dto));
    }

    @GetMapping
    public ResponseEntity<List<ArticleDTO>> getAllArticles() {
        return ResponseEntity.ok(articleService.getAllArticles());
    }

    @PutMapping
    public ResponseEntity<ArticleDTO> editArticle(@RequestBody ArticleDTO dto) throws Exception {
        return ResponseEntity.ok(articleService.editArticle(dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String>deleteArticle(@RequestParam(name = "id") Long id) throws Exception {
        return ResponseEntity.ok(articleService.deleteArticle(id));
    }
}
