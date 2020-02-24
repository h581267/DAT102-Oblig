package no.hvl.dat102.Oppgave2;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class KlientMedlem {

	
	public static void main(String[] args) {
		Hobby Java = new Hobby("Java");
		Hobby Spise = new Hobby("Spise");
		Hobby Tester = new Hobby("Tester");
		
		MengdeADT hobbyer1 = new KjedetMengde();
		MengdeADT hobbyer2 = new KjedetMengde();
		
		hobbyer1.leggTil(Spise);
		hobbyer2.leggTil(Java);
		hobbyer2.leggTil(Tester);
		
		Medlem m1 = new Medlem("Sebastian", hobbyer1);
		Medlem m2 = new Medlem("Erik", hobbyer2);
		Medlem m3 = new Medlem("Andreas", hobbyer2);
		
		Datakontakt d1 = new Datakontakt(10);
		d1.leggTilMedlem(m1);
		d1.leggTilMedlem(m2);
		d1.leggTilMedlem(m3);
		
		System.out.println(m1.passerTil(m2));
		System.out.println();
		System.out.println(m1.toString());
		System.out.println();
		System.out.println(m2.toString());
		
		System.out.println(d1.finnMedlemsIndeks("Sebastian"));
		System.out.println("Finner indeks for partner til Erik: " +  d1.finnPartnerFor("Erik"));
		
		System.out.println("Erik sin statusindeks: " +  m2.getStatusIndeks());
		System.out.println("Andreas sin statusindeks: " +  m3.getStatusIndeks());
		
		d1.tilbakestillStatusIndeks("Erik");
		
		System.out.println("Erik sin statusindeks etter reset: " +  m2.getStatusIndeks());
		System.out.println("Andreas sin statusindeks etter reset: " +  m3.getStatusIndeks());
		
	}
}
