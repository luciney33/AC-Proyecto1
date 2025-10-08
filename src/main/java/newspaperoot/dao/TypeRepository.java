package newspaperoot.dao;

import newspaperoot.dao.model.TypeEntity;

import java.util.List;

public interface TypeRepository {
    List<TypeEntity> getAllTypes();
}
