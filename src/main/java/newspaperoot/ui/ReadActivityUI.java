package newspaperoot.ui;

import jakarta.inject.Inject;
import newspaperoot.dao.ReaderActivityRepository;
import newspaperoot.domain.model.ReadActivityDTO;
import newspaperoot.domain.service.ReadActivityService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadActivityUI {
    Scanner sc = new Scanner(System.in);

    private final ReadActivityService readActivityService;

    @Inject
    public ReadActivityUI(ReadActivityService readActivityService) {
        this.readActivityService = readActivityService;
    }

    public void getReaderOfArticle() {
        System.out.println("7. Get readers of an article");
        System.out.print("Enter the ID of the article: ");

        int idArticle = 0;
        try {
            idArticle = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
        int finalIdArticle = idArticle;
        List<ReadActivityDTO> readers = readActivityService.getReadersOfArticle(finalIdArticle);

        if (readers.isEmpty()) {
            System.out.println("No readers found for article ID: " + idArticle);
        } else {
            System.out.println("Readers for article ID " + idArticle + ":");
            for (ReadActivityDTO r : readers) {
                System.out.println("- Name: " + r.getNameReader() +
                        " | Fecha de nacimiento: " + r.getFechanac() +
                        " | Subscriptions: " + r.getSubscriptionsReader() +
                        " | Rating: " + r.getRating());
            }
        }
    }
}
