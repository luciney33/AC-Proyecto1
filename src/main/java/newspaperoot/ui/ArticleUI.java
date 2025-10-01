package newspaperoot.ui;

import jakarta.inject.Inject;
import lombok.AllArgsConstructor;
import lombok.Data;
import newspaperoot.dao.model.ArticleEntity;
import newspaperoot.dao.model.TypeEntity;
import newspaperoot.domain.Error.AppError;
import newspaperoot.domain.Error.DatabaseError;
import newspaperoot.domain.model.ArticleDTO;
import newspaperoot.domain.service.ArticleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Data
public class ArticleUI {
    private final ArticleService articleService;

    Scanner sc = new Scanner(System.in);
    @Inject
    public ArticleUI(ArticleService articleService) {
        this.articleService = articleService;
    }

    public List<ArticleDTO> getArticles() {
        List<ArticleDTO> lista = new ArrayList<>();
        try {
            lista=articleService.getAllArticles();
            if (lista.isEmpty()) {
                System.out.println("No articles found.");
            } else {
                for (int i = 0; i < lista.size(); i++) {
                    ArticleDTO art = lista.get(i);
                    String typeDesc = (art.getType() != null) ? art.getType().getName() : "No Type";
                    System.out.println("--ID: " + lista.get(i).getId()+ " --Name: " + art.getName() + " --Type: " + typeDesc +
                            " --Newspaper ID: " + art.getNpaperId());
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

    public ArticleDTO saveArticle(ArticleDTO articleDTO) {
        System.out.println("Add article");
        System.out.println("Enter id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Enter title: ");
        String title = sc.nextLine();
        System.out.println("Enter type id: ");
        int typeId = Integer.parseInt(sc.nextLine());
        System.out.println("Enter type name: ");
        String typeName = sc.nextLine();
        System.out.println("Enter rating: ");
        int rating = Integer.parseInt(sc.nextLine());

        ArticleDTO article = articleService.saveArticle(articleDTO);

        return article;
    }

    public ArticleDTO deleteArticle(ArticleDTO articleDTO) {
        return articleService.deleteArticle(articleDTO);
    }

    public ArticleDTO updateArticle(ArticleDTO articleDTO) {
        return articleService.updateArticle(articleDTO);
    }

}
