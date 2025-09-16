package newspaperoot.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

//type of article : economia, futbol
@Data
@AllArgsConstructor
public class TypeDTO {
    private int id;
    private String name;
}
