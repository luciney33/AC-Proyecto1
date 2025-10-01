package newspaperoot.domain.Error;

public class AppError extends RuntimeException {
    public AppError(String message) {
        super(message);
    }
}
