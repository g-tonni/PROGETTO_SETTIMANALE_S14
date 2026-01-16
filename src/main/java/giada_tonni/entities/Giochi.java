package giada_tonni.entities;

import giada_tonni.exception.IdNonValidoException;
import giada_tonni.exception.PrezzoNonValidoException;

public abstract class Giochi {
    private int id;
    private String titolo;
    private String annoPubblicazione;
    private double prezzo;

    public Giochi (int id, String titolo, String annoPubblicazione, double prezzo){
        try {
           if(id < 0 || id > 2000) throw new IdNonValidoException("Il codice ID deve essere compreso tra 0 e 2000");
           this.id = id;
        } catch (IdNonValidoException ex){
            System.out.println(ex.getMessage());
        }
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        try {
            if(prezzo <= 0.0) throw new PrezzoNonValidoException("Il prezzo deve essere superiore allo 0");
            this.prezzo = prezzo;
        } catch (PrezzoNonValidoException ex) {
            System.out.println(ex.getMessage());
        }
        this.ciao = 

    }
}
