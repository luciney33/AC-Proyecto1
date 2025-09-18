package newspaperoot.dao;

import newspaperoot.dao.model.ArticleEntity;
import newspaperoot.dao.model.CredentialEntity;

import java.util.List;

public interface ArticleRepository {
    List<ArticleEntity> getAll();
    ArticleEntity get(int id);
    int save(ArticleEntity article);
    void delete(ArticleEntity article);
    void update(ArticleEntity article);
}
