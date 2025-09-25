package newspaperoot.dao.jdbc;

import jakarta.inject.Inject;
import newspaperoot.dao.ArticleRepository;
import newspaperoot.dao.jdbc.mappers.MapResultSetToArticleEntity;
import newspaperoot.dao.model.ArticleEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcArticleRepository implements ArticleRepository {
    private final MapResultSetToArticleEntity mapper;

@Inject
    public JdbcArticleRepository(MapResultSetToArticleEntity mapResultSetToArticleEntity) {
        this.mapper = mapResultSetToArticleEntity;
    }
    @Override
    public List<ArticleEntity> getAll() {
        List<ArticleEntity> articles = new ArrayList<>();
        try {
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://dam2.mysql.iesquevedo.es:3335/luciapeñafiel_newspaperDB", "root", "quevedo2dam");
            Statement myStatement = myConnection.createStatement();
            ResultSet myResultSet = myStatement.executeQuery("SELECT * FROM Article");
            while (myResultSet.next()) {
                ArticleEntity article = mapper.mapResultSetToArticleEntity(myResultSet);
                articles.add(article);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return articles;
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
