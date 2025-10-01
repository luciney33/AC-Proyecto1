package newspaperoot.dao.jdbc.mappers;

import newspaperoot.dao.model.ArticleEntity;
import newspaperoot.dao.model.TypeEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MapResultSetToArticleEntity {

    public ArticleEntity mapRS(ResultSet rs) throws SQLException {
        return new ArticleEntity(
                rs.getInt("id_article"),
                rs.getString("name_article"),
                new TypeEntity(rs.getInt("id_type"), rs.getString("description")),
                rs.getInt("id_newspaper")
        );
    }

}
