package newspaperoot.ui;

import jakarta.inject.Inject;
import lombok.Data;
import newspaperoot.domain.Error.DatabaseError;
import newspaperoot.domain.model.ArticleDTO;
import newspaperoot.domain.model.NewsPaperDTO;
import newspaperoot.domain.service.NewspaperService;

import java.util.ArrayList;
import java.util.List;

@Data
public class NewspaperUI {
    private final NewspaperService newspaperService;

    @Inject
    public NewspaperUI(NewspaperService newspaperService) {
        this.newspaperService = newspaperService;
    }

    public List<NewsPaperDTO> getNewspapers() {
        System.out.println("Get all newspapers");
        List<NewsPaperDTO> lista = new ArrayList<>();
        try {
            lista = newspaperService.getAllNewspapers();
            if (lista.isEmpty()) {
                System.out.println("No newspaper found.");
            } else {
                for (int i = 0; i < lista.size(); i++) {
                    NewsPaperDTO news = lista.get(i);
                    System.out.println("--ID: " + lista.get(i).getId() + " --Name: " + news.getName() + " --Date: " + news.getDate());
                }
            }
        } catch (DatabaseError e) {
            System.err.println("Database error during get all newspapers.");
        }
        return lista;
    }
}
