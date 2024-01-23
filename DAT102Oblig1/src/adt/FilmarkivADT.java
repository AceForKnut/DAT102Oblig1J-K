package adt;

import impl.Film;

public interface FilmarkivADT {

	/**
	* Hente en film med gitt nr fra arkivet
	* @param nr nummer på film som skal hentes.
	* @return film med gitt nr. Om nr ikke finnes, returneres null.
	*/
	Film finnFilm(int nr);
	/**
	* Legger til en ny film.
	* @param nyFilm
	* inkrementere antall filmer
	*/
	void leggTilFilm(Film nyFilm);
	/**
	 * sletter en film med gitt nr i parameteren.
	 * @param filmnr et heltal som sier hvilket nr film som skal slettes
	 * @return true om en film ble slettet og false hvis ikkje.
	 */
	boolean slettFilm(int filmnr);
	/**
	* Søker og henter Filmer med en gitt delstreng i tittelen.
	* @param delstreng som må være i tittel
	* @return tabell med filmer som har delstreng i tittel
	*/
	Film[] soekTittel(String delstreng);
	/**
	* Søker og henter filmer med en gitt delstreng i filmprodusent
	* @param delstreng
	* @return
	*/
	Film[] soekProdusent(String delstreng);
	/**
	* Finner antall filmer med gitt sjanger
	* @param sjanger som vil da finne kanskje mer enn en.
	* @return antall filmer av gitt sjanger.
	*/
	int antall(Sjanger sjanger);
	/**
	* @return antall filmer i arkivet
	*/
	int antall();
}
