package KjedetOrdnetListeTest;

import no.hvl.dat102.adt.OrdnetListeADT;
import adt.OrdnetListeADTTest;
import no.hvl.dat102.kjedet.KjedetOrdnetListe;



public class KjedetOrdnetListeTest extends  OrdnetListeADTTest{
	   @Override
		protected OrdnetListeADT<Integer> reset() {
			return new KjedetOrdnetListe<Integer>();
		}		
}