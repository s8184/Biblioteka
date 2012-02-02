package czytelnia;

import java.util.Calendar;

import wyjatki.CmojWyjatek;


public class Cczytelnik extends Cosoba {
	//private static int Numer = 0; 
	private Ckalendarz DataZapisania;
	
	public Cczytelnik() {
		super();
	}
	
	public Cczytelnik(String Imie, String Nazwisko, Ckalendarz DataUrodzenia, Ckalendarz DataZapisania) throws CmojWyjatek {	
		super( Imie,Nazwisko,DataUrodzenia );
		this.UstawDataZapisania( DataZapisania );
		//this.Numer = ++this.Numer;
	}

	/**
	 * @return the dataZapisania
	 */
	public Ckalendarz PobierzDataZapisania() {
		return DataZapisania;
	}

	/**
	 * @param dataZapisania the dataZapisania to set
	 */
	public void UstawDataZapisania(Ckalendarz dataZapisania) throws CmojWyjatek  {
		if ( this.PobierzDataUrodzenia().PobierzInstancje().after(dataZapisania.PobierzInstancje()) )
			throw new CmojWyjatek("Data zapisania nie mo¿e byæ póŸniejsza ni¿ data urodzenia czytelnika! (czytelnik: "+this.PobierzImie()+" "+this.PobierzNazwisko()+")");
		else
			DataZapisania = dataZapisania;
	}
	
/*

	public int getNumer() {
		return Numer;
	}
*/
	public String toString() {
		//return "Numer: "+this.getNumer()+"\nDane osobowe czytelnika: "+this.getImie()+" "+this.getNazwisko()+", ur."+this.getDataUrodzenia().get(Calendar.YEAR)+"/"+(this.getDataUrodzenia().get(Calendar.MONTH)+1)+"/"+this.getDataUrodzenia().get(Calendar.DAY_OF_MONTH)+". Data zapisania: "+this.getDataZapisania().get(Calendar.YEAR)+"/"+(this.getDataZapisania().get(Calendar.MONTH)+1)+"/"+this.getDataZapisania().get(Calendar.DAY_OF_MONTH);
		return "Dane osobowe czytelnika: "+this.PobierzImie()+" "+this.PobierzNazwisko()+", ur."+this.PobierzDataUrodzenia().PobierzDate() +". Data zapisania: "+this.PobierzDataZapisania().PobierzDate();
	}
}
