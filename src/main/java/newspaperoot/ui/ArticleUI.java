package newspaperoot.ui;

import newspaperoot.domain.model.ArticleDTO;
import newspaperoot.domain.service.ArticleService;

import java.util.List;

public class ArticleUI {
    private final ArticleService articleService;
    public ArticleUI(ArticleService articleService) {
        this.articleService = articleService;
    }

    public List<ArticleDTO> getArticles() {
        return articleService.getAllArticles();
    }
}
