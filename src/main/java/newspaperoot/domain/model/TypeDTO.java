package newspaperoot.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

//type of article : economia, futbol
@Data

public class TypeDTO {
    private int id;
    private String name;

    public TypeDTO(int id, String description) {
        this.id = id;
        this.name = description;
    }
}

