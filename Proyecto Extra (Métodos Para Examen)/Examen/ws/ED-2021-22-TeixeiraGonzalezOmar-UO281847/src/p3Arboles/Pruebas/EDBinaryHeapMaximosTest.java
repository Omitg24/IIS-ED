package p3Arboles.Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Titulo: Clase ED EDBinaryHeapPruebasTest 
 * 
 * @author UO281847
 * @version 19/12/2021
 */
class EDBinaryHeapMaximosTest {
	/**
	 * Atributo m
	 */
	private EDBinaryHeapMaximos<Integer> m;
	
	/**
	 * Prueba del método add
	 */
	@Test
	public void addTest() {
		m = new EDBinaryHeapMaximos<Integer>(15);
		assertEquals(0, m.add(5));
		assertEquals(0, m.add(3));
		assertEquals(0, m.add(2));
		assertEquals(0, m.add(6));
		assertEquals(0, m.add(4));
		assertEquals(0, m.add(7));
		assertEquals(0, m.add(1));
		assertEquals(0, m.add(10));
		assertEquals(0, m.add(9));
		assertEquals(0, m.add(9));
		assertEquals(0, m.add(13));
		assertEquals(0, m.add(100));
		assertEquals(0, m.add(12));
		assertEquals(0, m.add(-1));
		assertEquals(0, m.add(6));
		System.out.println(m.toString());
	}
	
	/**
	 * Prueba del método remove
	 */
	@Test
	public void removeTest() {
		m = new EDBinaryHeapMaximos<Integer>(15);
		assertEquals(0, m.add(5));
		assertEquals(0, m.add(3));
		assertEquals(0, m.add(2));
		assertEquals(0, m.add(6));
		assertEquals(0, m.add(4));
		assertEquals(0, m.add(7));
		assertEquals(0, m.add(1));
		assertEquals(0, m.add(10));
		assertEquals(0, m.add(9));
		assertEquals(0, m.add(9));
		assertEquals(0, m.add(13));
		assertEquals(0, m.add(100));
		assertEquals(0, m.add(12));
		assertEquals(0, m.add(-1));
		assertEquals(0, m.add(6));
		assertEquals(0, m.remove(13));
		assertEquals(0, m.remove(100));
		assertEquals(0, m.remove(10));
		assertEquals(0, m.remove(9));
		assertEquals(0, m.remove(12));
		assertEquals(0, m.remove(9));
		assertEquals(0, m.remove(5));
		System.out.println(m.toString());
	}
}
