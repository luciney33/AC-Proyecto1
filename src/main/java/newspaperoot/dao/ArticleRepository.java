package newspaperoot.dao;

import newspaperoot.dao.model.ArticleEntity;

import java.util.List;

public interface ArticleRepository {
    List<ArticleEntity> getAll();
    ArticleEntity get(int id);
    int save(ArticleEntity article);
    int delete(ArticleEntity article);
    int update(ArticleEntity article, String newName);
}
