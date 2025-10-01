package newspaperoot.dao.jdbc;

import jakarta.inject.Inject;
import lombok.Data;
import newspaperoot.common.Configuration;
import newspaperoot.dao.CredentialRepository;
import newspaperoot.dao.jdbc.mappers.MapResultSetToCredentialEntity;
import newspaperoot.dao.model.CredentialEntity;
import newspaperoot.dao.utilities.Queries;
import newspaperoot.domain.Error.AppError;
import newspaperoot.domain.Error.DatabaseError;

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
        Connection myConnection = DriverManager.getConnection(conf.getProperty("urlDB"),conf.getProperty("user_name"),conf.getProperty("password"));
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
        return credentialE;
    }

    @Override
    public CredentialEntity get(String username) {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(Queries.SelectGetCrede)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new CredentialEntity(rs.getString("username"), rs.getString("password"), rs.getInt("id_reader"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DatabaseError(e.getMessage());
        }catch (Exception e) {
            throw new AppError(e.getMessage());
        }
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
