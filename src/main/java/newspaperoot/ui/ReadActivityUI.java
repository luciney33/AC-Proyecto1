package newspaperoot.ui;

import jakarta.inject.Inject;
import newspaperoot.dao.ReaderActivityRepository;
import newspaperoot.domain.model.ReadActivityDTO;
import newspaperoot.domain.service.ReadActivityService;

import java.util.ArrayList;
import java.util.List;

public class ReadActivityUI {
    private final ReadActivityService readActivityService;
    @Inject
    public ReadActivityUI(ReadActivityService readActivityService) {
        this.readActivityService = readActivityService;
    }

    public List<ReadActivityDTO> getReaderOfArticle(){
        System.out.println("Get readers of an article");
        List<ReadActivityDTO> lista = new ArrayList<>();
        int id=0;
        boolean exists = false;
        do {
            System.out.println("Put the id of the article");
            s
        }while(!exists);

        return
    }
}
