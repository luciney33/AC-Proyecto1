package newspaperoot.dao;

import newspaperoot.dao.model.ReadActivityEntity;

import java.util.List;

public interface ReaderActivityRepository {
    List<ReadActivityEntity> getReadersArticle(int idArticle);
    int addRating(ReadActivityEntity readActivityEntity);
}
