package no.hvl.dat102.listeklient;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.tabell.TabellOrdnetListe;
import no.hvl.dat102.kjedet.KjedetOrdnetListe;
import no.hvl.dat102.koe.*;
import java.util.*;

public class KlientPerson {
	
	static Scanner tastatur = new Scanner(System.in);

	public static void main(String[] args) {

		
		KoeADT<Person> kjedetKoe = new KjedetKoe<Person>();
		kjedetKoe.leggTil(lesPerson());
		kjedetKoe.leggTil(lesPerson());
		
		KoeADT<Person>sirkulaerKoe = new SirkulaerKoe<Person>();
		sirkulaerKoe.leggTil(lesPerson());
		sirkulaerKoe.leggTil(lesPerson());
		
	
		System.out.println(kjedetKoe.slett());
	
	}
	
	public static Person lesPerson() {
		
		System.out.print("Skriv inn fornavn: ");
		String fornavn = tastatur.nextLine();
		System.out.print("Skriv inn etternavn: ");
		String etternavn = tastatur.nextLine();
		System.out.print("Skriv inn fødselsår: ");
		int år = Integer.parseInt(tastatur.nextLine());
		
		Person retur = new Person(fornavn, etternavn, år);
		return retur;
	}
}