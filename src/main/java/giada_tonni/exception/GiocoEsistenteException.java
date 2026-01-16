package giada_tonni.exception;

public class GiocoEsistenteException extends RuntimeException {
    public GiocoEsistenteException() {
        super("Il gioco esiste già nella collezione");
    }
}
