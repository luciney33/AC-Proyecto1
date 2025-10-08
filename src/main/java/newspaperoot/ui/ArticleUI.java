package newspaperoot.ui;

import jakarta.inject.Inject;
import lombok.AllArgsConstructor;
import lombok.Data;
import newspaperoot.dao.model.ArticleEntity;
import newspaperoot.dao.model.TypeEntity;
import newspaperoot.domain.Error.AppError;
import newspaperoot.domain.Error.DatabaseError;
import newspaperoot.domain.model.ArticleDTO;
import newspaperoot.domain.model.NewsPaperDTO;
import newspaperoot.domain.model.TypeDTO;
import newspaperoot.domain.service.ArticleService;
import newspaperoot.domain.service.TypeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Data
public class ArticleUI {
    Scanner sc = new Scanner(System.in);
    private final ArticleService articleService;
    private final TypeUI typeUI;
    private final NewspaperUI newspaperUI;

    @Inject
    public ArticleUI(ArticleService articleService, TypeUI typeUI, NewspaperUI newspaperUI) {
        this.newspaperUI = newspaperUI;
        this.typeUI = typeUI;
        this.articleService = articleService;
    }

    public List<ArticleDTO> getArticles() {
        System.out.println("Get all articles");
        List<ArticleDTO> lista = new ArrayList<>();
        try {
            lista=articleService.getAllArticles();
            if (lista.isEmpty()) {
                System.out.println("No articles found.");
            } else {
                for (int i = 0; i < lista.size(); i++) {
                    ArticleDTO art = lista.get(i);
                    String typeDesc = (art.getType() != null) ? art.getType().getName() : "No Type";
                    System.out.println(" ID: " + lista.get(i).getId()+ " --Name: " + art.getName() + " --Type: " + typeDesc +
                            " --Newspaper ID: " + art.getNPaperId());
                }
            }
        }catch (DatabaseError e) {
            System.err.println("Database error during get all articles");
        }
        return lista;
    }

    public ArticleDTO getArticleById(int id) {
        return articleService.getArticleById(id);
    }

    public ArticleDTO saveArticle() {
        System.out.println("Add article");
        System.out.println("Enter name: ");
        String name = sc.nextLine();

        System.out.println("Choose newspaper for the article");
        List<NewsPaperDTO> newspapers = newspaperUI.getNewspapers();
        int newspaperId;
        NewsPaperDTO selNews;
        do {
            System.out.print("Enter newpaper id: ");
            newspaperId = Integer.parseInt(sc.nextLine());
            int finalId = newspaperId;
            selNews = newspapers.stream()
                    .filter(t -> t.getId() == finalId)
                    .findFirst()
                    .orElse(null);
            if (selNews == null) {
                System.out.println("Invalid type id. Try again");
            }
        } while (selNews == null);

        System.out.println("Choose type for the article");
        List<TypeDTO> types = typeUI.getAllTypes();
        int typeId;
        TypeDTO selType;
        do {
            System.out.print("Enter type id: ");
            typeId = Integer.parseInt(sc.nextLine());
            int finalId = typeId;
            selType = types.stream()
                    .filter(t -> t.getId() == finalId)
                    .findFirst()
                    .orElse(null);
            if (selType == null) {
                System.out.println("Invalid type id. Try again");
            }
        } while (selType == null);

        ArticleDTO newA = new ArticleDTO(0,name, newspaperId, new TypeDTO(typeId,null,null));
        return articleService.saveArticle(newA);
    }

    public ArticleDTO deleteArticle() {
        List<ArticleDTO> lista = articleService.getAllArticles();
        if (lista.isEmpty()) {
            System.out.println("No articles to delete");
            return null;
        }
        int id=-1;
        boolean exists = false;
        do {
            System.out.println("Put the id of the article you want to delete: ");
            try {
                id = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid article ID");
            }
            int finalId = id;
            exists = lista.stream().anyMatch(article -> article.getId() == finalId);
            if (!exists) {
                System.out.println("Article with ID " + id + " does not exist. Please try again");
            }
        }while (!exists);
        ArticleDTO articleDTO = new ArticleDTO(id, "", 0, null);
        return articleService.deleteArticle(articleDTO);
    }

    public ArticleDTO updateArticle() {
        List<ArticleDTO> lista = articleService.getAllArticles();
        ArticleDTO articleDTO;
        if (lista.isEmpty()) {
            System.out.println("No articles to update");
            return null;
        }
        int id=-1;
        boolean exists = false;
        do {
            System.out.println("Put the id of the article you want to update: ");
            try {
                id = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid article ID");
            }
            int finalId = id;
            exists = lista.stream().anyMatch(article -> article.getId() == finalId);
            if (!exists) {
                System.out.println("Article with ID " + id + " does not exist. Please try again");
            }
            articleDTO = lista.stream().filter(article -> article.getId() == finalId).findFirst().orElse(null);
        }while (!exists);

        System.out.println("Enter new name: ");
        String newName = sc.nextLine();
        return articleService.updateArticle(articleDTO, newName);

    }

}
