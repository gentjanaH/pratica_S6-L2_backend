package gentjanahani.u2w6d2.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("id non trovato.");
    }
}
