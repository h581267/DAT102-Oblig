package no.hvl.dat102.adt;

import static org.junit.Assert.*;
import org.junit.jupiter.api.*;
import org.junit.Test;

import org.junit.Before;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.mengde.adt.*;

public abstract class MengdeADTTest {

	
	private MengdeADT<Integer> m1;
	private MengdeADT<Integer> m2;
	private MengdeADT<Integer> fasit;
	
	
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	
	protected abstract MengdeADT<Integer> reset(); 
	
	@Before
	public final void setup() {
		m1 = reset();
		m2 = reset();
		fasit = reset();
	}
	
	@Test
	public final void unionTest() {
		
		m1.leggTil(e0);
		m1.leggTil(e1);
		m1.leggTil(e2);
		
		m2.leggTil(e2);
		m2.leggTil(e3);
		m2.leggTil(e4);
	
		fasit.leggTil(e0);
		fasit.leggTil(e1);
		fasit.leggTil(e2);
		fasit.leggTil(e3);
		fasit.leggTil(e4);
		
		fasit.equals(m1.union(m2));
	}
	
	@Test
	public final void snittTest() {
		
		m1.leggTil(e0);
		m1.leggTil(e1);
		m1.leggTil(e2);
		
		m2.leggTil(e2);
		m2.leggTil(e3);
		m2.leggTil(e4);
	
		
		fasit.leggTil(e2);
		
		
		fasit.equals(m1.snitt(m2));
	}
	
	@Test
	public final void differensTest() {
		
		m1.leggTil(e0);
		m1.leggTil(e1);
		m1.leggTil(e2);
		
		m2.leggTil(e2);
		m2.leggTil(e3);
		m2.leggTil(e4);
	
		
		fasit.leggTil(e0);
		fasit.leggTil(e1);
		
		
		fasit.equals(m1.snitt(m2));
	}

}
