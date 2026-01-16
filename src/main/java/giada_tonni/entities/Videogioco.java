package giada_tonni.entities;

import giada_tonni.exception.DurataNonValidaException;

public class Videogioco extends Giochi{
    private Piattaforma piattaforma;
    private int durata;
    private Genere genere;

    public Videogioco(int id, String titolo, String annoPubblicazione, double prezzo, Piattaforma piattaforma, int durata, Genere genere){
        super(id, titolo, annoPubblicazione, prezzo);
        this.piattaforma = piattaforma;
        try {
            if (durata <= 0) throw new DurataNonValidaException();
            this.durata = durata;
        } catch (DurataNonValidaException ex){
            System.out.println(ex.getMessage());
        }
        this.genere = genere;
    }

    public Piattaforma getPiattaforma() {
        return piattaforma;
    }

    public void setPiattaforma(Piattaforma piattaforma) {
        this.piattaforma = piattaforma;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Videogioco{" +
                "id=" + this.getId() +
                ", titolo='" + this.getTitolo() + '\'' +
                ", annoPubblicazione='" + this.getAnnoPubblicazione() + '\'' +
                ", prezzo=" + this.getPrezzo() +
                ", piattaforma=" + piattaforma +
                ", durata=" + durata +
                ", genere=" + genere +
                '}';
    }
}
