package czytelnia;

import java.util.Calendar;

import wyjatki.CmojWyjatek;


public class Cosoba {
	private String Imie;
	private String Nazwisko;
	private Ckalendarz DataUrodzenia;
	
	public Cosoba() {
		
	}
	
	public Cosoba(String i, String n, Ckalendarz d) throws CmojWyjatek {
		Calendar obecnaData = Calendar.getInstance();
		if ( d.PobierzInstancje().after(obecnaData) )
				throw new CmojWyjatek("Data urodzenia nie mo¿e byæ póŸniejsza ni¿ data dzisiejsza! Obiekt nie zosta³ utworzony.");
		else {
			this.UstawImie(i);
			this.UstawNazwisko(n);		
			this.UstawDataUrodzenia(d);
		}
	}

	/**
	 * @return the imie
	 */
	public String PobierzImie() {
		return Imie;
	}

	/**
	 * @param imie the imie to set
	 */
	public void UstawImie(String imie) {
		Imie = imie;
	}

	/**
	 * @return the nazwisko
	 */
	public String PobierzNazwisko() {
		return Nazwisko;
	}

	/**
	 * @param nazwisko the nazwisko to set
	 */
	public void UstawNazwisko(String nazwisko) {
		Nazwisko = nazwisko;
	}
	
	/**
	 * @return the dataUrodzenia
	 */
	public Ckalendarz PobierzDataUrodzenia() {
		return DataUrodzenia;
	}

	/**
	 * @param dataUrodzenia the dataUrodzenia to set
	 */
	public void UstawDataUrodzenia(Ckalendarz dataUrodzenia) {
		DataUrodzenia = dataUrodzenia;
	}

	public String toString() {
		return this.PobierzImie()+" "+this.PobierzNazwisko()+", data ur. "+this.PobierzDataUrodzenia().PobierzDate();
	}
	
}
