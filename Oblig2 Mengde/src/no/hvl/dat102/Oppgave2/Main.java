package no.hvl.dat102.Oppgave2;

public class Main {

	public static void main(String[] args) {
		
		Tekstgrensesnitt t1 = new Tekstgrensesnitt();
		Datakontakt d1 = new Datakontakt(10);
		d1.leggTilMedlem(t1.lesMedlem());
		d1.leggTilMedlem(t1.lesMedlem());
		d1.leggTilMedlem(t1.lesMedlem());
	
		System.out.println();
		
		t1.skrivParListe(d1);
		
		System.out.println();
		
		System.out.println("Utskrift etter innlesning av alle medlemmer");
		d1.skrivUt();

		
		
	}

}
