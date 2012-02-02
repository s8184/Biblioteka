package czytelnia;

public class Cwypozyczenie {
	private Cczytelnik Czytelnik;
	private Cksiazka Ksiazka;
	private Ckalendarz DataWypozyczenia;
	private Ckalendarz DataZwrotu;
	
	public Cwypozyczenie() {
		
	}
	
	public Cwypozyczenie(Cczytelnik c, Cksiazka k) {
		this.UstawCzytelnik(c);
		this.UstawKsiazka(k);
		// ustawia bie¿¹c¹ datê jako datê wypo¿yczenia
		this.UstawDataWypozyczenia(new Ckalendarz() );
		this.UstawDataZwrotu(null);
	}
	
	/**
	 * @return the czytelnik
	 */
	public Cczytelnik PobierzCzytelnik() {
		return Czytelnik;
	}
	/**
	 * @param czytelnik the czytelnik to Ustaw
	 */
	public void UstawCzytelnik(Cczytelnik czytelnik) {
		Czytelnik = czytelnik;
	}
	/**
	 * @return the egzemplarz
	 */
	public Cksiazka PobierzKsiazka() {
		return Ksiazka;
	}
	/**
	 * @param egzemplarz the egzemplarz to Ustaw
	 */
	public void UstawKsiazka(Cksiazka ksiazka) {
		Ksiazka = ksiazka;
	}
	/**
	 * @return the dataWypozyczenia
	 */
	public Ckalendarz PobierzDataWypozyczenia() {
		return DataWypozyczenia;
	}
	/**
	 * @param dataWypozyczenia the dataWypozyczenia to Ustaw
	 */
	public void UstawDataWypozyczenia(Ckalendarz dataWypozyczenia) {
		DataWypozyczenia = dataWypozyczenia;
	}
	/**
	 * @return the dataZwrotu
	 */
	public Ckalendarz PobierzDataZwrotu() {
		return DataZwrotu;
	}
	/**
	 * @param dataZwrotu the dataZwrotu to Ustaw
	 */
	public void UstawDataZwrotu(Ckalendarz dataZwrotu) {
		
		this.DataZwrotu = dataZwrotu;
	}
	
	public String Opis() {
		return this.PobierzCzytelnik()+ " po¿yczy³ "+this.PobierzKsiazka()+" dnia "+this.PobierzDataWypozyczenia().PobierzDateCzas()+", a odda³ go "+this.PobierzDataZwrotu().PobierzDateCzas();
	}
	
	public void Zwrot() {
		this.UstawDataZwrotu( new Ckalendarz() );
		this.PobierzKsiazka().Oddaj();
		System.out.println( this.Opis() );
	}
}
