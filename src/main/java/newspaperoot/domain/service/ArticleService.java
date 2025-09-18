package newspaperoot.domain.service;

import lombok.Data;
import newspaperoot.dao.Basic.BasicArticleRepository;
import newspaperoot.dao.model.ArticleEntity;
import newspaperoot.domain.model.ArticleDTO;
import newspaperoot.domain.model.TypeDTO;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ArticleService {

    private final BasicArticleRepository articleRepository;

    public ArticleService(BasicArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<ArticleDTO> getAllArticles() {
        List<ArticleEntity> articles = articleRepository.getAll();
        List<ArticleDTO> articleDTOs = articles.stream()
                .map(article -> new ArticleDTO(article.getId(),article.getName(),
                        new TypeDTO(article.getType().getId(),article.getType().getDescription()),article.getNPaperId(),1)).collect(Collectors.toList());
        return articleDTOs;
        // Create a list of ArticleDTOs from the list of ArticleEntity
        //Return the list of EntityDTOs
    }
}
