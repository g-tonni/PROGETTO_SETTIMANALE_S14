package giada_tonni;

import giada_tonni.entities.*;
import giada_tonni.exception.IdNonValidoException;
import giada_tonni.exception.NumeroGiocatoriNonValidoException;
import giada_tonni.exception.PrezzoNonValidoException;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        GiocoDaTavolo g1  = new GiocoDaTavolo(101, "Risiko", "1998", 34.5, 6, 120);
        GiocoDaTavolo g2  = new GiocoDaTavolo(102, "Monopoly", "2000", 25.0, 8, 80);
        GiocoDaTavolo g3  = new GiocoDaTavolo(103, "Cluedo", "1995", 29.9, 6, 60);
        GiocoDaTavolo g4  = new GiocoDaTavolo(104, "Dixit", "2010", 32.0, 6, 30);
        GiocoDaTavolo g5  = new GiocoDaTavolo(105, "Taboo", "2008", 27.5, 8, 45);
        GiocoDaTavolo g6  = new GiocoDaTavolo(106, "Bang!", "2004", 21.0, 7, 40);
        GiocoDaTavolo g7  = new GiocoDaTavolo(107, "Carcassonne", "2002", 35.0, 5, 50);
        GiocoDaTavolo g8  = new GiocoDaTavolo(108, "7 Wonders", "2011", 42.0, 7, 45);
        GiocoDaTavolo g9  = new GiocoDaTavolo(109, "Exploding Kittens", "2015", 19.9, 5, 15);
        GiocoDaTavolo g10 = new GiocoDaTavolo(110, "Catan", "1999", 38.0, 4, 90);
        GiocoDaTavolo g11 = new GiocoDaTavolo(111, "Uno", "1985", 12.0, 10, 20);
        GiocoDaTavolo g12 = new GiocoDaTavolo(112, "Scotland Yard", "1996", 30.0, 6, 60);
        GiocoDaTavolo g13 = new GiocoDaTavolo(113, "Ticket to Ride", "2004", 44.9, 5, 75);
        GiocoDaTavolo g14 = new GiocoDaTavolo(114, "Mysterium", "2015", 39.0, 7, 50);
        GiocoDaTavolo g15 = new GiocoDaTavolo(115, "Azul", "2017", 36.0, 4, 40);

        Videogioco v1  = new Videogioco(201, "Resident Evil", "2005", 56.5, Piattaforma.PS5, 25, Genere.ZOMBIE);
        Videogioco v2  = new Videogioco(202, "Silent Hill", "2001", 49.9, Piattaforma.PS5, 20, Genere.HORROR);
        Videogioco v3  = new Videogioco(203, "The Last of Us", "2013", 59.9, Piattaforma.PS5, 30, Genere.AVVENTURA);
        Videogioco v4  = new Videogioco(204, "Outlast", "2014", 19.9, Piattaforma.PC, 10, Genere.HORROR);
        Videogioco v5  = new Videogioco(205, "FIFA 23", "2023", 69.9, Piattaforma.XBOX, 100, Genere.SPORT);
        Videogioco v6  = new Videogioco(206, "Overcooked", "2016", 24.9, Piattaforma.SWITCH, 15, Genere.COOP);
        Videogioco v7  = new Videogioco(207, "Mario Kart 8", "2017", 59.9, Piattaforma.SWITCH, 50, Genere.PARTY);
        Videogioco v8  = new Videogioco(208, "Dead by Daylight", "2016", 29.9, Piattaforma.PC, 40, Genere.HORROR);
        Videogioco v9  = new Videogioco(209, "Portal 2", "2011", 19.9, Piattaforma.PC, 20, Genere.ESCAPE);
        Videogioco v10 = new Videogioco(210, "It Takes Two", "2021", 39.9, Piattaforma.PS5, 18, Genere.COOP);
        Videogioco v11 = new Videogioco(211, "Minecraft", "2011", 26.9, Piattaforma.PC, 200, Genere.AVVENTURA);
        Videogioco v12 = new Videogioco(212, "Zelda BOTW", "2017", 69.9, Piattaforma.SWITCH, 120, Genere.AVVENTURA);
        Videogioco v13 = new Videogioco(213, "Left 4 Dead", "2008", 14.9, Piattaforma.PC, 25, Genere.ZOMBIE);
        Videogioco v14 = new Videogioco(214, "Among Us", "2020", 4.9, Piattaforma.PC, 10, Genere.PARTY);
        Videogioco v15 = new Videogioco(215, "Escape Room VR", "2022", 34.9, Piattaforma.PS5, 12, Genere.ESCAPE);

        Collezione collezione = new Collezione();

        collezione.aggiungiGioco(v3);
        collezione.aggiungiGioco(g1);
        collezione.aggiungiGioco(v1);
        collezione.aggiungiGioco(g4);
        collezione.aggiungiGioco(v6);
        collezione.aggiungiGioco(g2);
        collezione.aggiungiGioco(g10);
        collezione.aggiungiGioco(v2);
        collezione.aggiungiGioco(v5);
        collezione.aggiungiGioco(g7);
        collezione.aggiungiGioco(v4);
        collezione.aggiungiGioco(g6);
        collezione.aggiungiGioco(v10);
        collezione.aggiungiGioco(g3);
        collezione.aggiungiGioco(v7);
        collezione.aggiungiGioco(g5);
        collezione.aggiungiGioco(v9);
        collezione.aggiungiGioco(v8);
        collezione.aggiungiGioco(g8);
        collezione.aggiungiGioco(g9);

        System.out.println(collezione);

        while (true){
            System.out.println("Scegli un numero da 1 a 6 per effettuare una di queste operazioni oppure 0 per usscire: ");
            System.out.println("1 - Aggiungere un elemento");
            System.out.println("2 - Rimuovere un elemento");
            System.out.println("3 - Cercare un elemento in base al suo ID");
            System.out.println("4 - Cercare un elemento in base al suo prezzo");
            System.out.println("5 - Cercare un elemento in base al numero di giocatori");
            System.out.println("6 - Aggiornare un elemento");
            System.out.println("7 - Ottenere le statistiche della Collezione");
            int num = Integer.parseInt(scanner.nextLine());
            if (num == 0) break;
            switch (num){
                case 1: {
                    System.out.println("Premi 1 per aggiungere un Videogioco, 2 per aggiungere un Gioco da Tavolo");
                    int num1 = Integer.parseInt(scanner.nextLine());
                    if(num1 == 1){
                        System.out.println("Scegli l'elemento da aggiungere con un numero da 1 a 5");
                        int num2 = Integer.parseInt(scanner.nextLine());
                        switch (num2){
                            case 1: {
                                collezione.aggiungiGioco(v11);
                                break;
                            }
                            case 2: {
                                collezione.aggiungiGioco(v12);
                                break;
                            }
                            case 3: {
                                collezione.aggiungiGioco(v13);
                                break;
                            }
                            case 4: {
                                collezione.aggiungiGioco(v14);
                                break;
                            }
                            case 5: {
                                collezione.aggiungiGioco(v15);
                                break;
                            }
                            default: {
                                System.out.println("Valore non valido");
                            }
                        }
                    } else {
                        System.out.println("Scegli l'elemento da aggiungere con un numero da 1 a 5");
                        int num2 = Integer.parseInt(scanner.nextLine());
                        switch (num2){
                            case 1: {
                                collezione.aggiungiGioco(g11);
                                break;
                            }
                            case 2: {
                                collezione.aggiungiGioco(g12);
                                break;
                            }
                            case 3: {
                                collezione.aggiungiGioco(g13);
                                break;
                            }
                            case 4: {
                                collezione.aggiungiGioco(g14);
                                break;
                            }
                            case 5: {
                                collezione.aggiungiGioco(g15);
                                break;
                            }
                            default: {
                                System.out.println("Valore non valido");
                            }
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("Scrivi l'ID dell'elemento da rimuovere: ");
                    int num1 = Integer.parseInt(scanner.nextLine());
                    collezione.rimuoviGioco(num1);
                    break;
                }
                case 3: {
                    System.out.println("Scrivi l'ID del prodotto da cercare: ");
                    int num1 = Integer.parseInt(scanner.nextLine());
                    try {
                        Giochi giocoId = collezione.cercaID(num1);
                        System.out.println(giocoId);
                    } catch (IdNonValidoException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                case 4: {
                    System.out.println("Scrivi il prezzo del prodotto da cercare: ");
                    double num1 = Integer.parseInt(scanner.nextLine());
                    try {
                        List<Giochi> giochiPrezzo = collezione.cercaPrezzo(num1);
                        System.out.println(giochiPrezzo);
                    } catch (PrezzoNonValidoException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                case 5: {
                    System.out.println("Scrivi il numero di giocatori del prodotto da cercare: ");
                    int num1 = Integer.parseInt(scanner.nextLine());
                    try {
                        List<Giochi> giochiNumGiocatori = collezione.cercaNumGiocatori(num1);
                        System.out.println(giochiNumGiocatori);
                    } catch (NumeroGiocatoriNonValidoException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                case 6: {
                    System.out.println("Aggiorna elemento");
                    break;
                }
                case 7: {
                    collezione.statistiche();
                    break;
                }
                default: {
                    System.out.println("Valore non valido");
                }
            }
        }
    }
}
