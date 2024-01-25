package klient;

import impl.Film;
import adt.FilmarkivADT;
import impl.Sjanger;
import java.util.Scanner;
import impl.Sjanger;
import impl.Filmarkiv;

public class Tekstgrensesnitt {
    private Scanner scanner;

    public Tekstgrensesnitt() {
        this.scanner = new Scanner(System.in);
    }

    // Leser inn opplysninger om en film fra tastatur og returnerer et Film-objekt
    public Film lesFilm() {
        System.out.println("Legg til en ny film:");
        System.out.print("Tittel: ");
        String tittel = scanner.nextLine();

        System.out.print("Produsent: ");
        String produsent = scanner.nextLine();

        System.out.print("Sjanger: ");
        String sjangerString = scanner.nextLine();
        Sjanger sjanger;

        try {
            sjanger = Sjanger.valueOf(sjangerString.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Ugyldig sjanger. Bruker UNKNOWN.");
            sjanger = Sjanger.UNKNOWN; 
        }

        System.out.print("År: ");
        int år = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Filmselskap: ");
        String filmselskap = scanner.nextLine();

        return new Film(produsent, tittel, år, sjanger, filmselskap);
    }





    // Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
    public void skrivUtFilm(Film film) {
        System.out.println("Film detaljer:");
        System.out.println("Tittel: " + film.getTittel());
        System.out.println("Produsent: " + film.getProdusent());
        System.out.println("Sjanger: " + film.getSjanger());
        System.out.println("År: " + film.getLansering());
        System.out.println();
    }

    // Skriver ut alle filmer med en spesiell delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
        Film[] filmer = arkiv.soekTittel(delstreng);
        System.out.println("Filmer med delstreng '" + delstreng + "' i tittelen:");
        for (Film film : filmer) {
            if (film != null) {
                skrivUtFilm(film);
            }
        }
    }

    // Skriver ut alle Filmer av en produsent (produsent er delstreng)
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        Film[] filmer = arkiv.soekProdusent(delstreng);
        System.out.println("Filmer av produsent '" + delstreng + "':");
        for (Film film : filmer) {
            if (film != null) {
                skrivUtFilm(film);
            }
        }
    }


    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        System.out.println("Statistikk:");
        System.out.println("Totalt antall filmer: " + arkiv.antall());
        System.out.println("Antall filmer per sjanger:");
        for (Sjanger sjanger : Sjanger.values()) {
            int antall = arkiv.antall(sjanger);
            System.out.println(sjanger + ": " + antall);
        }
    }
}
