package no.hvl.dat102.Rekursjon;

public class Oppgave1 {

	public static void main(String[] args) {
		System.out.println(sum(100));
		for (int i = 0; i <= 10; i++) {
			System.out.println(an(i));
		}
	}

	public static int sum(int n) {
		int resultat = 0;

		if (n > 1) {
			resultat = n + sum(n - 1);
			return resultat;
		} else {
			return n;
		}

	}

	public static int an(int n) {

		if (n == 0) {
			return 2;
		}
		if (n == 1) {
			return 5;
		} else {
			return (5 * an(n - 1) - 6 * an(n - 2) + 2);
		}

	}
	
	
}
