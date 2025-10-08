package newspaperoot.dao.jdbc;

import jakarta.inject.Inject;
import newspaperoot.common.DBconnection;
import newspaperoot.dao.ReaderRepository;
import newspaperoot.dao.jdbc.mappers.MapRStoReaderEntity;
import newspaperoot.dao.model.ArticleEntity;
import newspaperoot.dao.model.ReaderEntity;
import newspaperoot.dao.utilities.Queries;
import newspaperoot.domain.Error.AppError;
import newspaperoot.domain.Error.DatabaseError;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcReaderRepository implements ReaderRepository {
    private final DBconnection db;
    private MapRStoReaderEntity mapper;

    @Inject
    public JdbcReaderRepository(DBconnection db, MapRStoReaderEntity mapper) {
        this.db = db;
        this.mapper = mapper;
    }

    @Override
    public List<ReaderEntity> getAll() {
        List<ReaderEntity> readers = new ArrayList<>();
        try (Connection con = db.getConnection();
             Statement smt = con.createStatement()) {
            ResultSet readerRS = smt.executeQuery(Queries.SelectFromReader);
            while (readerRS.next()) {
                readers.add(mapper.mapRS(readerRS));
            }

        } catch (SQLException e) {
            throw new DatabaseError(e.getMessage());
        } catch (Exception e) {
            throw new AppError(e.getMessage());
        }
        return readers;
    }

    @Override
    public ReaderEntity getReaderById(int id) {
        try (Connection con = db.getConnection();
             PreparedStatement ps = con.prepareStatement(Queries.SelectReaderID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new ReaderEntity(
                        rs.getInt("id_reader"),
                        rs.getString("name"),
                        rs.getDate("birth_date").toLocalDate()
                );
            }
        } catch (SQLException e) {
            throw new DatabaseError(e.getMessage());
        } catch (Exception e) {
            throw new AppError(e.getMessage());
        }
        return null;
    }
}
