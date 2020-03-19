package no.hvl.dat102;

import java.util.Random;
import no.hvl.dat102.Sortering;

public class SortertStort {

	public static void main(String[] args) {
		Random tilfeldig = new Random();
		int n = 64000;
		int antal = 10;
		Integer[][] a = new Integer[antal][n];
		// set inn tilfeldige heiltal i alle rekker
		for (int i = 0; i < antal; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = tilfeldig.nextInt(100000);
			}
		}
		// sorter kvar rekke
		
		long start, finish, tid;
		// start tidsmåling
		
		start = System.currentTimeMillis();
		Sortering.SortInnsetting(a[0]);
		finish = System.currentTimeMillis();
		tid = finish - start; 
		System.out.println("Tid på Sortiering ved innsetting " + tid + " ms");
		
		start = System.currentTimeMillis();
		Sortering.SortUtvalg(a[1]);
		finish = System.currentTimeMillis();
		tid = finish - start;
		System.out.println("Tid på Sortiering ved utvalg " + tid + " ms");
		
		start = System.currentTimeMillis();
		Sortering.bubbleSort(a[2]);
		finish = System.currentTimeMillis();
		tid = finish - start;
		System.out.println("Tid på Sortiering ved bubbleSort " + tid + " ms");
		
		start = System.currentTimeMillis();
		Sortering.kvikkSort(a[3]);
		finish = System.currentTimeMillis();
		tid = finish - start;
		System.out.println("Tid på Sortiering ved kvikkSort " + tid + " ms");
		
		start = System.currentTimeMillis();
		Sortering.fletteSort(a[4]);
		finish = System.currentTimeMillis();
		tid = finish - start;
		System.out.println("Tid på Sortiering ved fletteSort " + tid + " ms");
		
		
		start = System.currentTimeMillis();
		Sortering.radixSort(a[5]);
		finish = System.currentTimeMillis();
		tid = finish - start;
		System.out.println("Tid på Sortiering ved radix " + tid + " ms");
		
	}

}
