package newspaperoot.dao;

import newspaperoot.dao.model.NewspaperEntity;

import java.util.List;

public interface NewspaperRepository {
    List<NewspaperEntity> getAll();
}
