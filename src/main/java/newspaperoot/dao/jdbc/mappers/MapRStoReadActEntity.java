package newspaperoot.dao.jdbc.mappers;

import newspaperoot.dao.model.ReadActivityEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MapRStoReadActEntity {
    public ReadActivityEntity mapRS(ResultSet rs) throws SQLException {
        return new ReadActivityEntity(
                rs.getInt("id_reader"),
                rs.getInt("id_article"),
                rs.getString("name"),
                rs.getDate("birth_date").toLocalDate(),
                List.of(String.valueOf(rs.getInt("id_newspaper"))),
                rs.getInt("rating")
        );
    }
}
