package newspaperoot.domain.mappers;
import newspaperoot.dao.model.ReaderEntity;
import newspaperoot.domain.model.ReaderDTO;

import java.util.ArrayList;
import java.util.List;

public class MapReaderDtoEntity {
    public ReaderDTO entityToDto(ReaderEntity entity) {
        return new ReaderDTO(entity.getId(), entity.getName(),entity.getBirthday());
    }
    public List<ReaderDTO> entityListToDtoList(List<ReaderEntity> entities) {
        List<ReaderDTO> dtos = new ArrayList<>();
        for (ReaderEntity entity : entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }
}
