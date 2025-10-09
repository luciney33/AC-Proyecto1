package newspaperoot.dao.jdbc;

import jakarta.inject.Inject;
import lombok.Data;
import newspaperoot.common.DBconnection;
import newspaperoot.dao.ReaderActivityRepository;
import newspaperoot.dao.jdbc.mappers.MapRStoReadActEntity;
import newspaperoot.dao.model.ReadActivityEntity;
import newspaperoot.dao.utilities.Constantes;
import newspaperoot.dao.utilities.Queries;
import newspaperoot.domain.Error.AppError;
import newspaperoot.domain.Error.DatabaseError;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Data
public class JdbcReadActRepository implements ReaderActivityRepository {
    private final DBconnection db;
    private final MapRStoReadActEntity mapper;

    @Inject
    public JdbcReadActRepository(DBconnection db, MapRStoReadActEntity mapper) {
        this.db = db;
        this.mapper = mapper;
    }

    @Override
    public List<ReadActivityEntity> getReadersArticle(int idArticle) {
        List<ReadActivityEntity> readers = new ArrayList<>();
        try (Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement(Queries.SelectReaderACT)) {
            ps.setInt(1, idArticle);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                readers.add(mapper.mapRS(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return readers;
    }

    @Override
    public int addRating(ReadActivityEntity readActivityEntity) {
        try (Connection con = db.getConnection();
             PreparedStatement ps = con.prepareStatement(Queries.SelectAddRating)) {
            ps.setInt(1,readActivityEntity.getRating());
            ps.setInt(2,readActivityEntity.getId());
            ps.setInt(3,readActivityEntity.getIdArticle());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) { // No se ha actualizao nada
                throw new DatabaseError(Constantes.DB_ERROR2 + readActivityEntity.getId());
            }

        }catch (SQLException e) {
            throw new DatabaseError(e.getMessage());
        }catch (Exception e) {
            throw new AppError(e.getMessage());
        }
        return 0;
    }

}
