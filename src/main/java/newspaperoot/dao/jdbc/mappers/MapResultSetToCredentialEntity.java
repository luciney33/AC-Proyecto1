package newspaperoot.dao.jdbc.mappers;

import newspaperoot.common.Configuration;
import newspaperoot.dao.model.CredentialEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapResultSetToCredentialEntity {
    public CredentialEntity mapRS(ResultSet rs) throws SQLException {
        return new CredentialEntity(rs.getString("username"),rs.getString("password"),rs.getInt("id_Reader"));
    }
}
