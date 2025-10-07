package newspaperoot.domain.mappers;

import newspaperoot.dao.model.ReadActivityEntity;
import newspaperoot.domain.model.ReadActivityDTO;

import java.util.ArrayList;
import java.util.List;

public class MapReadActDtoEntity {
    public ReadActivityDTO entityToDto(ReadActivityEntity entity) {
        return new ReadActivityDTO(entity.getId(), entity.getIdArticle(),entity.getNameReader(), entity.getFechanac(), entity.getSubscriptionsReader(), entity.getRating());
    }
    public List<ReadActivityDTO> entityListToDtoList(List<ReadActivityEntity> entities) {
        List<ReadActivityDTO> dtos = new ArrayList<>();
        for (ReadActivityEntity entity : entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }

}
