package p3Arboles.Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EDBinaryHeapPruebasTest {
	/**
	 * Atributo m
	 */
	private EDBinaryHeapPruebas<Integer> m;
	
	/**
	 * Prueba del metodo devolverMaximo
	 */
	@Test
	public void maxTest() {
		m = new EDBinaryHeapPruebas<Integer>(15);
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
		assertEquals(100, m.devolverMaximo());
		assertEquals(0, m.remove(100));
		assertEquals(13, m.devolverMaximo());
		assertEquals(0, m.remove(13));
		assertEquals(12, m.devolverMaximo());
		assertEquals(0, m.remove(12));
		assertEquals(10, m.devolverMaximo());
		System.out.println(m.toString());
	}

	/**
	 * Pruebas de los recorridos
	 */
	@Test
	public void recorridosTest() {
		m = new EDBinaryHeapPruebas<Integer>(15);
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
		assertEquals("-1-4-6-10-9-5-9-13-1-7-100-12-2-3-6-", m.preOrder());
		assertEquals("10-6-9-4-9-5-13--1-100-7-12-1-3-2-6-", m.inOrder());
		assertEquals("10-9-6-9-13-5-4-100-12-7-3-6-2-1--1-", m.postOrder());
		System.out.println(m.toString());
	}
}
