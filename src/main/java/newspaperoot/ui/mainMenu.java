package newspaperoot.ui;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import newspaperoot.dao.Basic.BasicArticleRepository;
import newspaperoot.dao.model.ArticleEntity;
import newspaperoot.dao.model.TypeEntity;
import newspaperoot.domain.model.CredentialDTO;

import java.util.Scanner;

public class mainMenu {
    public static void main(String[] args) {
        //siempre hay que inicializar la clase que se quiera trabajar con ella
        try {
            SeContainerInitializer initializer = SeContainerInitializer.newInstance();
            SeContainer container = initializer.initialize();
            CredentialUI credentialUI = container.select(CredentialUI.class).get();
            ArticleUI articleUI = container.select(ArticleUI.class).get();

            Scanner sc = new Scanner(System.in);
            boolean loggedIN = false;
            while (!loggedIN) {
                System.out.println("Username");
                String username = sc.nextLine().trim();
                if (username.isEmpty()) continue;

                System.out.println("Password");
                String password = sc.nextLine().trim();
                if (password.isEmpty()) continue;

                loggedIN = credentialUI.checkLogin(new CredentialDTO(username, password));
                if (!loggedIN) {
                    System.out.println("Invalid username");
                } else System.out.println("Valid username");
            }
            int opc = 0;
            //sacalo que tu puedes
            do {
                System.out.println("1. Get all articles");
                System.out.println("2. Add article");
                System.out.println("3. Update article");
                System.out.println("4. Delete article");
                System.out.println("5. Get all newspapers");
                System.out.println("6. Get all readers");
                System.out.println("7. Get readers of an article");
                System.out.println("8. Get reader by id");
                System.out.println("9. Add rating to an article");
                System.out.println("10. Modify rating of an article");
                System.out.println("11. Delete rating of an article");
                System.out.println("12. Get all types");
                System.out.println("13. Exit");
                System.out.print("Select an option: ");

                String numero = sc.nextLine();
                try {
                    opc = Integer.parseInt(numero);
                } catch (NumberFormatException e) {
                    opc = -1;
                }

                switch (opc) {
                    case 1:
                        System.out.println("Get all articles");
                        articleUI.getArticles();
                        break;
                    case 2:
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
                        ArticleEntity newA = new ArticleEntity(id, title, new TypeEntity(typeId, typeName), rating);
                        articleUI.getArticleService().getArticleRepository().save(newA);
                        break;
                    case 3:
                        System.out.println("Put the id of the article you want to delete: ");
                        int id2 = Integer.parseInt(sc.nextLine());
                        ArticleEntity article = articleUI.getArticleService().getArticleRepository().get(id2);
                        articleUI.getArticleService().getArticleRepository().delete(article);
                        break;
                    case 4:
                        System.out.println("Put the id of the article you want to update: ");
                        int id3 = Integer.parseInt(sc.nextLine());
                        ArticleEntity article2 = articleUI.getArticleService().getArticleRepository().get(id3);
                        articleUI.getArticleService().getArticleRepository().update(article2);
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                    case 11:
                        break;
                    case 12:
                        break;
                    case 13:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }

            } while (opc != 13);

        } catch (Exception e) {
            System.err.println("Error : " + e.getMessage());
            System.exit(1);
        }
    }
}
