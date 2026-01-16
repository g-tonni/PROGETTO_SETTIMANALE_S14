package giada_tonni.entities;

import giada_tonni.exception.IdNonValidoException;
import giada_tonni.exception.PrezzoNonValidoException;

import java.util.Objects;

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
            if(prezzo <= 0.0) throw new PrezzoNonValidoException();
            this.prezzo = prezzo;
        } catch (PrezzoNonValidoException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(String annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Giochi{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione='" + annoPubblicazione + '\'' +
                ", prezzo=" + prezzo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Giochi giochi = (Giochi) o;
        return id == giochi.id && Objects.equals(titolo, giochi.titolo) && Objects.equals(annoPubblicazione, giochi.annoPubblicazione);
    }

}
