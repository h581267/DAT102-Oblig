package no.hvl.dat102;

import java.io.*;
import no.hvl.dat102.kjedet.*;
import no.hvl.dat102.adt.*;
import no.hvl.dat102.exception.*;

public class Balansering {
	// Her opphever du kommentarsetning n�r du har f�tt lagt inn
	// n�dvendig kode
	StabelADT<Character> stabel;

	public Balansering() {
		stabel = new KjedetStabel<Character>();
	}

	private boolean passer(char åpent, char lukket) {
		switch (åpent) {
		case '(':
			return (lukket == ')');
		case '[':
			return (lukket == ']');
		case '{':
			return (lukket == '}');
		default:
			return false;
		}
	}//

	public void foretaBalansering(String innDataStreng, int linjenr) {

		int lengde = innDataStreng.length();
		int n = 0;

		while (lengde > n) {
			try {
			char c = innDataStreng.charAt(n);
			if (åpen(c)) {
				stabel.push(c);
			}
			if (lukket(c)) {
				//Feilmelding 1
				if (stabel.erTom()) {
					System.out.print("Stabelen er tom og inneholder flere paranteser vendt mot venstre, feilen ligger på linjenr: "+ linjenr);
				}
				char slutt = c;
				char start = stabel.pop();
				//Feilmelding 2
				if (!passer(start, slutt)) {
					System.out.println("Feilmelding: den er ikke balansert " + start + " og " + slutt + " hører ikke sammen, , feilen ligger på linjenr: " + linjenr);
					stabel.push(start);
					
				}

			}
		} catch (EmptyCollectionException e) {
			System.out.print("Stabelen er tom og inneholder flere paranteser vendt mot venstre, feilen ligger på linjenr: "+ linjenr);
		}
		n++;
		} 
	}//

	public void lesFraFil(String filnavn) {
		FileReader tekstFilLeser = null;
		try {
			tekstFilLeser = new FileReader(filnavn);
		} catch (FileNotFoundException unntak) {
			System.out.println("Finner ikke filen!");
			System.exit(-1);
		}

		BufferedReader tekstLeser = new BufferedReader(tekstFilLeser);
		String linje = null;
		int linjenr = 0;
		try {
			linje = tekstLeser.readLine();
			while (linje != null) {
				linjenr++;
				foretaBalansering(linje, linjenr);
				linje = tekstLeser.readLine();

			} // while

			// ... Fyll ut
			// ... Test p� om om det er flere elementer igjen p� stablen
			// ... t�mme stabelen
			// dvs. dersom vi mangler ett eller flere lukkesymboler

			// Feilmelding 3
			if (!stabel.erTom()) {
				System.out.println("Alle paranteser er ikke lukket, feilen ligger på linjenr: " + linjenr);
				while (!stabel.erTom()) {
					stabel.pop();
				}
			}
		}

		catch (IOException unntak) {
			System.out.println("Feil ved innlesing!");
			System.exit(-1);
		}
		try {
			tekstFilLeser.close();
		} catch (IOException unntak) {
			System.out.println("Feil ved lukking av fil!");
		}

	}

	public boolean åpen(Character c) {
		return (c.equals('(') || c.equals('{') || c.equals('['));
	}

	public boolean lukket(Character c) {
		return (c.equals(')') || c.equals('}') || c.equals(']'));

	}
}// class
