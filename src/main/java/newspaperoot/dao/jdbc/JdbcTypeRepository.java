package newspaperoot.dao.jdbc;

import jakarta.inject.Inject;
import lombok.Data;
import newspaperoot.common.DBconnection;
import newspaperoot.dao.TypeRepository;
import newspaperoot.dao.jdbc.mappers.MapRStoTypeEntity;
import newspaperoot.dao.model.TypeEntity;
import newspaperoot.dao.utilities.Queries;
import newspaperoot.domain.Error.AppError;
import newspaperoot.domain.Error.DatabaseError;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Data
public class JdbcTypeRepository implements TypeRepository {
    private final DBconnection db;
    private final MapRStoTypeEntity mapper;

    @Inject
    public JdbcTypeRepository(DBconnection db, MapRStoTypeEntity mapper) {
        this.db = db;
        this.mapper = mapper;
    }

    @Override
    public List<TypeEntity> getAllTypes() {
        List<TypeEntity> types = new ArrayList<>();
        try (Connection con = db.getConnection();
             Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery(Queries.SelectFromType);
            while (rs.next()) {
                types.add(mapper.mapRS(rs));
            }

        }catch (SQLException e) {
            throw new DatabaseError(e.getMessage());
        }catch (Exception e) {
            throw new AppError(e.getMessage());
        }
        return types;
    }
}
