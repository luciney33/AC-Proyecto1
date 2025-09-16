package newspaperoot.ui;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import newspaperoot.domain.model.CredentialDTO;

import java.util.Scanner;

public class mainMenu {
    public static void main(String[] args) {
        //siempre hay que inicializar la clase que se quiera trabajar con ella
        SeContainerInitializer seContainerInitializer = SeContainer.newInstance();
        try (SeContainer container = seContainerInitializer.initialize()){
            CredentialUI credentialUI = container.select(CredentialUI.class).get();

        }
        Scanner sc = new Scanner(System.in);
        CredentialUI credentialUI = new CredentialUI();
        boolean loggedIN = false;
        while(!loggedIN){
            System.out.println("Username");
            String username = sc.nextLine().trim();
            if (username.isEmpty()) continue;

            System.out.println("Password");
            String password = sc.nextLine().trim();
            if (password.isEmpty()) continue;

            loggedIN = "root".equals(username) && "root".equals(password);
            if (!loggedIN) {
                System.out.println("Invalid username");
            }else System.out.println("Valid username");
        }

                int opc = 0;

                do {
                    switch (opc) {
                        case 1: {
                            System.out.println("1. Get all articles");}
                        break;
                        case 2: {
                            System.out.println("2. Add article");}
                        break;
                        case 3: {
                            System.out.println("3. Update article");}
                        break;
                        case 4: {
                            System.out.println("4. Delete article");}
                        break;
                        case 5: {
                            System.out.println("5. Get all Newspapers");}
                        break;
                        case 6: {
                            System.out.println("6. Get all readers");}
                        break;
                        case 7: {
                            System.out.println("7. Get Readers of an Article");}
                        break;
                        case 8: {
                            System.out.println("8. Get reader by id");}
                        break;
                        case 9: {
                            System.out.println("9. Add rating to an Article");}
                        break;
                        case 10: {
                            System.out.println("10. Modify rating of an Article");}
                        break;
                        case 11: {
                            System.out.println("11. Delete rating of an Article");}
                        break;
                        case 12: {
                            System.out.println("12. Get all types");}
                        break;
                        case 13: {
                            System.out.println("13. Exit");}
                        default:
                            System.out.println("Invalid option. Please try again.");
                        break;
                    }
                } while (opc != 13);

    }
}
