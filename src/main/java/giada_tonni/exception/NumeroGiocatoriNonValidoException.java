package giada_tonni.exception;

public class NumeroGiocatoriNonValidoException extends RuntimeException {
    public NumeroGiocatoriNonValidoException() {
        super("Il numero dei giocatori deve essere compreso tra il 2 e il 10");
    }
}
