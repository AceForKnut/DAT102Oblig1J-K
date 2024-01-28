package impl;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import impl.Filmarkiv;
import impl.Film;
import impl.Sjanger;

public class FilmarkivTest {

    private Filmarkiv filmarkiv;

    @BeforeEach
    void setUp() {
        filmarkiv = new Filmarkiv(10); // Assuming a maximum of 10 films in the library
    }

    @Test
    void leggTilFilm_OppretterNyttFilmObjekt() {
        Film nyFilm = new Film("Produsent", "Tittel", 2022, Sjanger.ACTION, "Filmselskap");
        filmarkiv.leggTilFilm(nyFilm);

        assertEquals(nyFilm, filmarkiv.finnFilm(0));
        assertEquals(1, filmarkiv.antall());
    }

    @Test
    void slettFilm_FjernerFilmOgTrimmerTabell() {
        Film film1 = new Film("Produsent1", "Tittel1", 2022, Sjanger.ACTION, "Filmselskap1");
        Film film2 = new Film("Produsent2", "Tittel2", 2022, Sjanger.COMEDY, "Filmselskap2");

        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);

        assertTrue(filmarkiv.slettFilm(0));
        assertNull(filmarkiv.finnFilm(0));
        assertEquals(1, filmarkiv.antall());
    }

    @Test
    void soekTittel_FinnerFilmerMedDelstrengIListen() {
        Film film1 = new Film("Produsent1", "Tittel1", 2022, Sjanger.ACTION, "Filmselskap1");
        Film film2 = new Film("Produsent2", "Tittel2", 2022, Sjanger.COMEDY, "Filmselskap2");

        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);

        Film[] resultat = filmarkiv.soekTittel("Tittel");

        assertEquals(2, resultat.length);
        assertEquals(film1, resultat[0]);
        assertEquals(film2, resultat[1]);
    }

    @Test
    void soekProdusent_FinnerFilmerMedDelstrengIListen() {
        Film film1 = new Film("Produsent1", "Tittel1", 2022, Sjanger.ACTION, "Filmselskap1");
        Film film2 = new Film("Produsent2", "Tittel2", 2022, Sjanger.COMEDY, "Filmselskap2");


        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);

        Film[] resultat = filmarkiv.soekProdusent("Produsent");

        assertEquals(2, resultat.length);
        assertEquals(film1, resultat[0]);
        assertEquals(film2, resultat[1]);
    }

    @Test
    void antall_FinnerAntallFilmerAvSpesifikkSjanger() {
        Film film1 = new Film("Produsent1", "Tittel1", 2022, Sjanger.ACTION, "Filmselskap1");
        Film film2 = new Film("Produsent2", "Tittel2", 2022, Sjanger.ACTION, "Filmselskap2");

        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);

        int antallSjanger = filmarkiv.antall(Sjanger.ACTION);

        assertEquals(2, antallSjanger);
    }
}
