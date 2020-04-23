package no.hvl.dat102.klient;

import java.util.*;

import javax.swing.JOptionPane;

import no.hvl.dat102.KjedetBSTre;

public class MainOppgave2b {

	public static void main(String[] args) {

		Random terning = new Random();
		KjedetBSTre<Integer> bstre = null;
		
		int antallNoder = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn antall noder: "));
		int antallTrær = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn antall trær: "));
		int minlengde = antallNoder;
		int maxlengde = 0;
		int total = 0;
		
		
		for (int i = 1; i <= antallTrær; i++) {
			bstre = new KjedetBSTre<Integer>();
			for (int j = 1; j <= antallNoder; j++) {
				int tall = terning.nextInt(101);
				bstre.leggTil(tall);				
			}
			int høyde = bstre.finnHøyde();
			
			if(minlengde > høyde) {
				minlengde = høyde;
			}
			if(maxlengde < høyde) {
				maxlengde = høyde;
			}
			total += høyde;
		}

		System.out.println("Antall noder:" + bstre.antall());
		System.out.println("Minimale teoretiske hoyde:" + bstre.teoretiskMin());
		System.out.println("Maksimal høyde: " + bstre.antall());
		System.out.println("Maks høyde: " + maxlengde);
		System.out.println("Min høyde: " + minlengde);
		System.out.println("Snitt høyde: " + total/antallTrær);


	}

}
