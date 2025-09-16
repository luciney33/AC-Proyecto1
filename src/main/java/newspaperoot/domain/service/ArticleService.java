package newspaperoot.domain.service;

import newspaperoot.dao.ArticleRepository;
import newspaperoot.dao.model.ArticleEntity;
import newspaperoot.domain.model.ArticleDTO;

import java.util.List;

public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<ArticleDTO> getAllArticles() {
        List<ArticleEntity> articles = articleRepository.getAll();
        // Create a list of ArticleDTOs from the list of ArticleEntity
        //Return the list of EntityDTOs
    }
}
