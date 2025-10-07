package newspaperoot.ui;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import newspaperoot.dao.model.TypeEntity;
import newspaperoot.domain.Error.AppError;
import newspaperoot.domain.model.ArticleDTO;
import newspaperoot.domain.model.CredentialDTO;
import newspaperoot.domain.model.TypeDTO;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class mainMenu {
    public static void main(String[] args) {
        //siempre hay que inicializar la clase que se quiera trabajar con ella
        try {
            SeContainerInitializer initializer = SeContainerInitializer.newInstance();
            SeContainer container = initializer.initialize();
            CredentialUI credentialUI = container.select(CredentialUI.class).get();
            ArticleUI articleUI = container.select(ArticleUI.class).get();
            NewspaperUI newspaperUI = container.select(NewspaperUI.class).get();
            ReaderUI readerUI = container.select(ReaderUI.class).get();


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
                System.out.println("13. Add a new reader with credentials");
                System.out.println("14. Delete reader");
                System.out.println("15. Exit");
                System.out.print("Select an option: ");

                String numero = sc.nextLine();
                try {
                    opc = Integer.parseInt(numero);
                } catch (NumberFormatException e) {
                    opc = -1;
                }

                switch (opc) {
                    case 1:
                        articleUI.getArticles();
                        break;
                    case 2:
                        articleUI.saveArticle();
                        break;
                    case 3:
                        articleUI.updateArticle();
                        break;
                    case 4:
                        articleUI.deleteArticle();
                        break;
                    case 5:
                        newspaperUI.getNewspapers();
                        break;
                    case 6:
                        readerUI.getReaders();
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

        } catch (AppError e) {
            System.err.println("Error : " + e.getMessage());
            System.exit(1);
        }
    }
}
