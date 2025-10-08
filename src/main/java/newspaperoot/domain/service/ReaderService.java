package newspaperoot.domain.service;

import jakarta.inject.Inject;
import lombok.Data;
import newspaperoot.dao.ReaderRepository;
import newspaperoot.dao.model.ReaderEntity;
import newspaperoot.domain.mappers.MapReaderDtoEntity;
import newspaperoot.domain.model.ReaderDTO;

import java.util.List;
@Data
public class ReaderService {
    private final ReaderRepository readerRepository;
    private final MapReaderDtoEntity mapper;

    @Inject
    public ReaderService(ReaderRepository readerRepository, MapReaderDtoEntity mapper) {
        this.readerRepository = readerRepository;
        this.mapper = mapper;
    }

    public List<ReaderDTO> getAllReaders() {
        List<ReaderEntity> readerEntities = readerRepository.getAll();
        return mapper.entityListToDtoList(readerEntities);

    }

    public ReaderDTO getReaderById(int id) {
        ReaderEntity reader = readerRepository.getReaderById(id);
        return mapper.entityToDto(reader);
    }
}
