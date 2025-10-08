package newspaperoot.dao.jdbc.mappers;

import newspaperoot.dao.model.TypeEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapRStoTypeEntity {
    public TypeEntity mapRS(ResultSet rs) throws SQLException {
        return new TypeEntity(rs.getInt("id_type"), rs.getString("name"), rs.getString("description"));
    }
}
