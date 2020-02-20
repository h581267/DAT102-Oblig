package no.hvl.dat102.Oppgave2;

public class Datakontakt {

	private Medlem[] tab;
	private int antall;

	public Datakontakt() {
		this(10);
	}

	public Datakontakt(int lengde) {
		tab = new Medlem[lengde];
		antall = 0;
	}

	public void leggTilMedlem(Medlem person) {
		if (antall >= tab.length) {
			utvid();
		}
		tab[antall] = person;
		antall++;
	}

	public void utvid() {
		Medlem[] ny = new Medlem[tab.length * 2];
		for (int i = 0; i < antall; i++) {
			ny[i] = tab[i];
		}
		tab = ny;
	}

	public int finnMedlemsIndeks(String medlemsnavn) {
		int indeks = -1;
		int i = 0;
		boolean funnet = false;
		while (i < antall && !funnet) {
			if (tab[i].getNavn() == medlemsnavn) {
				indeks = i;
				funnet = true;
			}
			i++;
		}

		return indeks;
	}

	public int finnPartnerFor(String medlemsnavn) {
		boolean funnet = false;
		int i = 0;
		int mIndeks = finnMedlemsIndeks(medlemsnavn);
		int m2Indeks = -1;
		Medlem m1 = null;
		
		if(mIndeks != -1) {
			m1 = tab[mIndeks];
			
			while(i < antall && !funnet) {
				if(m1.passerTil(tab[i]) && tab[i].getStatusIndeks() != -1) {
					m1.setStatusIndeks(i);
					tab[i].setStatusIndeks(mIndeks);
					funnet = true;
					
				}
				i++;
		}
		}
		return m2Indeks;
	}

	public void tilbakestillStatusIndeks(String medlemsnavn) {
		boolean funnet = false;
		int mIndeks = finnMedlemsIndeks(medlemsnavn);
		Medlem m1 = null;
		Medlem m2 = null;
		
		if(mIndeks != -1) {
			m1 = tab[mIndeks];
			
			if(m1.getStatusIndeks() != -1) {
			int m2Indeks = m1.getStatusIndeks();
			m2 = tab[m2Indeks];
			
			m1.setStatusIndeks(-1);
			m2.setStatusIndeks(-1);
			}
		}
	}
}
