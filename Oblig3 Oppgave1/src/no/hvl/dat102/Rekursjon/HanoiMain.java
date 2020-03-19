package no.hvl.dat102.Rekursjon;

public class HanoiMain {

	public static void main(String[] args) {
		
		TowersOfHanoi tower1 = new TowersOfHanoi(16);
		TowersOfHanoi tower2 = new TowersOfHanoi(32);
		TowersOfHanoi tower3 = new TowersOfHanoi(64);
		
		tower1.solve();
		System.out.println();
		tower2.solve();
		System.out.println();
		tower3.solve();		

	}
	
}
