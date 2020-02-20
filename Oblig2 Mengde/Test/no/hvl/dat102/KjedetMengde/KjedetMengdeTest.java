package no.hvl.dat102.KjedetMengde;

import static org.junit.Assert.*;
import org.junit.jupiter.api.*;
import org.junit.Test;

import org.junit.Before;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.mengde.kjedet.*;
import no.hvl.dat102.mengde.adt.*;
import no.hvl.dat102.adt.*;

public class KjedetMengdeTest extends MengdeADTTest {

	@Override
	protected MengdeADT<Integer> reset(){
		return new KjedetMengde<Integer>();
	}
	

}
