package czytelnia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class czytelnia_lite {

	public static void main(String[] args) throws SQLException {

		Cbiblioteka b = null;
		Cczytelnik c1 = null, c2 = null, c3 = null,c4 = null;
		Cksiazka k1 = null, k2 = null;
		
		try {
			
			b = new Cbiblioteka();
			
			c1 = new Cczytelnik("Roman","Pi³ka",new Ckalendarz(1984,Calendar.MAY,16) , new Ckalendarz(2011,Calendar.JULY,11) );
			c2 = new Cczytelnik("Bart³omiej","G¹bka",new Ckalendarz(1956,Calendar.DECEMBER,8) , new Ckalendarz(2000,Calendar.JANUARY,1) );
			c3 = new Cczytelnik("Micha³","Wo³odyjowski",new Ckalendarz(1650,Calendar.JUNE,30) , new Ckalendarz(1660,Calendar.MARCH,29) );
			c4 = new Cczytelnik("Gandalf","Szary",new Ckalendarz(1234,Calendar.AUGUST,13) , new Ckalendarz(1830,Calendar.MARCH,2) );
			
			// dodanie czytelników
			b.Czytelnicy.Dodaj(c1);
			b.Czytelnicy.Dodaj(c2);
			b.Czytelnicy.Dodaj( new Cczytelnik("Adam","Ma³ysz",new Ckalendarz(1970,Calendar.NOVEMBER,15), new Ckalendarz(1985,Calendar.APRIL,5)) );
			b.Czytelnicy.Dodaj(c3);
			b.Czytelnicy.Dodaj(c4);
			
			//dodanie ksi¹¿ek
			k1 = new Cksiazka("Medaliony","Zofia","Na³kowska",112233);
			b.Ksiazki.Dodaj(k1);
			
			b.Ksiazki.Dodaj( new Cksiazka("Flayboys","James","Bradley",778997) );
			b.Ksiazki.Dodaj( new Cksiazka("Gringo w krainie dzikich plemion","Wojciech","Cejrowski",121212) );
			k2 = b.Ksiazki.Dodaj( new Cksiazka("Flags of our fathers","James","Bradley",44456765)  );					
			
			System.out.println( b.StanBiblioteki() );
			
			// sprawdzenie dzia³ania mechanizmu wypo¿yczenia
			b.WypozyczenieKsiazki(c1, k1);
			
			System.out.println( b.StanBiblioteki() );
			
			// sprawdzenie, czy mo¿na wypo¿yczyæ wypo¿yczon¹ ksi¹¿kê
			b.WypozyczenieKsiazki(b.Czytelnicy.ZnajdzCzytelnika(3), k1);
			
			// sprawdzenie wszukiwania ksi¹zek po autorze
			List<Cksiazka> lista = new ArrayList<Cksiazka>();
			lista = b.Ksiazki.PobierzKsiazki("James", "Bradley");
			System.out.println("Znaleziono "+lista.size()+" ksi¹¿ek tego autora!");
			
			// wypozyczenie ksi¹¿ki - inny sposób znalezienia ksi¹¿ki
			b.WypozyczenieKsiazki(c4, b.Ksiazki.PobierzKsiazke("Flayboys"));
			
			// wypozyczenie ksi¹¿ki - inny sposób znalezienia ksi¹¿ki (której nie ma w bazie)
			try {
				b.WypozyczenieKsiazki(c4, b.Ksiazki.PobierzKsiazke("FlayboysXXX"));
			}
			catch(Exception e) {
				System.out.println("B³¹d przy wypo¿yczaniu: "+e.getMessage());
			}
			
			System.out.println( b.StanBiblioteki() );	
			
			// zwrot ksi¹¿ki
			b.ZwrotKsi¹¿ki(c1, b.Ksiazki.PobierzKsiazke("Medaliony"));
			
			
			System.out.println( b.StanBiblioteki() );			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		b.WykonajInsert("SHUTDOWN");

	}

}
