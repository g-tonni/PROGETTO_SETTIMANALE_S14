package giada_tonni.entities;

import giada_tonni.exception.DurataNonValidaException;
import giada_tonni.exception.NumeroGiocatoriNonValidoException;

public class GiocoDaTavolo extends Giochi{
    private int numGiocatori;
    private double durataPartita;

    public GiocoDaTavolo (int id, String titolo, String annoPubblicazione, double prezzo, int numGiocatori, double durataPartita){
        super(id, titolo, annoPubblicazione, prezzo);
        try{
            if(numGiocatori < 2 || numGiocatori > 10) throw new NumeroGiocatoriNonValidoException();
            this.numGiocatori = numGiocatori;
        } catch (NumeroGiocatoriNonValidoException ex){
            System.out.println(ex.getMessage());
        }
        try{
            if(durataPartita <= 0) throw new DurataNonValidaException();
            this.durataPartita = durataPartita;
        } catch (DurataNonValidaException ex){
            System.out.println(ex.getMessage());
        }
    }

    public int getNumGiocatori() {
        return numGiocatori;
    }

    public void setNumGiocatori(int numGiocatori) {
        this.numGiocatori = numGiocatori;
    }

    public double getDurataPartita() {
        return durataPartita;
    }

    public void setDurataPartita(double durataPartita) {
        this.durataPartita = durataPartita;
    }

    @Override
    public String toString() {
        return "GiocoDaTavolo{" +
                "id=" + this.getId() +
                ", titolo='" + this.getTitolo() + '\'' +
                ", annoPubblicazione='" + this.getAnnoPubblicazione() + '\'' +
                ", prezzo=" + this.getPrezzo() +
                ", numGiocatori=" + numGiocatori +
                ", durataPartita=" + durataPartita +
                '}';
    }
}
