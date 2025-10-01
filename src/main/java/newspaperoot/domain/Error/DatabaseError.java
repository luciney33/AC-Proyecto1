package newspaperoot.domain.Error;

public class DatabaseError extends RuntimeException {
    public DatabaseError(String message) {
        super(message);
    }
}
