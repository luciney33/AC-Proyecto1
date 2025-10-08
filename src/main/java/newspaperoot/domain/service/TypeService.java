package newspaperoot.domain.service;

import jakarta.inject.Inject;
import lombok.Data;
import newspaperoot.dao.TypeRepository;
import newspaperoot.dao.model.TypeEntity;
import newspaperoot.domain.mappers.MapTypeDtoEntity;
import newspaperoot.domain.model.TypeDTO;

import java.util.ArrayList;
import java.util.List;

@Data
public class TypeService {
    private final TypeRepository typeRepository;
    private final MapTypeDtoEntity mapper;

    @Inject
    public TypeService(TypeRepository typeRepository, MapTypeDtoEntity mapper) {
        this.typeRepository = typeRepository;
        this.mapper = mapper;
    }

    public List<TypeDTO> getAllTypes() {
        List<TypeEntity> typeEntities = typeRepository.getAllTypes();
        return mapper.entityToDtoList(typeEntities);
    }
}
