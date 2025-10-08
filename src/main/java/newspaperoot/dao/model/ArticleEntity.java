package newspaperoot.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleEntity {
    private int id;
    private String name;
    private int nPaperId;
    private TypeEntity type;

}
