package newspaperoot.domain.mappers;

import newspaperoot.dao.model.TypeEntity;
import newspaperoot.domain.model.TypeDTO;

import java.util.ArrayList;
import java.util.List;

public class MapTypeDtoEntity {
    public TypeDTO entityToDto(TypeEntity entity) {
        return new TypeDTO(entity.getId(), entity.getName(), entity.getDescription());
    }
    public List<TypeDTO> entityToDtoList(List<TypeEntity> entities){
        List<TypeDTO> dtos = new ArrayList<TypeDTO>();
        for(TypeEntity entity: entities){
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }
}
