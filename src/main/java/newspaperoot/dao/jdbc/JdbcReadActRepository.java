package newspaperoot.dao.jdbc;

import jakarta.inject.Inject;
import lombok.Data;
import newspaperoot.common.DBconnection;
import newspaperoot.dao.ReaderActivityRepository;
import newspaperoot.dao.jdbc.mappers.MapRStoReadActEntity;
import newspaperoot.dao.model.ReadActivityEntity;
import newspaperoot.dao.utilities.Queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}
