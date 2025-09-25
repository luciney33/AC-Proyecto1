package newspaperoot.dao.Basic;

import newspaperoot.dao.ArticleRepository;
import newspaperoot.dao.model.ArticleEntity;
import newspaperoot.dao.model.TypeEntity;

import java.util.ArrayList;
import java.util.List;

public class BasicArticleRepository {
    public final List<ArticleEntity> articles = new ArrayList<>(); {
        articles.add(new ArticleEntity(1, "Article 1", new TypeEntity(1,"sports"),2));
        articles.add(new ArticleEntity(2, "Article 2", new TypeEntity(2,"politics"),1));
        articles.add(new ArticleEntity(3, "Article 3", new TypeEntity(3,"economy"),3));
    }



    public List<ArticleEntity> getAll() {
        return articles;
    }

    public ArticleEntity get(int id) {
        return articles.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
    }

    public int save(ArticleEntity article) {//el id que devuelve para el cliente
        articles.add(article);
        return article.getId();
    }

    public void delete(ArticleEntity article) {
        articles.removeIf(a -> a.getId() == article.getId());
    }

    public void update(ArticleEntity article) {
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getId() == article.getId()) {
                articles.set(i, article);
            }
        }
    }
}
