package newspaperoot.ui;

import newspaperoot.domain.model.CredentialDTO;

import java.util.Scanner;

public class mainMenu {
    public static void main(String[] args) {
        //siempre hay que inicializar la clase que se quiera
        SeContainerInitializer seContainerInitializer = SeContaiener.newInstance();
        try (SeContainer container = initializer.initialize()){
            CredentialUI credentialUI = container.select(CredentialUI.class).get();

        }
        Scanner sc = new Scanner(System.in);
        CredentialUI credentialUI = new CredentialUI();
            System.out.println("Username");
            String username = sc.nextLine();
            System.out.println("Password");
            String password = sc.nextLine();
            if (username.equals("root") && password.equals("root")) {
                System.out.println("Login successful. Welcome " + username + "!");
                System.out.println("Elije una opcion:");
                int opc = sc.nextInt();

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
            } else {
                System.out.println("Login failed. Incorrect username or password.");
            }

        sc.close();


    }
}
