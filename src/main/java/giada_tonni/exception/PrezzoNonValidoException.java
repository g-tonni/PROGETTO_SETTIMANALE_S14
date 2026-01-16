package giada_tonni.exception;

public class PrezzoNonValidoException extends RuntimeException {
    public PrezzoNonValidoException() {
        super("Il prezzo deve essere superiore allo 0");
    }
}
