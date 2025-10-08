package newspaperoot.dao;
import newspaperoot.dao.model.ReaderEntity;
import java.util.List;

public interface ReaderRepository {
    List<ReaderEntity> getAll();
    ReaderEntity getReaderById(int id);

}
