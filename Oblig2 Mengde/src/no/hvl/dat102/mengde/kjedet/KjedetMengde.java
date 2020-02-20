package no.hvl.dat102.mengde.kjedet;

//********************************************************************
// Kjedet implementasjon av en mengde. 
//********************************************************************
import java.util.*;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.mengde.adt.*;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class KjedetMengde<T> implements MengdeADT<T> {
	private static Random rand = new Random();
	private int antall; // antall elementer i mengden
	private LinearNode<T> start;

	/**
	 * Oppretter en tom mengde.
	 */
	public KjedetMengde() {
		antall = 0;
		start = null;
	}//

	@Override
	public void leggTil(T element) {
		if (!(inneholder(element))) {
			LinearNode<T> node = new LinearNode<T>(element);
			node.setNeste(start);
			start = node;
			antall++;
		}
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			leggTil(teller.next());
		}
	}

	@Override
	public T fjernTilfeldig() {
		if (erTom())
			throw new EmptyCollectionException("mengde");

		LinearNode<T> forgjenger, aktuell;
		T resultat = null;

		int valg = rand.nextInt(antall) + 1;
		if (valg == 1) {
			resultat = start.getElement();
			start = start.getNeste();
		} else {
			forgjenger = start;
			for (int nr = 2; nr < valg; nr++) {
				forgjenger = forgjenger.getNeste();
			}
			aktuell = forgjenger.getNeste();
			resultat = aktuell.getElement();
			forgjenger.setNeste(aktuell.getNeste());
		}
		antall--;

		return resultat;

	}//

	@Override
	public T fjern(T element) {

		if (erTom())
			throw new EmptyCollectionException("mengde er tom");

		boolean slettet = false;
		LinearNode<T> forgjenger, aktuell;
		T resultat = null;
		aktuell = start;
		forgjenger = null;

		if (start.getElement().equals(element)) {
			resultat = start.getElement();
			start = start.getNeste();
			antall--;
			slettet = true;
		}

		while (!slettet && aktuell.getNeste() != null) {

			if (aktuell.getNeste().getElement().equals(element)) {
				resultat = aktuell.getNeste().getElement();
				aktuell.setNeste(aktuell.getNeste().getNeste());
				antall--;
				slettet = true;
			}
			aktuell = aktuell.getNeste();
		}

		return resultat;
	}//

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		LinearNode<T> aktuell = start;
		for (int soek = 0; soek < antall && !funnet; soek++) {
			if (aktuell.getElement().equals(element)) {
				funnet = true;
			} else {
				aktuell = aktuell.getNeste();
			}
		}
		return funnet;
	}

	@Override
	public boolean equals(Object m2) {

		if (m2 == this) {
			return true;
		}

		if (m2 == null || !(m2 instanceof KjedetMengde)) {
			return false;
		}

		boolean likeMengder = true;
		T element = null;
		KjedetMengde mengde2 = (KjedetMengde) m2;

		if (antall() == mengde2.antall()) {
			Iterator<T> itr = mengde2.oppramser();

			while (itr.hasNext() && likeMengder) {
				element = itr.next();
				if (!this.inneholder(element)) {
					likeMengder = false;
				}

			}

		} else {
			likeMengder = false;
		}

		return likeMengder;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		MengdeADT<T> begge = new KjedetMengde<T>();
		T element = null;
		LinearNode<T> aktuell = start;

		while (aktuell.getNeste() != null) {
			((KjedetMengde<T>) begge).settInn(aktuell.getElement());
			aktuell = aktuell.getNeste();
		}

		Iterator<T> it = m2.oppramser();
		while (it.hasNext()) {
			element = it.next();
			if (!begge.inneholder(element)) {
				((KjedetMengde<T>) begge).settInn(element);
			}
		}

		return begge;
	}//

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> snittM = new KjedetMengde<T>();
		T element = null;

		Iterator<T> it = m2.oppramser();
		while (it.hasNext()) {
			element = it.next();
			if (this.inneholder(element)) {
				((KjedetMengde<T>) snittM).settInn(element);
			}
		}

		return snittM;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> differensM = new KjedetMengde<T>();
		T element = null;

		Iterator<T> it = this.oppramser();
		while (it.hasNext()) {
			element = it.next();
			if (!m2.inneholder(element)) {
				((KjedetMengde<T>) differensM).settInn(element);
			}

		}
		return differensM;
	}

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;
		// Fyll ut
		return erUnderMengde;
	}

	@Override
	public Iterator<T> oppramser() {
		return new KjedetIterator<T>(start);
	}

	private void settInn(T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);
		nyNode.setNeste(start);
		start = nyNode;
		antall++;
	}

}// class
