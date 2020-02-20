package no.hvl.dat102.Oppgave2;

import no.hvl.dat102.mengde.adt.MengdeADT;

public class Medlem {

	private String navn;
	private MengdeADT<Hobby> hobbyer; 
	private int statusIndeks;
	
	public Medlem(String navn, MengdeADT<Hobby> hobbyer) {
		this.navn = navn;
		this.hobbyer = hobbyer;
		this.statusIndeks = -1;
	}
	
	public String getNavn() {
		return navn;
	}
	
	public void setNavn(String navn) {
		this.navn = navn;
	}

	public MengdeADT<Hobby> getHobbyer() {
		return hobbyer;
	}

	public void setHobbyer(MengdeADT<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
	}

	public int getStatusIndeks() {
		return statusIndeks;
	}

	public void setStatusIndeks(int statusIndeks) {
		this.statusIndeks = statusIndeks;
	}
	
	public boolean passerTil(Medlem medlem2) {
		return (hobbyer.equals(medlem2.hobbyer)); 
	}
	
	public String toString() {
		return navn + ", " + hobbyer.toString() + "\nStatusindeks:" + statusIndeks;
	}
}
