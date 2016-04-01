package com.twitter.poruke;
/**
 * Klasa se odnosi na twitter poruku
 * @author Andjela
 * 
 */
public class TwitterPoruka {
	/**
	 * Informacije o korisniku poruke
	 */
	private String korisnik;
	/**
	 * Sadrzi poruku koju korisnik salje
	 */
	private String poruka;
	/**
	 * Metoda vraca korisnika poruke
	 * @return Korisnik kao string
	 */
	public String getKorisnik() {
		return korisnik;
	}
	/**
	 * Metoda postavlja korisnika poruke
	 * @param korisnik username korisnika u vidu stringa
	 * @throws java.lang.RuntimeException Ukoliko je ime null ili prazan string
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik == "")
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	/**
	 * Metoda vraca poruku
	 * @return poruka kao string
	 */
	public String getPoruka() {
		return poruka;
	}
	/**
	 * Metoda postavlja poruku
	 * @param poruka poruka korisnika u vidu stringa
	 * @throws java.lang.RuntimeException Ukoliko poruka nije uneta ili ima vise od 140 znakova
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	
	/**
	 * Metoda vraca informacije o korisniku i poruci
	 * @return korisnik i poruka kao string
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}
}