package klient;

import adt.FilmarkivADT;
import impl.Film;
import java.util.Scanner;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;

    public Meny(FilmarkivADT filmarkiv) {
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }

    public void start() {
        // Legg inn en del forhåndsdefinerte filmer for å teste metodene
        for (int i = 0; i < 5; i++) {
            Film film = tekstgr.lesFilm();
            filmarkiv.leggTilFilm(film);
        }

        // Meny loop
        while (true) {
            System.out.println("Velg en handling:");
            System.out.println("1. Legg til film");
            System.out.println("2. Skriv ut filmer med delstreng i tittelen");
            System.out.println("3. Skriv ut filmer av produsent");
            System.out.println("4. Skriv ut statistikk");
            System.out.println("5. Avslutt");

            Scanner scanner = new Scanner(System.in);
            int valg = scanner.nextInt();

            switch (valg) {
                case 1:
                    Film nyFilm = tekstgr.lesFilm();
                    filmarkiv.leggTilFilm(nyFilm);
                    break;
                case 2:
                    System.out.println("Skriv inn delstreng:");
                    String delstrengTittel = scanner.next();
                    tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, delstrengTittel);
                    break;
                case 3:
                    System.out.println("Skriv inn produsent:");
                    String delstrengProdusent = scanner.next();
                    tekstgr.skrivUtFilmProdusent(filmarkiv, delstrengProdusent);
                    break;
                case 4:
                    tekstgr.skrivUtStatistikk(filmarkiv);
                    break;
                case 5:
                    System.out.println("Avslutter programmet.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ugyldig valg. Prøv igjen.");
            }
        }
    }
}
