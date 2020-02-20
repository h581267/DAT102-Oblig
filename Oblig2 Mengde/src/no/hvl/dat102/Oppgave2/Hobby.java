package no.hvl.dat102.Oppgave2;

public class Hobby {
	private String hobbyNavn;

	public Hobby(String hobby) {
		hobbyNavn = hobby;
	}
	
	public String getHobbyNavn() {
		return hobbyNavn;
	}

	public String toString(){
		return "<" + hobbyNavn + ">";
      }

	public boolean equals(Object hobby2){ //
		Hobby hobbyDenAndre = (Hobby)hobby2; 
		return(hobbyNavn.equals(hobbyDenAndre.getHobbyNavn()));
     }
	
}