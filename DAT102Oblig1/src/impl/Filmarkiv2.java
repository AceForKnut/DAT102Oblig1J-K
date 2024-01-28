package impl;
import adt.FilmarkivADT;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Filmarkiv2 implements FilmarkivADT{

	private LinearNode<Film> start;
	private int antallFilmer;
	
	public Filmarkiv2(int maksAntallFilmer) {
		start = null;
		antallFilmer = 0;
	}

	@Override
	public Film finnFilm(int nr) {
		LinearNode<Film> current = start;
		int pos = 0;
		
		while(current != null && pos < nr) {
			current = current.neste;
			pos++;
		}
		if (current != null && pos == nr) {
			return current.data;
		} else {
			return null;
		}
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		   LinearNode<Film> newNode = new LinearNode<>(nyFilm);
		   
		   if(start == null) {
			   start = newNode;
		   } else {
			   LinearNode<Film> current = start;
			   while(current.neste != null) {
				   current = current.neste;
			   }
			   current.neste = newNode;
		   }
		   antallFilmer++;
		}

	@Override
	public boolean slettFilm(int filmnr) {
		LinearNode<Film> current = start;
		LinearNode<Film> prev = null;
		
		while(current != null && current.data.getFilmnr() != filmnr) {
			prev = current;
			current = current.neste;
		}
		if (current == null) {
			return false;
		}
		if(prev == null) {
			start=current.neste;
		} else {
			prev.neste = current.neste;
		}
		antallFilmer--;
		return true;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
	    Film[] sokeTreff = new Film[antallFilmer];
	    int i = 0;
	    LinearNode<Film> current = start;
	    
	     while(current != null){
	    	 Film film = current.data;
	        if (film.getTittel().contains(delstreng)) {
	            sokeTreff[i] = film;
	            i++;
	        }
	        current = current.neste;
	    }
	    return Arrays.copyOf(sokeTreff, i);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] sokeTreff = new Film[antallFilmer];
	    int i = 0;
	    LinearNode<Film> current = start;
	    
	     while(current != null){
	    	 Film film = current.data;
	        if (film.getTittel().contains(delstreng)) {
	            sokeTreff[i] = film;
	            i++;
	        }
	        current = current.neste;
	    }
	    return Arrays.copyOf(sokeTreff, i);
	}

	public int antall(Sjanger sjanger) {
	    int antallSpesSjanger = 0;
	    LinearNode<Film> current = start;
	    
	    while(current != null) {
	    	Film film = current.data;
	    	if(film.getSjanger() == sjanger) {
	    		antallSpesSjanger++;
	    	}
	    	current = current.neste;
	    }

	    return antallSpesSjanger;
	}


	@Override
	public int antall() {
		return antallFilmer;
	}
	
}
