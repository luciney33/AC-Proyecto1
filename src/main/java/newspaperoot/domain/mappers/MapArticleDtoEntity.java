package newspaperoot.domain.mappers;

import newspaperoot.dao.model.ArticleEntity;
import newspaperoot.dao.model.TypeEntity;
import newspaperoot.domain.model.ArticleDTO;
import newspaperoot.domain.model.TypeDTO;

import java.util.ArrayList;
import java.util.List;

public class MapArticleDtoEntity {
    public ArticleEntity dtoToEntity(ArticleDTO dto) {
        return new ArticleEntity(
                dto.getId(),
                dto.getName(),
                dto.getNPaperId(),
        new TypeEntity(dto.getType().getId(), dto.getType().getName(), dto.getType().getDescription())
        );
    }

    public ArticleDTO entityToDto(ArticleEntity entity) {
        return new ArticleDTO(
                entity.getId(),
                entity.getName(),
                entity.getNPaperId(),
                new TypeDTO(entity.getType().getId(), entity.getType().getName(), entity.getType().getDescription())
        );
    }

    public List<ArticleDTO> entityToDtoList(List<ArticleEntity> entities) {
        List<ArticleDTO> dtos = new ArrayList<>();
        for (ArticleEntity entity : entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }
}
