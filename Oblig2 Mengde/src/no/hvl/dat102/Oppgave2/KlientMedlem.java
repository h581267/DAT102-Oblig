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
		
		System.out.println(m1.passerTil(m2));
		System.out.println();
		System.out.println(m1.toString());
		System.out.println();
		System.out.println(m2.toString());
	}
}
