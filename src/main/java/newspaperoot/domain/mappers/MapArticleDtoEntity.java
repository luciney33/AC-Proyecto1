package newspaperoot.domain.mappers;

import newspaperoot.dao.model.ArticleEntity;
import newspaperoot.dao.model.TypeEntity;
import newspaperoot.domain.model.ArticleDTO;
import newspaperoot.domain.model.TypeDTO;

public class MapArticleDtoEntity {
    public ArticleEntity dtoToEntity(ArticleDTO dto) {
        return new ArticleEntity(
                dto.getId(),
                dto.getName(),
                new TypeEntity(dto.getType().getId(), dto.getType().getName()),
                dto.getNpaperId()
        );
    }
}
