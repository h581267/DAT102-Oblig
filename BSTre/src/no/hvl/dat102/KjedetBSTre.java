package no.hvl.dat102;

import java.util.Iterator;

import no.hvl.dat102.adt.BSTreADT;

//********************************************************************
// KjedetBin�rS�keTre.java        
//
//********************************************************************

public class KjedetBSTre<T extends Comparable<T>> implements BSTreADT<T>, Iterable<T> {

	private int antall;
	private BinaerTreNode<T> rot;

	/******************************************************************
	 * Oppretter et tomt bin�rt s�ketre.
	 ******************************************************************/
	public KjedetBSTre() {
		antall = 0;
		rot = null;
	}

	/******************************************************************
	 * Oppretter et bin�rt s�ketre med en node..
	 ******************************************************************/
	public KjedetBSTre(T element) {
		rot = new BinaerTreNode<T>(element);
		antall = 1;
	}

	/*****************************************************************
	 * Returnerer sann hvis dette bin�re trett er tomt og usann ellers.
	 *****************************************************************/
	public int antall() {
		return antall;
	}

	/*****************************************************************
	 * Returnerer sann hvis dette bin�re treet er tom og usann ellers.
	 *****************************************************************/
	public boolean erTom() {
		return (antall == 0);
	}

	/**********************************************************************
	 * Legger det spesifiserte elementet p� passende plass i BS-treet. Like
	 * elementer blir lagt til h�yre. Bruk av rekursiv hjelpemetode.
	 ********************************************************************/
	public void leggTil(T element) {
		rot = leggTilRek(rot, element);
		antall++;
	}

	private BinaerTreNode<T> leggTilRek(BinaerTreNode<T> p, T element) {

		if (p == null) {
			p = new BinaerTreNode<T>(element);
			return p;
		}

		if (element.compareTo(p.getElement()) < 0) {
			p.setVenstre(leggTilRek(p.getVenstre(), element));
		} else if (element.compareTo(p.getElement()) >= 0) {
			p.setHoyre(leggTilRek(p.getHoyre(), element));
		}

		return p;
	}

	/******************************************************************
	 * Legger det spesifiserte elementet p� passende plass i dette bin�re s�ketreet.
	 * Like elementer blir lagt til h�yre.
	 ******************************************************************/

	public void leggTil2(T element) {
		//
	}

	
	/******************************************************************
	 * Fjerner noden med minste verdi fra dette bin�re s�ketreet.
	 *********************************************************************/
	public T fjernMin() {

        T svar = null;
        BinaerTreNode<T> temp = rot;
        BinaerTreNode<T> forrige = rot;

        if(rot.getVenstre() == null) {
            svar = rot.getElement();
            rot = rot.getHoyre();
        }else {

        while (temp.getVenstre() != null) {
            forrige = temp;
            temp = temp.getVenstre();
        } 
        svar = temp.getElement();
        if (temp.getHoyre() != null) {
            forrige.setVenstre(temp.getHoyre());
        }else {
            forrige.setVenstre(null);        }
        }
         
        return svar;
    }

	/******************************************************************
	 * Fjerner noden med st�rste verdi fra dette bin�re s�ketreet.
	 ******************************************************************/
	public T fjernMaks() {
		// TODO
		return null;
	}//

	/******************************************************************
	 * Returnerer det minste elementet i dette bin�re s�ketreet.
	 ******************************************************************/
	public T finnMin() {
		BinaerTreNode<T> temp = rot;
		while (temp.getVenstre().getElement() != null) {
			temp = temp.getVenstre();
		}
		return temp.getElement();
	}

	/******************************************************************
	 * Returnerer det st�rste elementet i dette bin�re s�ketreet.
	 ******************************************************************/
	public T finnMaks() {
		BinaerTreNode<T> temp = rot;
		while (temp.getHoyre().getElement() != null) {
			temp = temp.getHoyre();
		}
		return temp.getElement();
	}//

	/*******************************************************************************
	 * Returnerer en referanse til det spesifiserte elementet hvis det finst i dette
	 * BS-treet, null ellers. Bruk av rekursjon /
	 ******************************************************************************/
	public T finn(T element) {
		return finnRek(rot, element);
	}

	private T finnRek(BinaerTreNode<T> p, T element) {
		if (p.getElement() == element) {
			return p.getElement();
		} else if (element.compareTo(p.getElement()) < 0) {
			if (p.getVenstre() != null) {
				return finnRek(p.getVenstre(), element);
			}
			return null;
		} else {
			if (p.getHoyre() != null) {
				return finnRek(p.getHoyre(), element);
			}
			return null;
		}
	}

	// TODO

	/************************************************************************
	 * Returnerer en referanse til det spesifiserte elementet hvis det fins i dette
	 * BS-treet, null ellers. Uten bruk av rekursjon. /
	 ************************************************************************/
	public T finn2(T element) {
		// TODO
		return null;
	}

	public void visInorden() {
		visInorden(rot);
		System.out.println();
	}

	private void visInorden(BinaerTreNode<T> p) {
		if (p != null) {
			visInorden(p.getVenstre());
			System.out.print(" " + p.getElement());
			visInorden(p.getHoyre());
		}
	}

	public int finnHøyde() {
		return finnHøydeRek(rot);
	}

	private int finnHøydeRek(BinaerTreNode<T> p) {
		if (rot == null) {
			return -1;
		}
		if (p == null) {
			return 0;
		}

		int vhøyde = finnHøydeRek(p.getVenstre());
		int hhøyde = finnHøydeRek(p.getHoyre());

		return Math.max(vhøyde, hhøyde) + 1;
	}

	public int teoretiskMin() {
		return (int) (Math.log(antall) / Math.log(2));
	}

	@Override
	public Iterator<T> iterator() {
		return new InordenIterator<T>(rot);

	}
}// class
