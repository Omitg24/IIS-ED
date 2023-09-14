package p3Arboles.Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class BSTreePruebasTest {
	/**
	 * Atributo t
	 */
	private BSTreePruebas<Integer> t;
	
	@Test
	public void isAPETest() {
		t = new BSTreePruebas<Integer>(); 
		assertEquals(0, t.addNode(10));
		assertEquals(0, t.addNode(4));
		assertEquals(0, t.addNode(3));
		assertEquals(0, t.addNode(8));
		assertEquals(0, t.addNode(12));	
		assertEquals(0, t.addNode(13));
		assertEquals(0, t.addNode(11));
		assertTrue(t.isAPE());
		assertEquals(0, t.addNode(14));
		assertTrue(t.isAPE());
		assertEquals(0, t.addNode(15));		
		assertFalse(t.isAPE());
		assertEquals(0, t.addNode(2));
		assertTrue(t.isAPE());
		System.out.println(t.toString());		
	}
	
	@Test
	public void isAVLTest() {
		t = new BSTreePruebas<Integer>(); 
		assertEquals(0, t.addNode(10));
		assertEquals(0, t.addNode(4));
		assertEquals(0, t.addNode(3));
		assertEquals(0, t.addNode(8));
		assertEquals(0, t.addNode(12));	
		assertEquals(0, t.addNode(13));
		assertEquals(0, t.addNode(11));
		assertTrue(t.isAVL());
		assertEquals(0, t.addNode(14));
		assertTrue(t.isAVL());
		System.out.println(t.toString());		
	}
}
