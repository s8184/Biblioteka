package czytelnia;

import wyjatki.CmojWyjatek;


public class Cksiazka {
	private String Tytul;
	private String ImieAutora;
	private String NazwiskoAutora;
	private int ISBN;
	private boolean Wypozyczona;

	public Cksiazka() {

	}
	
	public Cksiazka(String t, String i, String n, int isbn) throws CmojWyjatek {
		this.UstawImieAutora(i);
		this.UstawNazwiskoAutora(n);
		this.UstawTytul(t);
		this.UstawISBN(isbn);		
	}
	/**
	 * @return the tytul
	 */
	public String PobierzTytul() {
		return Tytul;
	}
	/**
	 * @param tytul the tytul to Ustaw
	 */
	public void UstawTytul(String tytul) {
		Tytul = tytul;
	}
	/**
	 * @return the imieAutora
	 */
	public String PobierzImieAutora() {
		return ImieAutora;
	}
	/**
	 * @param imieAutora the imieAutora to Ustaw
	 */
	public void UstawImieAutora(String imieAutora) {
		ImieAutora = imieAutora;
	}
	/**
	 * @return the nazwiskoAutora
	 */
	public String PobierzNazwiskoAutora() {
		return NazwiskoAutora;
	}
	/**
	 * @param nazwiskoAutora the nazwiskoAutora to Ustaw
	 */
	public void UstawNazwiskoAutora(String nazwiskoAutora) {
		NazwiskoAutora = nazwiskoAutora;
	}
	/**
	 * @return the iSBN
	 */
	public int PobierzISBN() {
		return ISBN;
	}
	/**
	 * @param iSBN the iSBN to Ustaw
	 */
	public void UstawISBN(int iSBN) throws CmojWyjatek {
		if (iSBN<0)
			throw new CmojWyjatek(this.PobierzTytul()+" - niepoprawny ISBN (<0))!");
		else
			ISBN = iSBN;		
	}
	
	public String toString() {
		return this.PobierzTytul()+" (ISBN="+this.PobierzISBN()+") - "+this.PobierzImieAutora()+" "+this.PobierzNazwiskoAutora();
		
	}
	
	public String Opis() {
		return this.PobierzTytul()+" - "+this.PobierzImieAutora()+" "+this.PobierzNazwiskoAutora();
	}

	/**
	 * @return the wypozyczona
	 */
	public boolean CzyWypozyczona() {
		return this.Wypozyczona;
	}

	/**
	 * @param wypozyczona the wypozyczona to set
	 */
	public void Oddaj() {
		this.Wypozyczona = false;
	}

	public void Wypozycz() {
		this.Wypozyczona = true;
	}


}
