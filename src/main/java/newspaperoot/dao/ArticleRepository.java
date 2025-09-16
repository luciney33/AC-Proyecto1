package newspaperoot.dao;

import newspaperoot.dao.model.ArticleEntity;
import newspaperoot.dao.model.TypeEntity;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    public List<ArticleEntity> getAll() {
        //Connect to the database
        //Require with SQL all the articles
        //Return the list of ArticleEntity
        List<ArticleEntity> articles = new ArrayList<>();
        articles.add(new ArticleEntity(1, "Article 1", new TypeEntity(1,"sports"),2));
        return articles;
    }
}
