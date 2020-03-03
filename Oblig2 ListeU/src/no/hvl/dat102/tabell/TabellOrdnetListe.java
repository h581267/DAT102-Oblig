package no.hvl.dat102.tabell;

import no.hvl.dat102.exceptions.EmptyCollectionException;
import no.hvl.dat102.adt.OrdnetListeADT;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {

	private final static int STDK = 100;
	private final static int IKKE_FUNNET = -1;
	private int bak;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		bak = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");
		T resultat = liste[bak-1];
		bak--;

		return resultat;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[0];
		for (int i = 0; i < bak - 1; i++) {
			liste[i] = liste[i + 1];
		}
		bak--;

		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[0];
		return resultat;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[bak-1];

		return resultat;
	}

	@Override
	public boolean erTom() {
		return (bak == 0);
	}

	@Override
	public int antall() {
		return bak;
	}

	@Override
	public void leggTil(T element) {

		if (erTom()) {
			liste[0] = element;
			bak++;
		}

		else {

			if (bak >= liste.length) {
				utvid();
			}

			boolean lagtTil = false;
			int i = 0;

			while (i < bak && !lagtTil) {
				if (liste[i].compareTo(element) >= 0) {
					bak++;
					for (int j = bak; j > i; j--) {
						liste[j] = liste[j - 1];
					}
					liste[i] = element;
					lagtTil = true;
				}
				i++;
			}
			if(!lagtTil) {
				liste[bak] = element;
				bak++;
			}
		}
	}

	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	@Override
	public T fjern(T element) {

		int indeks = finn(element);

		if (indeks != -1) {
			for (int i = indeks; i < bak - 1; i++) {
				liste[i] = liste[i + 1];
			}
			liste[bak] = null;
			bak--;

			return element;
		}
		return null;

	}

	private int finn(T el) {
		int i = 0, resultat = IKKE_FUNNET;

		while (resultat == IKKE_FUNNET && i < bak) {
			if (liste[i].equals(el)) {
				resultat = i;
			}
			i++;
		}

		return resultat;
	} 

	public String toString() {
		String resultat = "";

		for (int i = 0; i < bak; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}
		return resultat;
	}

	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

		for (int i = 0; i < liste.length; i++) {
			hjelpeTabell[i] = liste[i];
		}

		liste = hjelpeTabell;
	}

}// class