package newspaperoot.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class ReadActivityEntity {
    private int id;
    private int idArticle;
    private String nameReader;
    private LocalDate fechanac;
    private List<String> subscriptionsReader;
    private int rating;

}
