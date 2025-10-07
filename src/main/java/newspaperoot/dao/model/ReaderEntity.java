package newspaperoot.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ReaderEntity {
    private int id;
    private String name;
    private LocalDate birthday;
}
