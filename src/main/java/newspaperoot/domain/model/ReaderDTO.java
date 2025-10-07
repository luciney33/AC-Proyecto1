package newspaperoot.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class ReaderDTO {
    private int idReader;
    private String nameReader;
    private LocalDate birthday;
}
