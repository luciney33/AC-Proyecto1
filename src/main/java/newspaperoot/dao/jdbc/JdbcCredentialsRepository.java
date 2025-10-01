package newspaperoot.dao.jdbc;

import jakarta.inject.Inject;
import lombok.Data;
import newspaperoot.common.Configuration;
import newspaperoot.dao.CredentialRepository;
import newspaperoot.dao.jdbc.mappers.MapResultSetToCredentialEntity;
import newspaperoot.dao.model.CredentialEntity;
import newspaperoot.dao.utilities.Queries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Data
public class JdbcCredentialsRepository  implements  CredentialRepository {
    private Configuration conf;
    private MapResultSetToCredentialEntity mapper;


    @Inject
    public JdbcCredentialsRepository(Configuration conf, MapResultSetToCredentialEntity mapper) {
        this.conf = conf;
        this.mapper = new MapResultSetToCredentialEntity();
    }

    public Connection getConnection() throws SQLException {
        Connection myConnection = DriverManager.getConnection(conf.getProperty("url"),conf.getProperty("username"),conf.getProperty("password"));
        return myConnection;
    }

    @Override
    public List<CredentialEntity> getAll() {
        List<CredentialEntity> credentialE = new ArrayList<>();
        try (Connection con = getConnection();
             Statement stmt = con.createStatement();){
            ResultSet rs = stmt.executeQuery(Queries.SelectFromCrede);
            while (rs.next()) {
                List<CredentialEntity> credential = mapper.mapRS(rs);
                credentialE.addAll(credential);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return List.of();
    }

    @Override
    public CredentialEntity get(String username) {
        return null;
    }

    @Override
    public int save(CredentialEntity credential) {
        return 0;
    }

    @Override
    public void delete(CredentialEntity credential) {

    }

    @Override
    public void update(CredentialEntity credential) {

    }
}
