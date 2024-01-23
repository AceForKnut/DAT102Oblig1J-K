package impl;
import adt.FilmarkivADT;
import java.util.List;
import java.util.ArrayList;

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
		for(int i = 0; i < filmTab.length; i++) {
			if(filmTab[i] == null) {
				filmTab[i] = nyFilm;
				antallFilmer++;
			} else {
				utvidTab();
				leggTilFilm(nyFilm);
			}
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
		
		for(Film film : filmTab) {
			int i = 0;
			if(film.getTittel().contains(delstreng)) {
				sokeTreff[i] = film; 
				i++;
			}
		}
		return sokeTreff;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] sokeTreff = new Film[antallFilmer];
		
		for(Film film : filmTab) {
			int i = 0;
			if(film.getProdusent().contains(delstreng)) {
				sokeTreff[i] = film; 
				i++;
			}
		}
		return sokeTreff;
	}

	@Override
	public int antall() {
		return antallFilmer;
	}
	
	
}
