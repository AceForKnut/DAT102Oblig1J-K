package impl;
import adt.FilmarkivADT;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Filmarkiv implements FilmarkivADT{

	private Film[] filmTab;
	private int antallFilmer;
	
	public Filmarkiv(int maksAntallFilmer) {
		filmTab = new Film[maksAntallFilmer];
		this.antallFilmer = 0;
	}

	@Override
	public Film finnFilm(int nr) {
		if (filmTab[nr] != null) {
			return filmTab[nr];
		} else {
			return null;
		}
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		    int i = 0;
		    while (i < filmTab.length) {
		        if (filmTab[i] == null) {
		            filmTab[i] = nyFilm;
		            antallFilmer++;
		            break;
		        } else {
		            i++;
		        }
		    }

		    if (i == filmTab.length) {
		        utvidTab();
		        leggTilFilm(nyFilm);
		    }
		}
	private void utvidTab() {
		Film[] nyFilmTab = new Film[filmTab.length * 2];
	    System.arraycopy(filmTab, 0, nyFilmTab, 0, filmTab.length);
	    filmTab = nyFilmTab;
	    
	    //Utvider tabellen filmTab med 2x margin.
	}

	@Override
	public boolean slettFilm(int filmnr) {
		if(filmTab[filmnr] == null) {
			return false;
		} else {
			filmTab[filmnr] = null;
			antallFilmer--;
			for (int i = filmnr; i < filmTab.length - 1; i++) {
				filmTab[i] = filmTab[i + 1];
				filmTab[i +1] = null;
			} filmTab[filmTab.length - 1] = null;
			trimTab();
		return true;
			}
		// slettFilm skal slette filmen med filmnr som blir oppgitt. 
		// Deretter ta i bruk trimTab når en film har blitt slettet
		}


	public void trimTab() {
	    int sistePos = filmTab.length - 1;

	    while (sistePos >= 0 && filmTab[sistePos] == null) {
	        sistePos--;
	    }
	    if (sistePos < filmTab.length - 1) {
	        Film[] trimmetTab = new Film[sistePos + 1];
	        System.arraycopy(filmTab, 0, trimmetTab, 0, sistePos + 1);
	        filmTab = trimmetTab;
	    }
	// trimTab går igjennom tabellen og ser om siste pos er lik null.
	// hvis siste pos er lik null trimmer den ned tabellen sånn at det som kommer ut er en full array.
	}

	@Override
	public Film[] soekTittel(String delstreng) {
	    Film[] sokeTreff = new Film[antallFilmer];

	    int i = 0;

	    for (Film film : filmTab) {
	        if (film != null && film.getTittel().contains(delstreng)) {
	            sokeTreff[i] = film;
	            i++;
	        }
	    }
	    return Arrays.copyOf(sokeTreff, i);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
	    Film[] sokeTreff = new Film[antallFilmer];

	    int i = 0;

	    for (Film film : filmTab) {
	        if (film != null && film.getProdusent().contains(delstreng)) {
	            sokeTreff[i] = film;
	            i++;
	        }
	    }
	    return Arrays.copyOf(sokeTreff, i);  
	}

	public int antall(Sjanger sjanger) {
	    int antallSpesSjanger = 0;

	    for (Film film : filmTab) {
	        if (film != null && film.getSjanger() == sjanger) {
	            antallSpesSjanger++;
	        }
	    }

	    return antallSpesSjanger;
	}


	@Override
	public int antall() {
		return antallFilmer;
	}
	
}
