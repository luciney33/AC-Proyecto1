package newspaperoot.domain.service;

import jakarta.inject.Inject;
import newspaperoot.dao.ReaderActivityRepository;
import newspaperoot.dao.model.ReadActivityEntity;
import newspaperoot.domain.mappers.MapReadActDtoEntity;
import newspaperoot.domain.model.ReadActivityDTO;

import java.util.List;

public class ReadActivityService {
    private final ReaderActivityRepository rActRepository;
    private final MapReadActDtoEntity mapper;

    @Inject
    public ReadActivityService(ReaderActivityRepository rActRepository, MapReadActDtoEntity mapper) {
        this.rActRepository = rActRepository;
        this.mapper = mapper;
    }

    public List<ReadActivityDTO> getReadersOfArticle(int idArticle) {
        List<ReadActivityEntity> entities = rActRepository.getReadersArticle(idArticle);
        return mapper.entityListToDtoList(entities);
    }
}
