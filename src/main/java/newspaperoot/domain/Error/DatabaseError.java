package newspaperoot.domain.Error;

import newspaperoot.dao.utilities.Constantes;

public class DatabaseError extends RuntimeException {
    public DatabaseError(String message) {
        super(Constantes.DB_ERROR);
    }
}
