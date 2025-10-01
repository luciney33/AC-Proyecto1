package newspaperoot.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import newspaperoot.dao.model.TypeEntity;

@Data
@AllArgsConstructor
public class ArticleDTO {
    private int id;
    private String name;
    private TypeDTO type;
    private int npaperId;
    private double avgRating;

    public ArticleDTO(int id, String name, TypeEntity typeEntity, int nPaperId) {
        this.id = id;
        this.name = name;
        this.type = new TypeDTO(typeEntity.getId(), typeEntity.getDescription());
        this.npaperId = nPaperId;
    }

}
