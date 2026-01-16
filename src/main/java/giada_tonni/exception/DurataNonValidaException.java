package giada_tonni.exception;

public class DurataNonValidaException extends RuntimeException {
    public DurataNonValidaException() {
        super("La durata deve essere superiore allo 0");
    }
}
