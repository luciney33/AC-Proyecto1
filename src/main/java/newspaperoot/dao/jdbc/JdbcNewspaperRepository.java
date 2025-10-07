package newspaperoot.dao.jdbc;
import jakarta.inject.Inject;
import lombok.Data;
import newspaperoot.common.DBconnection;
import newspaperoot.dao.NewspaperRepository;
import newspaperoot.dao.jdbc.mappers.MapRStoNewspaperEntity;
import newspaperoot.dao.model.NewspaperEntity;
import newspaperoot.dao.utilities.Queries;
import newspaperoot.domain.Error.AppError;
import newspaperoot.domain.Error.DatabaseError;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Data
public class JdbcNewspaperRepository implements NewspaperRepository {
    private final DBconnection db;
    private final MapRStoNewspaperEntity mapper;

    @Inject
    public JdbcNewspaperRepository(DBconnection db, MapRStoNewspaperEntity mapRStoNewspaperEntity) {
        this.db = db;
        mapper = mapRStoNewspaperEntity;
    }


    @Override
    public List<NewspaperEntity> getAll() {
        List<NewspaperEntity> newspapers = new ArrayList<>();
        try (Connection con = db.getConnection();
             Statement smt = con.createStatement()){
            ResultSet newpaperRS = smt.executeQuery(Queries.SelectFromNews);
            while (newpaperRS.next()) {
                newspapers.add(mapper.mapRS(newpaperRS));
            }
        } catch (SQLException e) {
            throw new DatabaseError(e.getMessage());
        }catch (Exception e) {
            throw new AppError(e.getMessage());
        }
        return newspapers;
    }
}
