package no.hvl.dat102;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.koe.*;

public class Sortering {
	
	private static final int MIN = 10;

	public static void main(String[] args) {
		Integer[] tab = { 1, 6, 3, 5, 2, 7, 10, 9 };
		Integer[] tab2 = { 1, 6, 3, 5, 2, 7, 10, 9 };
		Integer[] tab3 = { 1, 6, 3, 5, 2, 7, 10, 9 };
		Integer[] tab4 = { 1, 6, 3, 5, 2, 7, 10, 9 };
		Integer[] tab5 = { 1, 6, 3, 5, 2, 7, 10, 9 };
		Integer[] tab6 = { 18, 622, 3219, 53, 2315122, 75136, 10 };
		Integer[] tab7 = { 18, 622, 3219, 53, 2315122, 75136, 10, 1923, 123, 1234, 142, 51351, 53115, 513123, 12312, 19 };

		System.out.println("Sortering innsetting");
		skrivUt(tab);
		SortInnsetting(tab);
		skrivUt(tab);
		System.out.println();

		System.out.println("Sortering utvalg");
		skrivUt(tab2);
		SortUtvalg(tab2);
		skrivUt(tab2);
		System.out.println();

		System.out.println("Bubble sort");
		skrivUt(tab3);
		bubbleSort(tab3);
		skrivUt(tab3);
		System.out.println();

		System.out.println("Kvikk sort");
		skrivUt(tab4);
		kvikkSort(tab4);
		skrivUt(tab4);
		System.out.println();

		System.out.println("Flette sort");
		skrivUt(tab5);
		fletteSort(tab5);
		skrivUt(tab5);
		System.out.println();

		System.out.println("Radix sort");
		skrivUt(tab6);
		radixSort(tab6);
		skrivUt(tab6);
		System.out.println();
		
		System.out.println("Alternativ kvikkSort");
		skrivUt(tab7);
		kvikkSortNy(tab7, 0, tab7.length-1);
		skrivUt(tab7);
		System.out.println();

	}

	// Sortering ved innsetting
	public static void SortInnsetting(Integer[] tab) {

		for (int i = 1; i < tab.length; i++) {
			Integer nokkel = tab[i];
			int j = i;
			while (j > 0 && tab[j - 1].compareTo(nokkel) > 0) {
				tab[j] = tab[j - 1];
				j--;
			}
			tab[j] = nokkel;
		}

	}

	// Sortering ved utvalg
	public static void SortUtvalg(Integer[] tab) {

		int minste;
		Integer temp;

		for (int i = 0; i < tab.length - 1; i++) {
			minste = i;
			for (int j = i + 1; j < tab.length; j++) {
				if (tab[j].compareTo(tab[minste]) < 0) {
					minste = j;
				}
			}
			temp = tab[minste];
			tab[minste] = tab[i];
			tab[i] = temp;
		}
	}

	// BubbleSortering
	public static void bubbleSort(Integer[] tab) {

		for (int j = tab.length; j > 0; j--) {
			for (int i = 0; i < j - 1; i++) {
				if (tab[i] > tab[i + 1]) {
					Integer temp = tab[i];
					tab[i] = tab[i + 1];
					tab[i + 1] = temp;
				}
			}
		}
	}

	// Kvikksortering
	public static void kvikkSort(Integer[] tab) {
		kvikkSort(tab, 0, tab.length - 1);
	}

	public static void kvikkSort(Integer[] tab, int min, int maks) {

		int posPartisjon;

		if (min < maks) {
			posPartisjon = finnPartisjon(tab, min, maks);

			kvikkSort(tab, min, posPartisjon - 1);
			kvikkSort(tab, posPartisjon + 1, maks);
		}
	}

	public static int finnPartisjon(Integer[] tab, int min, int maks) {
		int venstre, hoyre;
		Integer pivot;

		int midten = (min + maks) / 2;
		pivot = tab[midten];
		swap(tab, midten, min);

		venstre = min;
		hoyre = maks;

		while (venstre < hoyre) { // ytre løkke
			// Ser etter et element fra venstre som er større enn pivot
			while (venstre < hoyre && tab[venstre].compareTo(pivot) <= 0) {
				venstre++;
			}

			// Ser etter et element fra høyre som er mindre eller likt pivot
			while (tab[hoyre].compareTo(pivot) > 0) {
				hoyre--;
			}

			if (venstre < hoyre) {
				swap(tab, venstre, hoyre);
			}
		}

		swap(tab, min, hoyre);
		return hoyre;

	}

	public static void swap(Integer[] tab, int indeks1, int indeks2) {
		Integer temp = tab[indeks1];
		tab[indeks1] = tab[indeks2];
		tab[indeks2] = temp;
	}

	// Flettesortering
	public static void fletteSort(Integer[] tab) {
		fletteSort(tab, 0, tab.length - 1);
	}

	public static void fletteSort(Integer[] tab, int forste, int siste) {
		if (forste < siste) {
			int midten = (forste + siste) / 2;

			// Sorterer venstre havldel
			fletteSort(tab, forste, midten);

			// Sorterer høyre halvdel
			fletteSort(tab, midten + 1, siste);

			// Fletter de to sorterte delene
			fletteSort(tab, forste, midten, siste);
		}
	}

	public static void fletteSort(Integer[] tab, int forste, int midten, int siste) {
		int stor = siste - forste + 1;
		Integer[] tempTab = new Integer[stor];
		int forste1 = forste;
		int siste1 = midten;

		int forste2 = midten + 1;
		int siste2 = siste;

		int indeks = 0;

		while ((forste1 <= siste1) && (forste2 <= siste2)) {
			if (tab[forste1].compareTo(tab[forste2]) <= 0) {
				tempTab[indeks] = tab[forste1];
				forste1++;
			} else {
				tempTab[indeks] = tab[forste2];
				forste2++;
			}

			indeks++;
		}

		// Kopiere resten fra venstre side (kan være tom)
		while (forste1 <= siste1) {
			tempTab[indeks] = tab[forste1];
			forste1++;
			indeks++;
		}
		// Kopiere resten fra høyre side (kan være tom)
		while (forste2 <= siste2) {
			tempTab[indeks] = tab[forste2];
			forste2++;
			indeks++;
		}
		int j = 0;
		;
		for (indeks = forste; indeks <= siste; indeks++) {
			tab[indeks] = tempTab[j];
			j++;
		}

	}

	// Radix Sortering
	public static void radixSort(Integer[] tab) {
		String temp;
		Integer tallObj;
		int siffer, tall;
		int maxLengde = 0;
		KoeADT<Integer>[] koe = new TabellKoe[10];

		for (Integer t : tab) {
			String lengde = t + "";
			if (lengde.length() > maxLengde) {
				maxLengde = lengde.length();
			}
		}

		for (int s = 0; s <= 9; s++) {
			koe[s] = new TabellKoe<Integer>();
		}

		for (int i = 0; i < maxLengde; i++) {
			for (int j = 0; j < tab.length; j++) {
				temp = String.valueOf(tab[j]);

				while (temp.length() < maxLengde) {
					temp = "0" + temp;
				}

				siffer = Character.digit(temp.charAt(maxLengde - 1 - i), 10);
				koe[siffer].leggTil(tab[j]);
			}

			tall = 0;

			for (int sifferVerdi = 0; sifferVerdi <= 9; sifferVerdi++) {
				while (!(koe[sifferVerdi].erTom())) {
					tallObj = koe[sifferVerdi].slett();
					tab[tall] = tallObj.intValue();
					tall++;
				}
			}
		}
	}

	
	
	// Alternativ kvikksort
	public static void kvikkSortNy(Integer[] data, int min, int maks) {
		kvikkSort2(data, min, maks);
		sorteringVedInnsetting2(data, min, maks);
	}

	public static void kvikkSort2(Integer[] data, int min, int maks) {
		int posPartisjon;
		if (maks - min + 1 > MIN) {// antall elementer > MIN ? /** Lager partisjon */
			posPartisjon = finnPartisjon(data, min, maks);
			/** Sorterer venstre side */
			kvikkSort(data, min, posPartisjon - 1);
			/** Sorterer høyre side */
			kvikkSort(data, posPartisjon + 1, maks);
		}
	}// metode

	// Sortering ved innsetting av tabell[forste...siste] public static <T extends
	// Comparable<T>>
	public static void sorteringVedInnsetting2(Integer[] data, int forste, int siste) {
		for (int indeks = forste + 1; indeks <= siste; indeks++) {
			Integer nokkel = data[indeks];
			int p = indeks;
			// Forskyv større verdier mot høyre
			while (p > 0 && data[p - 1].compareTo(nokkel) > 0) {
				data[p] = data[p - 1];
				p--;
			}
			data[p] = nokkel;
		}
	}// metode

	
	
	
	
	
	// Metode for utskrift
	public static void skrivUt(Integer[] tab) {
		for (int i = 0; i < tab.length; i++) {
			System.out.print(tab[i] + " ");
		}
		System.out.println();
	}

}
