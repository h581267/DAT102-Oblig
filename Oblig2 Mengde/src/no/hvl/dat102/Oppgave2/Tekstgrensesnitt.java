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

		MengdeADT hobbyer = new KjedetMengde();

		System.out.print("Skriv inn navn til medlem: ");
		String navn = tastatur.next();
		String hobby = "";

		while (!hobby.equals("avslutt")) {
			System.out.print("Skriv inn hobby (eller avslutt ved å skrive 'avslutt'): ");
			hobby = tastatur.next();
			Hobby h = new Hobby(hobby);
			if (!hobby.equals("avslutt")) {
				hobbyer.leggTil(h);
			}
		}

		Medlem m = new Medlem(navn, hobbyer);

		return m;
	}

	public static void skrivUtHobbyListe(Medlem medlem) {
		System.out.print(medlem.getNavn() + " sin liste over hobbyer " + medlem.getHobbyer().toString());
	}

	public static void skrivParListe(Datakontakt arkiv) {

	}
}