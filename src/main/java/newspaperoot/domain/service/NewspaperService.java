package newspaperoot.domain.service;

import jakarta.inject.Inject;
import lombok.Data;
import newspaperoot.dao.NewspaperRepository;
import newspaperoot.dao.model.NewspaperEntity;
import newspaperoot.domain.mappers.MapNewsDtoEntity;
import newspaperoot.domain.model.NewsPaperDTO;

import java.util.ArrayList;
import java.util.List;

@Data
public class NewspaperService {
    private final NewspaperRepository newspaperRepository;
    private final MapNewsDtoEntity mapper;

    @Inject
    public NewspaperService(NewspaperRepository newspaperRepository, MapNewsDtoEntity mapper) {
        this.newspaperRepository = newspaperRepository;
        this.mapper = mapper;
    }

    public List<NewsPaperDTO> getAllNewspapers() {
        List<NewspaperEntity> newspaperEntities = newspaperRepository.getAll();
        return mapper.entityListToDtoList(newspaperEntities);

    }
}
