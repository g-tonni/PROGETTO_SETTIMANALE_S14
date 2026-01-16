package giada_tonni.entities;

import giada_tonni.exception.GiocoEsistenteException;
import giada_tonni.exception.IdNonValidoException;
import giada_tonni.exception.NumeroGiocatoriNonValidoException;
import giada_tonni.exception.PrezzoNonValidoException;

import java.util.*;
import java.util.stream.Collectors;

public class Collezione {
    private List<Giochi> collezioneGiochi;

    public Collezione(){
        this.collezioneGiochi = new ArrayList<>();
    }

    public void aggiungiGioco(Giochi gioco){
        try{
            for (int i = 0; i < this.collezioneGiochi.size(); i++) {
                if (gioco.getId() == this.collezioneGiochi.get(i).getId()) throw new IdNonValidoException("L'ID inserito è già esistente");
                if(this.collezioneGiochi.get(i).equals(gioco)) throw new GiocoEsistenteException();
            }
            this.collezioneGiochi.add(gioco);
        } catch (IdNonValidoException ex){
            System.out.println(ex.getMessage());
        } catch (GiocoEsistenteException ex2){
            System.out.println(ex2.getMessage());
        }
    }

    public void rimuoviGioco(int id){
        try{
            if(this.collezioneGiochi.stream().anyMatch(gioco -> gioco.getId() == id)){
                 this.collezioneGiochi.removeIf(gioco -> gioco.getId() == id);
            } else {
                throw new IdNonValidoException("ID non valido o inesistente");
            }
        } catch (IdNonValidoException ex){
            System.out.println(ex.getMessage());
        }
    }

/*    public void aggiornaElemento (int id, String elementoModifica){
        try{
            if(this.collezioneGiochi.stream().anyMatch(gioco -> gioco.getId() == id)){
                Optional<Giochi> giocoId = this.collezioneGiochi.stream()
                        .filter(gioco -> gioco.getId() == id)
                        .findFirst();
                Giochi giocoAgg = giocoId.get();
            } else {
                throw new IdNonValidoException("ID non valido o inesistente");
            }
        } catch (IdNonValidoException ex) {
            System.out.println(ex.getMessage());
        }
    }*/

    public void statistiche (){
        List<Giochi> giochiTavolo = this.collezioneGiochi.stream()
                .filter(gioco -> {
                    if( gioco instanceof GiocoDaTavolo){
                        return true;
                    } else {
                        return false;
                    }
                }).toList();
        int numGiochiTavolo = giochiTavolo.size();
        List<Giochi> videogiochi = this.collezioneGiochi.stream()
                .filter(gioco -> {
                    if( gioco instanceof Videogioco){
                        return true;
                    } else {
                        return false;
                    }
                }).toList();
        int numVideogiochi = videogiochi.size();
        Optional<Giochi> giocoCostoso = this.collezioneGiochi.stream()
                        .max(Comparator.comparing(gioco -> gioco.getPrezzo()));
        OptionalDouble media = this.collezioneGiochi.stream()
                        .mapToDouble(gioco -> gioco.getPrezzo()).average();

        System.out.println("Numero Videogiochi: " + numVideogiochi);
        System.out.println("Numero Giochi da Tavolo: " + numGiochiTavolo);
        System.out.println("Giochi totali: " + this.collezioneGiochi.size());
        if(giocoCostoso.isPresent()) System.out.println("Gioco più costoso: " + giocoCostoso.get());
        if (media.isPresent()) System.out.println("Media dei prezzi: " + media.getAsDouble() +"€");
    }

    public Giochi cercaID (int id) throws IdNonValidoException {
            Optional<Giochi> giocoId = this.collezioneGiochi.stream()
                    .filter(gioco -> gioco.getId() == id)
                    .findFirst();
            if(giocoId.isPresent()){
                return giocoId.get();
            } else {
                throw new IdNonValidoException("ID non valido o inesistente");
            }
    }

    public List<Giochi> cercaPrezzo (double prezzo) throws PrezzoNonValidoException {
        if(prezzo < 0){
            throw new PrezzoNonValidoException();
        } else {
            List<Giochi> giochiPerPrezzo = this.collezioneGiochi.stream()
                    .filter(gioco -> gioco.getPrezzo() < prezzo)
                    .toList();
            return giochiPerPrezzo;
        }
    }

    public List<Giochi> cercaNumGiocatori(int num) throws NumeroGiocatoriNonValidoException {
        if(num < 2 || num > 10) {
            throw new NumeroGiocatoriNonValidoException();
        } else {
            List<Giochi> giochiNumGiocatori = this.collezioneGiochi.stream()
                    .filter(gioco -> {
                        if( gioco instanceof GiocoDaTavolo){
                            GiocoDaTavolo giocoTavolo =
                                    (GiocoDaTavolo) new GiocoDaTavolo(gioco.getId(), gioco.getTitolo(), gioco.getAnnoPubblicazione(), gioco.getPrezzo(), ((GiocoDaTavolo) gioco).getNumGiocatori(), (int) ((GiocoDaTavolo) gioco).getDurataPartita());
                            return giocoTavolo.getNumGiocatori() == num;
                        } else {
                            return false;
                        }
                    }).toList();
            return giochiNumGiocatori;
        }
    }

    public List<Giochi> getCollezioneGiochi() {
        return collezioneGiochi;
    }

    @Override
    public String toString() {
        return "Collezione{" +
                "collezioneGiochi=" + collezioneGiochi +
                '}';
    }
}
