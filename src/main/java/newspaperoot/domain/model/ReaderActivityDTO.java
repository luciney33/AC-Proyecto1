package newspaperoot.domain.model;

import java.time.LocalDate;
import java.util.List;

public class ReaderActivityDTO {
    private int idArticle;
    private int idReader;
    private String nameReader;
    private LocalDate dobReader;
    private List<String> subscriptionsReader;
    private int rating;
}
