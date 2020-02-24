package no.hvl.dat102.TabellMengde;

import no.hvl.dat102.mengde.tabell.*;
import no.hvl.dat102.mengde.adt.*;
import no.hvl.dat102.adt.*;


public class TabellMengdeTest extends MengdeADTTest {

	@Override
	protected MengdeADT<Integer> reset(){
		return new TabellMengde<Integer>();
	}

}
