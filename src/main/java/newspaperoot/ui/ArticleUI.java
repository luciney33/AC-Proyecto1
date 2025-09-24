package newspaperoot.ui;

import lombok.AllArgsConstructor;
import lombok.Data;
import newspaperoot.domain.model.ArticleDTO;
import newspaperoot.domain.service.ArticleService;

import java.util.List;
@Data


public class ArticleUI {
    private final ArticleService articleService;
    public ArticleUI(ArticleService articleService) {
        this.articleService = articleService;
    }

    public List<ArticleDTO> getArticles() {
        return articleService.getAllArticles();
    }

}
