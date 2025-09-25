package newspaperoot.domain.mappers;

import newspaperoot.dao.model.ArticleEntity;
import newspaperoot.dao.model.TypeEntity;
import newspaperoot.domain.model.ArticleDTO;

public class MapDtoEntity {
    public ArticleEntity dtoToEntity(ArticleDTO dto) {
        return new ArticleEntity(
                dto.getId(),
                dto.getName(),
                new TypeEntity(dto.getType().getId(), dto.getType().getName()),
                dto.getNpaperId()
        );
    }
}
