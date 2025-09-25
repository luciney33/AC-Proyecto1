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

    public ArticleDTO getArticleById(int id) {
        return articleService.getArticleById(id);
    }

    public ArticleDTO saveArticle(ArticleDTO articleDTO) {
        return articleService.saveArticle(articleDTO);
    }

    public ArticleDTO deleteArticle(ArticleDTO articleDTO) {
        return articleService.deleteArticle(articleDTO);
    }

    public ArticleDTO updateArticle(ArticleDTO articleDTO) {
        return articleService.updateArticle(articleDTO);
    }

}
