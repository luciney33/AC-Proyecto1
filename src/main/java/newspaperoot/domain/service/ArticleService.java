package newspaperoot.domain.service;

import jakarta.inject.Inject;
import lombok.Data;
import newspaperoot.dao.ArticleRepository;
import newspaperoot.dao.model.ArticleEntity;
import newspaperoot.domain.mappers.MapArticleDtoEntity;
import newspaperoot.domain.model.ArticleDTO;
import newspaperoot.domain.model.TypeDTO;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final MapArticleDtoEntity mapper;

    @Inject
    public ArticleService(ArticleRepository articleRepository, MapArticleDtoEntity mapper ) {
        this.articleRepository = articleRepository;
        this.mapper = mapper;
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
    public ArticleDTO getArticleById(int id) {
        ArticleEntity articleEntity = articleRepository.get(id);
        return new ArticleDTO(articleEntity.getId(),articleEntity.getName(),new TypeDTO(articleEntity.getType().getId(),articleEntity.getType().getDescription()),
                articleEntity.getNPaperId(),4);
    }
    public ArticleDTO saveArticle(ArticleDTO articleDTO) {
        ArticleEntity articleEntity = mapper.dtoToEntity(articleDTO);
        int id = articleRepository.save(articleEntity);
        articleDTO.setId(id); // actualizar id si el repo lo asigna
        return articleDTO;
    }

    public ArticleDTO updateArticle(ArticleDTO articleDTO) {
        ArticleEntity articleEntity = mapper.dtoToEntity(articleDTO);
        articleRepository.update(articleEntity);
        return articleDTO;
    }

    public ArticleDTO deleteArticle(ArticleDTO articleDTO) {
        ArticleEntity articleEntity = mapper.dtoToEntity(articleDTO);
        articleRepository.delete(articleEntity);
        return articleDTO;
    }
}
