package newspaperoot.dao.jdbc;

import newspaperoot.dao.ArticleRepository;
import newspaperoot.dao.model.ArticleEntity;

import java.util.List;

public class jdbcArticleRepository implements ArticleRepository {
    @Override
    public List<ArticleEntity> getAll() {
        return List.of();
    }

    @Override
    public ArticleEntity get(int id) {
        return null;
    }

    @Override
    public int save(ArticleEntity article) {
        return 0;
    }

    @Override
    public void delete(ArticleEntity article) {

    }

    @Override
    public void update(ArticleEntity article) {

    }
}
