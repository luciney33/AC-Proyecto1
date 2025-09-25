package newspaperoot.dao.jdbc.mappers;

import newspaperoot.dao.model.ArticleEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapResultSetToArticleEntity {
    public ArticleEntity mapResultSetToArticleEntity(ResultSet rs) throws SQLException {
        return new ArticleEntity(
                rs.getInt("id"),
                rs.getString("name"),
                null,
                rs.getInt("nPaperId")
        );
    }

}
