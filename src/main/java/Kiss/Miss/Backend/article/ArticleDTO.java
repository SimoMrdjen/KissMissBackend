package Kiss.Miss.Backend.article;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO {

    private Integer id;

    private String code;

    private Double price;

}
