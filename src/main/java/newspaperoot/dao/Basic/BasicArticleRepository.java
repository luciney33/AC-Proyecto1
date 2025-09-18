package newspaperoot.dao.Basic;

import newspaperoot.dao.ArticleRepository;
import newspaperoot.dao.model.ArticleEntity;
import newspaperoot.dao.model.TypeEntity;

import java.util.ArrayList;
import java.util.List;

public class BasicArticleRepository implements ArticleRepository {
    public final List<ArticleEntity> articles = new ArrayList<>(); {
        articles.add(new ArticleEntity(1, "Article 1", new TypeEntity(1,"sports"),2));
        articles.add(new ArticleEntity(2, "Article 2", new TypeEntity(2,"politics"),1));
        articles.add(new ArticleEntity(3, "Article 3", new TypeEntity(3,"economy"),3));
    }


    @Override
    public List<ArticleEntity> getAll() {
        return articles;
    }

    @Override
    public ArticleEntity get(int id) {
        return articles.get(id);
    }

    @Override
    public int save(ArticleEntity article) {//el id que devuelve para el cliente
        return articles.get(article.getId()).getId();
    }

    @Override
    public void delete(ArticleEntity article) {
        articles.remove(article);
    }

    @Override
    public void update(ArticleEntity article) {
        articles.set(article.getId(), article);
    }
}
