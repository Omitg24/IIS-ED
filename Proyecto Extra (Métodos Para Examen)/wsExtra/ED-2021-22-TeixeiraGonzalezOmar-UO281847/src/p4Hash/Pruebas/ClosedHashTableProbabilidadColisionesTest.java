package p4Hash.Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import p4Hash.ClosedHashTable;

/**
 * Titulo: Clase ClosedHashTableProbabilidadColisionesTest
 * 
 * @author UO281847
 * @version 19/12/2021
 */
class ClosedHashTableProbabilidadColisionesTest {

	/**
	 * Prueba general del método add
	 */
	@Test
	public void probabilidadColisionTest() {
		ClosedHashTableProbabilidadColisiones<Integer> h = new ClosedHashTableProbabilidadColisiones<Integer>(8,1,0,ClosedHashTable.LINEAL);	
		assertEquals(0, h.add(0));
		assertEquals(0, h.add(0));
		assertEquals(0.5, h.getProbabilidadColision(), 0.01);
		assertEquals(0, h.add(0));
		assertEquals(0.66, h.getProbabilidadColision(), 0.01);
		assertEquals(0, h.add(2));
		assertEquals(0.0, h.getProbabilidadColision(), 0.01);
		assertEquals(0, h.add(8));
		assertEquals(0.0, h.getProbabilidadColision(), 0.01);
		assertEquals(0, h.add(3));
		assertEquals(0.5, h.getProbabilidadColision(), 0.01);
		System.out.println(h.toString());
	}
}
