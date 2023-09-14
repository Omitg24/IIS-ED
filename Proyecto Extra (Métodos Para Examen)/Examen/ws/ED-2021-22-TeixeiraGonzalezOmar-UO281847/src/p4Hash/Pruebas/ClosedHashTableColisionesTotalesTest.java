package p4Hash.Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import p4Hash.ClosedHashTable;

/**
 * Titulo: Clase ClosedHashTableColisionesTotalesTest
 *  
 * @author UO281847
 * @version 20/12/2021
 */
class ClosedHashTableColisionesTotalesTest {

	/**
	 * Prueba general del método add
	 */
	@Test
	public void probabilidadColisionTest() {
		ClosedHashTableColisionesTotales<Integer> h = new ClosedHashTableColisionesTotales<Integer>(8,1,0,ClosedHashTable.LINEAL);	
		assertEquals(0, h.add(0));
		assertEquals(0, h.add(0));
		assertEquals(0, h.add(2));
		assertEquals(0, h.add(8));
		assertEquals(0, h.find(0));
		assertEquals(0, h.add(1));		
		assertEquals(1, h.find(1));
		assertEquals(0, h.add(0));
		assertEquals(0, h.add(3));
		assertEquals(3, h.find(3));
		assertEquals(0, h.remove(0));
		assertEquals(0, h.remove(0));
		assertEquals(0, h.remove(0));
		assertEquals(18, h.getColisionesTotales());
		System.out.println(h.toString());
	}

}
