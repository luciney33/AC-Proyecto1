package newspaperoot.dao.jdbc;

import jakarta.inject.Inject;
import lombok.Data;
import newspaperoot.common.Configuration;
import newspaperoot.dao.ArticleRepository;
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
    private final Configuration conf;
    private final MapRStoNewspaperEntity mapper;

    @Inject
    public JdbcNewspaperRepository(Configuration conf, MapRStoNewspaperEntity mapRStoNewspaperEntity) {
        this.conf = conf;
        mapper = mapRStoNewspaperEntity;
    }

    public Connection getConnection() throws SQLException {
        Connection myConnection = DriverManager.getConnection(conf.getProperty("url"), conf.getProperty("username"), conf.getProperty("password"));
        return myConnection;
    }

    @Override
    public List<NewspaperEntity> getAll() {
        List<NewspaperEntity> newspapers = new ArrayList<>();
        try (Connection con = getConnection();
             Statement smt = con.createStatement()){
            ResultSet newpaperRS = smt.executeQuery(Queries.SelectFromNews);
            if (!newpaperRS.isBeforeFirst()) {
                System.out.println("No hay periodicos en la BD");
            }
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
