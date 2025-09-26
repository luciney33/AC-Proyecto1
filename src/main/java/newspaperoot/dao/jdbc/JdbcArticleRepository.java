package newspaperoot.dao.jdbc;

import jakarta.enterprise.inject.Default;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Data;
import newspaperoot.common.Configuration;
import newspaperoot.dao.ArticleRepository;
import newspaperoot.dao.jdbc.mappers.MapResultSetToArticleEntity;
import newspaperoot.dao.model.ArticleEntity;
import newspaperoot.dao.utilities.Queries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
@Data
@Named("jdbcRepo")
public class JdbcArticleRepository implements ArticleRepository {
    private Configuration conf;
    private final MapResultSetToArticleEntity mapper;


    @Inject
    public JdbcArticleRepository(Configuration conf, MapResultSetToArticleEntity mapResultSetToArticleEntity) {
        this.conf = conf;
        this.mapper = mapResultSetToArticleEntity;
    }

    public Connection getConnection() throws SQLException {
        Connection myConnection = DriverManager.getConnection(conf.getProperty("urlDB"), conf.getProperty("user_name"),
                conf.getProperty("password"));
        return myConnection;
    }

    @Override
    public List<ArticleEntity> getAll() {
        List<ArticleEntity> articles = new ArrayList<>();
        try (Connection con = getConnection();
             Statement myStatement = con.createStatement()) {
            ResultSet articleRS = myStatement.executeQuery(Queries.SelectFrom);
            while (articleRS.next()) {
                List<ArticleEntity> article = mapper.mapRS(articleRS);
                articles.addAll(article);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return articles;
    }

    @Override
    public ArticleEntity get(int id) {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(Queries.SelectGet)) {
            ps.setInt(1, id);
            ResultSet articleRS = ps.executeQuery();
            if (articleRS.next()) {
                return new ArticleEntity(articleRS.getInt("id"),
                        articleRS.getString("name_article"),
                        new newspaperoot.dao.model.TypeEntity(articleRS.getInt("type_id"), articleRS.getString("type_description")),
                        articleRS.getInt("id_newspaper"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public int save(ArticleEntity article) {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(Queries.SelectSave, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(2, article.getName());
            ps.setInt(3, article.getNPaperId());
            ps.setInt(4, article.getType().getId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public void delete(ArticleEntity article) {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(Queries.Delete)) {
            ps.setInt(1, article.getId());
            if (ps.executeUpdate() == 0) {
                throw new SQLException("Deleting article failed, no rows affected.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(ArticleEntity article) {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(Queries.Update)) {
            ps.setString(1, article.getName());
            ps.setInt(2, article.getNPaperId());
            ps.setInt(3, article.getType().getId());
            ps.setInt(4, article.getId());
            if (ps.executeUpdate() == 0) {
                throw new SQLException("Updating article failed, no rows affected.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }
}
