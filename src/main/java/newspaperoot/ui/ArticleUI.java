package newspaperoot.ui;

import lombok.AllArgsConstructor;
import lombok.Data;
import newspaperoot.dao.model.ArticleEntity;
import newspaperoot.dao.model.TypeEntity;
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

    public ArticleDTO getArticle(int id) {
        return articleService.getArticleById(id);
    }

    public void getSavedArticle(ArticleDTO article) {
        articleService.saveArticle(article);


    }
    public void getDeleteArticle(ArticleEntity articleEntity) {

    }

}
