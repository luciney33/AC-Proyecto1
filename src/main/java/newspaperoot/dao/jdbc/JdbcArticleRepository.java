package newspaperoot.dao.jdbc;

import jakarta.inject.Inject;
import newspaperoot.common.Configuration;
import newspaperoot.dao.ArticleRepository;
import newspaperoot.dao.jdbc.mappers.MapResultSetToArticleEntity;
import newspaperoot.dao.model.ArticleEntity;
import newspaperoot.dao.utilities.Queries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JdbcArticleRepository implements ArticleRepository {
    private Configuration conf;
    private final MapResultSetToArticleEntity mapper;

@Inject
    public JdbcArticleRepository(MapResultSetToArticleEntity mapResultSetToArticleEntity) {
        this.mapper = mapResultSetToArticleEntity;
    }
    @Override
    public List<ArticleEntity> getAll() {
        List<ArticleEntity> articles = new ArrayList<>();
        try {
            Connection myConnection = DriverManager.getConnection(conf.getProperty("urlDB"),conf.getProperty("user_name"),
                    conf.getProperty("password"));

            Statement myStatement = myConnection.createStatement();
            ResultSet articleRS = myStatement.executeQuery(Queries.SelectFrom);
            while (articleRS.next()) {
                List<ArticleEntity> article = mapper.mapRS(articleRS);
                articles.add((ArticleEntity) article);
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
