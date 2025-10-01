package newspaperoot.ui;

import jakarta.inject.Inject;
import lombok.AllArgsConstructor;
import lombok.Data;
import newspaperoot.dao.model.ArticleEntity;
import newspaperoot.dao.model.TypeEntity;
import newspaperoot.domain.Error.AppError;
import newspaperoot.domain.Error.DatabaseError;
import newspaperoot.domain.model.ArticleDTO;
import newspaperoot.domain.service.ArticleService;

import java.util.ArrayList;
import java.util.List;
@Data
public class ArticleUI {
    private final ArticleService articleService;

    @Inject
    public ArticleUI(ArticleService articleService) {
        this.articleService = articleService;
    }

    public List<ArticleDTO> getArticles() {
        List<ArticleDTO> lista = new ArrayList<>();
        try {
            lista=articleService.getAllArticles();
        }catch (DatabaseError e) {
            System.err.println("Database error during get all articles");
        }
        return lista;
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
