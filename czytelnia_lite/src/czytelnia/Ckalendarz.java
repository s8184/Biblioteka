package czytelnia;

import java.util.Calendar;

public class Ckalendarz {
	private Calendar c;
	
	public Ckalendarz() {
		this.c = Calendar.getInstance();
	}
	
	public Ckalendarz(int year, int month, int day) {
		this.c = Calendar.getInstance();
		this.UstawDate(year, month, day);
	}
	
	public void UstawDate(int year, int month, int day) {
		this.c.set(year, month, day);	
	}
	
	public Calendar PobierzInstancje() {
		return this.c;
	}
	
	public String PobierzDate() {
		return this.c.get(Calendar.YEAR)+"-"+(this.c.get(Calendar.MONTH)+1)+"-"+this.c.get(Calendar.DAY_OF_MONTH);
	}
	
	public String PobierzDateCzas() {
		return this.PobierzDate() + " " +this.c.get(Calendar.HOUR_OF_DAY)+":"+this.c.get(Calendar.MINUTE);
	}

}
