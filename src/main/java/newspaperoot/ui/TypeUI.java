package newspaperoot.ui;

import jakarta.inject.Inject;
import lombok.Data;
import newspaperoot.domain.Error.DatabaseError;
import newspaperoot.domain.model.NewsPaperDTO;
import newspaperoot.domain.model.TypeDTO;
import newspaperoot.domain.service.TypeService;

import java.util.ArrayList;
import java.util.List;

@Data
public class TypeUI {
    private final TypeService typeService;

    @Inject
    public TypeUI(TypeService typeService) {
        this.typeService = typeService;
    }

    public List<TypeDTO> getAllTypes() {
        System.out.println("Get all types");
        List<TypeDTO> lista = new ArrayList<>();
        try {
            lista = typeService.getAllTypes();
            if (lista.isEmpty()) {
                System.out.println("No types found.");
            } else {
                for (int i = 0; i < lista.size(); i++) {
                    TypeDTO types = lista.get(i);
                    System.out.println("--ID: " + lista.get(i).getId() + " --Name: " + types.getName() + " --Description: " + types.getDescription());
                }
            }
        } catch (DatabaseError e) {
            System.err.println("Database error during get all types");
        }
        return lista;
    }
}
