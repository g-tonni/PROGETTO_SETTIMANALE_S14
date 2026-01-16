package giada_tonni.exception;

public class NumeroGiocatoriNonValidoException extends RuntimeException {
    public NumeroGiocatoriNonValidoException() {
        super("Il numero dei giocatori deve essere compreso tra lo 0 e il 2");
    }
}
