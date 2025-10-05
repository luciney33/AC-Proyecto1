package newspaperoot.dao.jdbc.mappers;

import newspaperoot.dao.model.NewspaperEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapRStoNewspaperEntity {
    public NewspaperEntity mapRS(ResultSet rs) throws SQLException {
        return new NewspaperEntity(
                rs.getInt("id_newpaper"),rs.getString("name"), rs.getDate("date").toLocalDate());
    }
}
