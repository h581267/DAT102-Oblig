package no.hvl.dat102.listeklient;

import java.util.Scanner;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.kjedet.KjedetOrdnetListe;
import no.hvl.dat102.koe.KjedetKoe;
import no.hvl.dat102.koe.SirkulaerKoe;
import no.hvl.dat102.tabell.TabellOrdnetListe;

public class KlientPersonOrdnet {

	static Scanner tastatur = new Scanner(System.in);

	public static void main(String[] args) {

		OrdnetListeADT<Person> liste = new KjedetOrdnetListe<Person>();
		Person p1 = lesPerson();
		Person p2 = lesPerson();
		Person p3 = lesPerson();
		
		liste.leggTil(p1);
		liste.leggTil(p2);
		liste.leggTil(p3);
		

		OrdnetListeADT<Person>tabListe = new TabellOrdnetListe<Person>();
		tabListe.leggTil(p1);
		tabListe.leggTil(p2);
		tabListe.leggTil(p3);
		
		System.out.println(tabListe.toString());
		System.out.println(liste.toString()); 

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
