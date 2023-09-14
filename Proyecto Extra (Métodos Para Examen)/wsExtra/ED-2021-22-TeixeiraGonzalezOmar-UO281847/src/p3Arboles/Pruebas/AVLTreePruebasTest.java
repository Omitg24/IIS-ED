package p3Arboles.Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class AVLTreePruebasTest {
	/**
	 * Atributo t
	 */
	private AVLTreePruebas<Integer> t;
	
	/**
	 * Test del método padreDe general
	 */
	@Test
	public void padreDeTest() {
		t = new AVLTreePruebas<Integer>(); 
		assertEquals(0, t.addNode(10));
		assertEquals(0, t.addNode(4));
		assertEquals(0, t.addNode(3));
		assertEquals(0, t.addNode(8));
		assertEquals(0, t.addNode(9));
		assertEquals(0, t.addNode(12));
		assertEquals(0, t.addNode(13));
		assertEquals(0, t.addNode(11));
		assertEquals(0, t.addNode(14));
		assertEquals(0, t.addNode(1));
		assertEquals(0, t.addNode(2));
		assertEquals(0, t.addNode(20));
		assertEquals(0, t.addNode(18));
		assertEquals(0, t.addNode(16));
		assertEquals(9, t.padreDe(4));
		assertEquals(9, t.padreDe(12));
		assertEquals(2, t.padreDe(1));
		assertEquals(10, t.padreDe(11));
		System.out.println(t.toString());		
	}

	/**
	 * Test del método numAristas general
	 */
	@Test
	public void numAristasTest() {
		t = new AVLTreePruebas<Integer>(); 
		assertEquals(0, t.addNode(10));
		assertEquals(0, t.addNode(4));
		assertEquals(0, t.addNode(3));
		assertEquals(0, t.addNode(8));
		assertEquals(0, t.addNode(9));
		assertEquals(0, t.addNode(12));
		assertEquals(0, t.addNode(13));
		assertEquals(0, t.addNode(11));
		assertEquals(0, t.addNode(14));
		assertEquals(0, t.addNode(1));
		assertEquals(0, t.addNode(2));
		assertEquals(0, t.addNode(20));
		assertEquals(0, t.addNode(18));
		assertEquals(0, t.addNode(16));
		assertEquals(4, t.numAristas(9, 20));
		assertEquals(2, t.numAristas(9, 2));
		assertEquals(1, t.numAristas(2, 1));
		assertEquals(3, t.numAristas(9, 13));		
		System.out.println(t.toString());		
	}
	
	/**
	 * Test del método getHermano general
	 */
	@Test
	public void getHermanoTest() {
		t = new AVLTreePruebas<Integer>(); 
		assertEquals(0, t.addNode(10));
		assertEquals(0, t.addNode(4));
		assertEquals(0, t.addNode(3));
		assertEquals(0, t.addNode(8));
		assertEquals(0, t.addNode(9));
		assertEquals(0, t.addNode(12));
		assertEquals(0, t.addNode(13));
		assertEquals(0, t.addNode(11));
		assertEquals(0, t.addNode(14));
		assertEquals(0, t.addNode(1));
		assertEquals(0, t.addNode(2));
		assertEquals(0, t.addNode(20));
		assertEquals(0, t.addNode(18));
		assertEquals(0, t.addNode(16));
		assertEquals(0, t.addNode(24));
		assertEquals(null, t.getHermano(9));
		assertEquals(12, t.getHermano(4));
		assertEquals(4, t.getHermano(12));
		assertEquals(null, t.getHermano(24));
		assertEquals(1, t.getHermano(3));
		System.out.println(t.toString());		
	}
	
	/**
	 * Test de la media de los factores de balance
	 */
	@Test
	public void mediaBFTest() {
		t = new AVLTreePruebas<Integer>(); 
		assertEquals(0, t.addNode(10));
		assertEquals(0, t.addNode(4));
		assertEquals(0, t.addNode(3));
		assertEquals(0, t.addNode(8));
		assertEquals(0, t.addNode(9));
		assertEquals(0, t.addNode(12));
		assertEquals(0, t.addNode(13));
		assertEquals(0, t.addNode(11));
		assertEquals(0, t.addNode(14));
		assertEquals(0, t.addNode(1));
		assertEquals(0, t.addNode(2));
		assertEquals(0, t.addNode(20));
		assertEquals(0, t.addNode(18));
		assertEquals(0, t.addNode(16));
		assertEquals(0, t.addNode(24));
		assertEquals(0.2, t.mediaBF(), 0.001);
		assertEquals(0, t.addNode(40));
		assertEquals(0.125, t.mediaBF(), 0.001);
		System.out.println(t.toString());
	}
	
	/**
	 * Test del porcentaje de nodos intermedios
	 */
	@Test
	public void porcentajeIntermediosTest() {
		t = new AVLTreePruebas<Integer>(); 
		assertEquals(0, t.addNode(10));
		assertEquals(0, t.addNode(4));
		assertEquals(0, t.addNode(3));
		assertEquals(0, t.addNode(8));
		assertEquals(0, t.addNode(9));
		assertEquals(0, t.addNode(12));
		assertEquals(0, t.addNode(13));
		assertEquals(0, t.addNode(11));
		assertEquals(0, t.addNode(14));
		assertEquals(0, t.addNode(1));
		assertEquals(0, t.addNode(2));
		assertEquals(0, t.addNode(20));
		assertEquals(0, t.addNode(18));
		assertEquals(0, t.addNode(16));
		assertEquals(0, t.addNode(24));
		assertEquals(0, t.addNode(40));
		assertEquals(43.75, t.porcentajeNodosIntermedios(), 0.01);
		System.out.println(t.toString());
	}
	
	/**
	 * Test del camino
	 */
	@Test
	public void caminoTest() {
		t = new AVLTreePruebas<Integer>(); 
		assertEquals(0, t.addNode(10));
		assertEquals(0, t.addNode(4));
		assertEquals(0, t.addNode(3));
		assertEquals(0, t.addNode(8));
		assertEquals(0, t.addNode(9));
		assertEquals(0, t.addNode(12));
		assertEquals(0, t.addNode(13));
		assertEquals(0, t.addNode(11));
		assertEquals(0, t.addNode(14));
		assertEquals("9-12-13", t.camino(9, 13));
		assertEquals("9-4-3", t.camino(9, 3));
		System.out.println(t.toString());
	}
}
