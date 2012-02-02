package czytelnia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import baza.CbazaDanych;

import wyjatki.CmojWyjatek;

public class Cczytelnicy extends CbazaDanych {
	private List<Cczytelnik> lista;
	
	private static final String tworzenieTabeli = "create table czytelnicy (id integer generated always as identity, imie varchar(40), nazwisko varchar(40), data_urodzenia date not null, data_zapisania date not null)";	
	
	public Cczytelnicy() throws SQLException {
		this.lista = new ArrayList<Cczytelnik>();
		
		if (!this.CzyTabelaIstnieje(Etabele.czytelnicy.toString()))
			this.StworzTabele(tworzenieTabeli);
		else
			this.WyczyscTabele(Etabele.czytelnicy.toString());
			
	}

	public void Dodaj(Cczytelnik c) throws CmojWyjatek, SQLException {
		if ( this.lista.contains(c) )
			throw new CmojWyjatek("Taki czytelnik juz istnieje!");
		else {
			this.lista.add(c);
			this.WykonajInsert("insert into "+Etabele.czytelnicy+" (imie,nazwisko,data_urodzenia,data_zapisania) values ('"+c.PobierzImie()+"','"+c.PobierzNazwisko()+"','"+c.PobierzDataUrodzenia().PobierzDate().replace("/", "-")+"','"+c.PobierzDataZapisania().PobierzDate()+"')");
		}
	}
	
	public void Usun(Cczytelnik c) throws SQLException {		
		this.WykonajDelete("delete from "+Etabele.czytelnicy+" where imie='"+c.PobierzImie()+"' and nazwisko='"+c.PobierzNazwisko()+"' and data_urodzenia='"+c.PobierzDataUrodzenia().PobierzDate()+"'");
		this.lista.remove(c);
	}
	
	public void Usun(int index) throws SQLException {		
		this.Usun(this.lista.get(index));
		//this.WykonajDelete("delete from "+tabela+" where imie='"+c.getImie()+"' and nazwisko='"+c.getNazwisko()+"' and data_urodzenia='"+c.getDataUrodzenia().PobierzDate()+"'");		
		//this.lista.remove(index);
		
	}
	
	public void UsunWszystko() throws SQLException {
		this.lista.clear();
		this.WyczyscTabele(Etabele.czytelnicy.toString());
	}
	
	public Cczytelnik ZnajdzCzytelnika(int numer) {	
		return this.lista.get( numer );
	}
	
	public int NumerCzytelnika(String Imie, String Nazwisko, Ckalendarz DataUrodzenia) {
		Iterator<Cczytelnik> it = this.lista.iterator();
		Cczytelnik c;
		int i = -1;
		int index = 0;
		
		while (it.hasNext()) {
			c = it.next();
			if ( c.PobierzImie().compareTo(Imie)==0 && c.PobierzNazwisko().compareTo(Nazwisko)==0 && c.PobierzDataUrodzenia().PobierzInstancje().compareTo(DataUrodzenia.PobierzInstancje())==0 )
				break;

			index++;			
		}
		i = index;	
		
		return i;
	}
	
	public String ListaCzytelnikow() throws SQLException {
		String s = "Lista czytelników:\n";
		/*
		 * z wykorzystaniem obiektów
		 * 
		Iterator<Cczytelnik> it = this.lista.iterator();
		int index = 1;
		
		while(it.hasNext()) {
			s = s + "[" + index + "] "+ it.next() + "\n"; 
			index++;
		}
		*/
		
		/*
		 * z wykorzystaniem bazy danych
		 */
		ResultSet rs = this.WykonajSelect("select * from "+Etabele.czytelnicy.toString());
		while(rs.next()) {
			s = s + "[" + rs.getInt("id") + "] "+ rs.getString("imie") +" " + rs.getString("nazwisko")+", data ur. "+rs.getString("data_urodzenia")+" - zapisany dnia "+rs.getString("data_zapisania")+ "\n"; 
		}
		
		return s;
	}
	
	public String toString() {
		String s = "";
		try {
			s = this.ListaCzytelnikow();
		}
		catch(Exception e) {
			s = "[B³¹d pobierania z bazy danych!] "+e.getMessage();
		}
		return s; 
	}
}
