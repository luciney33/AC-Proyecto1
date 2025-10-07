package newspaperoot.ui;

import jakarta.inject.Inject;
import newspaperoot.domain.Error.DatabaseError;
import newspaperoot.domain.model.NewsPaperDTO;
import newspaperoot.domain.model.ReaderDTO;
import newspaperoot.domain.service.ReaderService;

import java.util.ArrayList;
import java.util.List;

public class ReaderUI {
    private final ReaderService readerService;

    @Inject
    public ReaderUI(ReaderService readerService) {
        this.readerService = readerService;
    }

    public List<ReaderDTO> getReaders() {
        System.out.println("Get all readers");
        List<ReaderDTO> lista = new ArrayList<>();
        try {
            lista = readerService.getAllReaders();
            if (lista.isEmpty()) {
                System.out.println("No readers found.");
            } else {
                for (int i = 0; i < lista.size(); i++) {
                    ReaderDTO reader = lista.get(i);
                    System.out.println("--ID: " + lista.get(i).getId() + " --Name: " + reader.getName());
                }
            }
        } catch (DatabaseError e) {
            System.err.println("Database error during get all readers");
        }
        return lista;
    }
}
