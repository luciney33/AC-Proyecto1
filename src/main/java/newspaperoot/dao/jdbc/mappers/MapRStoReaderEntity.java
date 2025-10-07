package newspaperoot.dao.jdbc.mappers;

import newspaperoot.dao.model.NewspaperEntity;
import newspaperoot.dao.model.ReaderEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MapRStoReaderEntity {
    public ReaderEntity mapRS(ResultSet rs) throws SQLException {
        return new ReaderEntity(
                rs.getInt("id_reader"),rs.getString("name"), rs.getDate("birth_date").toLocalDate());
    }
}
