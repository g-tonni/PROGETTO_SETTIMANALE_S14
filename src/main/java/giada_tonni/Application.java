package giada_tonni;

import giada_tonni.entities.*;
import giada_tonni.exception.IdNonValidoException;
import giada_tonni.exception.NumeroGiocatoriNonValidoException;
import giada_tonni.exception.PrezzoNonValidoException;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        GiocoDaTavolo g1 = new GiocoDaTavolo(1234, "Risiko", "1998", 34.5, 6, 120);
        GiocoDaTavolo g2 = new GiocoDaTavolo(1345, "Monopoly", "2000", 25, 8, 80);
        Videogioco v1 = new Videogioco(134, "Resident Evil", "2005", 56.5, Piattaforma.PS5, 25, Genere.ZOMBIE);
        Videogioco v2 = new Videogioco(1354, "Gioco brutto", "2007", 32, Piattaforma.PS5, 18, Genere.HORROR);

        Collezione collezione = new Collezione();

        System.out.println(collezione);
        collezione.aggiungiGioco(g1);
        collezione.aggiungiGioco(g2);
        System.out.println(collezione);
        collezione.aggiungiGioco(v1);
        collezione.aggiungiGioco(v2);
        System.out.println(collezione);

        try {
            Giochi giocoId = collezione.cercaID(1234);
            System.out.println(giocoId);
        } catch (IdNonValidoException ex){
            System.out.println(ex.getMessage());
        }

        try {
            List<Giochi> giochiPrezzo = collezione.cercaPrezzo(30);
            System.out.println(giochiPrezzo);
        } catch (PrezzoNonValidoException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            List<Giochi> giochiNumGiocatori = collezione.cercaNumGiocatori(7);
            System.out.println(giochiNumGiocatori);
        } catch (NumeroGiocatoriNonValidoException ex) {
            System.out.println(ex.getMessage());
        }

        collezione.rimuoviGioco(1354);
        System.out.println(collezione);


    }
}
