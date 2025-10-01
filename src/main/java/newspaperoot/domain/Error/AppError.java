package newspaperoot.domain.Error;

import newspaperoot.dao.utilities.Constantes;

public class AppError extends RuntimeException {
    public AppError(String message) {
        super(Constantes.APP_ERROR);
    }
}
