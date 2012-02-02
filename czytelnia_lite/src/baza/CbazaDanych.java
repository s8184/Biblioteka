package baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CbazaDanych {
	// baza plikowa
	private String url = "jdbc:hsqldb:file:baza_pliki/czytelnia;shutdown=true";
	
	// baza w pamiêci
	//private String url = "jdbc:hsqldb:mem:.";
	
	private Connection Polaczenie = null;
	
	public CbazaDanych() throws SQLException {
		this.Polaczenie = DriverManager.getConnection(url);
	}
	
	public boolean CzyTabelaIstnieje(String tabela) throws SQLException {
		ResultSet rs = this.Polaczenie.getMetaData().getTables(null, null, null, null);
		
		boolean istnieje = false;
		while (rs.next()) {
			if (rs.getString("TABLE_NAME").equalsIgnoreCase(tabela)) {
				istnieje = true;
				break;
			}
		}
		return istnieje;
	}
	
	public void StworzTabele(String definicja) throws SQLException {
		Statement s = this.Polaczenie.createStatement();
		s.executeUpdate(definicja);
	}
	
	public void UsunTabele(String tabela) throws SQLException {
		this.WykonajInsert("drop table "+tabela);
	}	
	
	public void WyczyscTabele(String tabela) throws SQLException {
		this.WykonajInsert("truncate table "+tabela);
	}	
	
	
	public void WykonajInsert(String zapytanie) throws SQLException {
		Statement s = this.Polaczenie.createStatement();
		s.execute(zapytanie);
	}
	
	public void WykonajDelete(String zapytanie) throws SQLException {
		this.WykonajInsert(zapytanie);
	}
	
	public ResultSet WykonajSelect(String zapytanie) throws SQLException {
		Statement s = this.Polaczenie.createStatement();
		return s.executeQuery(zapytanie);
	}
	
	public void ZamknijPolaczenie() throws SQLException {
		Statement s = this.Polaczenie.createStatement();
		s.execute("SHUTDOWN");
	}
	
}
