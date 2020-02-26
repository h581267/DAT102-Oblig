package no.hvl.dat102.Oppgave2;

import java.util.*;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class Tekstgrensesnitt {

	public Tekstgrensesnitt() {

	}

	// Klasse for inn/ut terminal
	// Hvis du vil lage meny kan du også legge det inn i Tekstgrensesnitt
	// leser opplysningene om et medlem fra tastaturpublic static

	public Medlem lesMedlem() {
		Scanner tastatur = new Scanner(System.in);

		MengdeADT<Hobby> hobbyer = new KjedetMengde<Hobby>();

		System.out.print("Skriv inn navn til medlem: ");
		String navn = tastatur.next();
		String hobby = "";

		while (!hobby.equals("stopp")) {
			System.out.print("Skriv inn hobby (eller avslutt ved å skrive 'stopp'): ");
			hobby = tastatur.next();
			Hobby h = new Hobby(hobby);
			if (!hobby.equals("stopp")) {
				hobbyer.leggTil(h);
			}
		}

		Medlem m = new Medlem(navn, hobbyer);

		return m;
	}

	public static void skrivUtHobbyListe(Medlem medlem) {

		Iterator<Hobby> itr = medlem.getHobbyer().oppramser();
		System.out.print("<" + itr.next());
		while (itr.hasNext()) {
			System.out.print(", " + itr.next());
		}
		System.out.print(">");
	}

	public static void skrivParListe(Datakontakt arkiv) {
		Medlem[] tab = arkiv.getMedlemTab();
		for (int i = 0; i < arkiv.getAntall(); i++) {
			int indeks = arkiv.finnPartnerFor(tab[i].getNavn());
			if (indeks >= 0 && i != indeks && tab[indeks].getStatusIndeks() < tab[i].getStatusIndeks()) {
				System.out.print(tab[i].getNavn() + " macher med " + tab[indeks].getNavn() + " og deres hobbyer er: ");
				skrivUtHobbyListe(tab[i]);
			}
		}
	}
}