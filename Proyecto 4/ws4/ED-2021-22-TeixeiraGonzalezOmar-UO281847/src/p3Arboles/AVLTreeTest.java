package p3Arboles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Titulo: Clase AVLTreeTest
 * 
 * @author UO281847
 * @version 05/11/2021
 */
class AVLTreeTest {
	/**
	 * Atributo t
	 */
	private AVLTree<Integer> t;

/*
 * Pruebas del método addNode
 */
	/**
	 * Test del método addNode general
	 */
	@Test
	public void addNodeGeneralTest() {
		t = new AVLTree<Integer>(); 
		assertEquals(0, t.addNode(10));
		assertEquals(-1,t.addNode(10));
		assertEquals(0, t.addNode(4));
		assertEquals(0, t.addNode(3));
		assertEquals(0, t.addNode(8));
		assertEquals(0, t.addNode(9));
		assertEquals(0, t.addNode(12));		
		assertEquals(-1,t.addNode(3));
		assertEquals(-2, t.addNode(null));
		assertEquals(0, t.addNode(13));
		assertEquals(0, t.addNode(11));
		assertEquals(-1, t.addNode(11));
		assertEquals(-1, t.addNode(12));
		assertEquals(-1, t.addNode(13));
		assertEquals(-2, t.addNode(null));
		assertEquals(0, t.addNode(14));
		assertEquals(-1, t.addNode(14));
		assertEquals(-1, t.addNode(14));
		assertEquals(-2, t.addNode(null));
		assertEquals(0, t.addNode(1));
		assertEquals(0, t.addNode(2));
		assertEquals(0, t.addNode(20));
		assertEquals(-1, t.addNode(20));
		assertEquals(-2, t.addNode(null));
		assertEquals(0, t.addNode(18));
		assertEquals(0, t.addNode(16));
		assertEquals(-1, t.addNode(16));		
		assertEquals(-1, t.addNode(16));
		assertEquals(0, t.addNode(21));
		assertEquals(-2, t.addNode(null));
		assertEquals(0, t.addNode(22));
		assertEquals(0, t.addNode(23));
		assertEquals(-1, t.addNode(23));
		assertEquals(0, t.addNode(24));
		assertEquals(-1, t.addNode(23));
		assertEquals(0, t.addNode(25));
		assertEquals(-2, t.addNode(null));
		System.out.println(t.toString());		
	}
	/**
	 * Test del método addNode con rotacion a la izquierda
	 */
	@Test
	public void addNodeLeftTest() {
		t = new AVLTree<Integer>(); 
		assertEquals(0, t.addNode(10));
		assertEquals(0, t.addNode(9));
		assertEquals(0, t.addNode(8));
		assertEquals(0, t.addNode(7));
		assertEquals(0, t.addNode(6));
		assertEquals(0, t.addNode(5));
		assertEquals(0, t.addNode(4));
		assertEquals(0, t.addNode(3));
		assertEquals(0, t.addNode(2));
		assertEquals(0, t.addNode(1));		
		System.out.println(t.toString());		
	}
	/**
	 * Test del método addNode con rotacion a la derecha
	 */
	@Test
	public void addNodeRightTest() {
		t = new AVLTree<Integer>();
		assertEquals(0, t.addNode(1));
		assertEquals(0, t.addNode(2));
		assertEquals(0, t.addNode(3));
		assertEquals(0, t.addNode(4));
		assertEquals(0, t.addNode(5));
		assertEquals(0, t.addNode(6));
		assertEquals(0, t.addNode(7));
		assertEquals(0, t.addNode(8));
		assertEquals(0, t.addNode(9));
		assertEquals(0, t.addNode(10));				
		System.out.println(t.toString());		
	}
	/**
	 * Test del método addNode con rotacion doble a la izquierda
	 */
	@Test
	public void addNodeDoubleLeftTest() {
		t = new AVLTree<Integer>();
		assertEquals(0, t.addNode(10));
		assertEquals(0, t.addNode(1));
		assertEquals(0, t.addNode(2));
		assertEquals(0, t.addNode(3));
		assertEquals(0, t.addNode(4));
		assertEquals(0, t.addNode(5));
		assertEquals(0, t.addNode(6));
		assertEquals(0, t.addNode(7));
		assertEquals(0, t.addNode(8));
		assertEquals(0, t.addNode(9));
		System.out.println(t.toString());		
	}
	/**
	 * Test del método addNode con rotacion doble a la izquierda
	 */
	@Test
	public void addNodeDoubleRightTest() {
		t = new AVLTree<Integer>();
		assertEquals(0, t.addNode(1));
		assertEquals(0, t.addNode(10));
		assertEquals(0, t.addNode(9));
		assertEquals(0, t.addNode(8));
		assertEquals(0, t.addNode(7));
		assertEquals(0, t.addNode(6));
		assertEquals(0, t.addNode(5));
		assertEquals(0, t.addNode(4));
		assertEquals(0, t.addNode(3));
		assertEquals(0, t.addNode(2));
		System.out.println(t.toString());		
	}

/*
 * Prueba del método searchNode:
 */
	/**
	 * Test del método searchNode
	 */
	@Test
	public void searchTest() {
		t = new AVLTree<Integer>();
		assertNull(t.searchNode(10));
		assertEquals(0, t.addNode(10));
		assertEquals(10, t.searchNode(10));
		assertEquals(0, t.addNode(4));
		assertEquals(0, t.addNode(3));
		assertEquals(0, t.addNode(8));
		assertEquals(0, t.addNode(9));
		assertEquals(0, t.addNode(12));	
		assertNull(t.searchNode(14));
		assertNull(t.searchNode(5));
		assertEquals(10, t.searchNode(10));
		assertEquals(4, t.searchNode(4));
		assertEquals(3, t.searchNode(3));
		assertNull(t.searchNode(14));
		assertNull(t.searchNode(5));
		assertEquals(8, t.searchNode(8));
		assertEquals(9, t.searchNode(9));
		assertEquals(12, t.searchNode(12));		
		assertNull(t.searchNode(1));
		assertNull(t.searchNode(1));
		assertNull(t.searchNode(5));
		assertNull(t.searchNode(0));
		System.out.println(t.toString());		
	}
	
	/**
	 * Test del método searchNode con Strings
	 */
	@Test
	public void searchStringTest() {
		BSTree<String> t = new AVLTree<String>();
		assertNull(t.searchNode("A"));
		assertEquals(0, t.addNode("A"));
		assertEquals("A", t.searchNode("A"));
		assertEquals(0, t.addNode("B"));
		assertNull(t.searchNode(null));
		assertEquals(-1, t.addNode("A"));
		assertEquals(0, t.addNode("C"));
		assertEquals(0, t.addNode("D"));
		assertEquals("D", t.searchNode("D"));
		assertNull(t.searchNode("E"));
		assertEquals(0, t.addNode("E"));
		assertNull(t.searchNode(null));
		System.out.println(t.toString());		
	}
	
/*
 * Pruebas del método removeNode
 */
	/**
	 * Test del método removeNode general
	 */
	@Test
	public void removeNodeGeneralTest() {
		t = new AVLTree<Integer>(); 
		assertEquals(-1, t.removeNode(10));
		assertEquals(0, t.addNode(10));	
		assertEquals(0, t.removeNode(10));
		assertEquals(-1, t.removeNode(10));
		assertEquals(-2, t.removeNode(null));
		assertEquals(0, t.addNode(4));
		assertEquals(0, t.addNode(3));
		assertEquals(0, t.addNode(8));
		assertEquals(0, t.addNode(9));
		assertEquals(0, t.removeNode(9));
		assertEquals(0, t.addNode(12));
		assertEquals(-2, t.removeNode(null));
		assertEquals(0, t.addNode(13));
		assertEquals(0, t.addNode(11));
		assertEquals(-1, t.removeNode(9));
		assertEquals(0, t.addNode(14));
		assertEquals(0, t.addNode(1));
		assertEquals(0, t.removeNode(1));
		assertEquals(0, t.addNode(1));
		assertEquals(0, t.removeNode(1));
		assertEquals(-1, t.removeNode(1));
		assertEquals(0, t.addNode(1));
		assertEquals(0, t.addNode(2));
		assertEquals(0, t.removeNode(4));
		assertEquals(0, t.addNode(20));
		assertEquals(0, t.addNode(18));
		assertEquals(-2, t.removeNode(null));
		assertEquals(0, t.removeNode(12));
		assertEquals(-1, t.removeNode(12));
		assertEquals(0, t.addNode(16));
		assertEquals(0, t.addNode(21));
		assertEquals(-1, t.removeNode(0));
		assertEquals(0, t.addNode(22));
		assertEquals(-2, t.removeNode(null));
		assertEquals(0, t.addNode(23));
		assertEquals(0, t.addNode(24));
		assertEquals(-1, t.removeNode(50));
		assertEquals(0, t.removeNode(22));
		assertEquals(0, t.addNode(25));
		assertEquals(0, t.removeNode(25));
		assertEquals(-1, t.removeNode(25));
		assertEquals(-2, t.removeNode(null));
		System.out.println(t.toString());
	}
	/**
	 * Prueba del remove para el caso -2,-1
	 */
	@Test
	public void removeTestMenos2YMenos1() {
		t = new AVLTree<Integer>();
		assertEquals(0, t.addNode(10));
		assertEquals(0, t.addNode(12));
		assertEquals(0, t.addNode(5));
		assertEquals(0, t.addNode(4));
		assertEquals(0, t.addNode(6));
		assertEquals(0, t.addNode(11));
		assertEquals(0, t.addNode(3));
		assertEquals(0, t.addNode(7));
		assertEquals(0, t.removeNode(6));
		assertEquals(0, t.removeNode(7));
		System.out.println(t.toString());
	}
	/**
	 * Prueba del remove para el caso -2, 1
	 */
	@Test
	public void removeTestMenos2Y1() {
		t = new AVLTree<Integer>();
		assertEquals(0, t.addNode(10));
		assertEquals(0, t.addNode(7));
		assertEquals(0, t.addNode(12));
		assertEquals(0, t.addNode(11));
		assertEquals(0, t.addNode(5));
		assertEquals(0, t.addNode(8));
		assertEquals(0, t.addNode(6));
		assertEquals(0, t.addNode(9));
		assertEquals(0, t.removeNode(8));
		assertEquals(0, t.removeNode(9));
		System.out.println(t.toString());
	}
	/**
	 * Prueba del remove para el caso -2, 0
	 */
	@Test
	public void removeTestMenos2Y0() {
		t = new AVLTree<Integer>();
		assertEquals(0, t.addNode(10));
		assertEquals(0, t.addNode(7));
		assertEquals(0, t.addNode(12));
		assertEquals(0, t.addNode(11));
		assertEquals(0, t.addNode(5));
		assertEquals(0, t.addNode(8));
		assertEquals(0, t.addNode(4));
		assertEquals(0, t.addNode(6));
		assertEquals(0, t.addNode(9));
		assertEquals(0, t.removeNode(8));
		assertEquals(0, t.removeNode(9));
		System.out.println(t.toString());
	}
	
	/**
	 * Prueba del remove para el caso 2,1
	 */
	@Test
	public void removeTest2Y1() {
		t = new AVLTree<Integer>();
		assertEquals(0, t.addNode(10));
		assertEquals(0, t.addNode(16));
		assertEquals(0, t.addNode(5));
		assertEquals(0, t.addNode(4));
		assertEquals(0, t.addNode(6));
		assertEquals(0, t.addNode(11));
		assertEquals(0, t.addNode(17));
		assertEquals(0, t.addNode(18));
		assertEquals(0, t.addNode(12));
		assertEquals(0, t.removeNode(11));
		assertEquals(0, t.removeNode(12));
		System.out.println(t.toString());
	}
	/**
	 * Prueba del remove para el caso 2, -1
	 */
	@Test
	public void removeTest2YMenos1() {
		t = new AVLTree<Integer>();
		assertEquals(0, t.addNode(10));
		assertEquals(0, t.addNode(16));
		assertEquals(0, t.addNode(5));
		assertEquals(0, t.addNode(4));
		assertEquals(0, t.addNode(6));
		assertEquals(0, t.addNode(11));
		assertEquals(0, t.addNode(18));
		assertEquals(0, t.addNode(17));
		assertEquals(0, t.addNode(12));
		assertEquals(0, t.removeNode(11));
		assertEquals(0, t.removeNode(12));
		System.out.println(t.toString());
	}
	/**
	 * Prueba del remove para el caso 2, 0
	 */
	@Test
	public void removeTest2Y0() {
		t = new AVLTree<Integer>();
		assertEquals(0, t.addNode(10));
		assertEquals(0, t.addNode(16));
		assertEquals(0, t.addNode(5));
		assertEquals(0, t.addNode(4));
		assertEquals(0, t.addNode(6));
		assertEquals(0, t.addNode(11));
		assertEquals(0, t.addNode(18));
		assertEquals(0, t.addNode(17));
		assertEquals(0, t.addNode(12));
		assertEquals(0, t.addNode(20));
		assertEquals(0, t.removeNode(11));
		assertEquals(0, t.removeNode(12));
		System.out.println(t.toString());
	}

/*
 * Pruebas de los recorridos
 */
	/**
	 * Prueba de recorridos 1
	 */
	@Test
	public void recorridosTestNormal() {
		t = new AVLTree<Integer>(); 
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
		assertEquals(0, t.addNode(21));
		assertEquals(0, t.addNode(22));
		assertEquals(0, t.addNode(23));
		assertEquals(0, t.addNode(24));
		assertEquals(0, t.addNode(25));
		assertEquals("9:BF=1	4:BF=-1	2:BF=0	1:BF=0	3:BF=0	8:BF=0	18:BF=0	12:BF=0	10:BF=1	11:BF=0	14:BF=0	13:BF=0	16:BF=0	23:BF=0	21:BF=0	20:BF=0	22:BF=0	24:BF=1	25:BF=0	", t.preOrder());
		assertEquals("1:BF=0	2:BF=0	3:BF=0	4:BF=-1	8:BF=0	9:BF=1	10:BF=1	11:BF=0	12:BF=0	13:BF=0	14:BF=0	16:BF=0	18:BF=0	20:BF=0	21:BF=0	22:BF=0	23:BF=0	24:BF=1	25:BF=0	", t.inOrder());
		assertEquals("1:BF=0	3:BF=0	2:BF=0	8:BF=0	4:BF=-1	11:BF=0	10:BF=1	13:BF=0	16:BF=0	14:BF=0	12:BF=0	20:BF=0	22:BF=0	21:BF=0	25:BF=0	24:BF=1	23:BF=0	18:BF=0	9:BF=1	", t.postOrder());			
		System.out.println(t.toString());
		System.out.println(t.preOrder());
		System.out.println(t.inOrder());
		System.out.println(t.postOrder());	
	}
	

	/**
	 * Prueba de recorridos con evolucion
	 */
	@Test
	public void recorridosTestEvolution() {
		t = new AVLTree<Integer>(); 
		assertEquals(0, t.addNode(8));
		assertEquals(-1, t.removeNode(4));
		assertEquals(0, t.addNode(4));
		assertEquals(0, t.addNode(6));
		assertEquals(-1, t.addNode(6));
		assertEquals(0, t.addNode(1));
		assertEquals(1, t.searchNode(1));
		assertEquals(0, t.addNode(2));
		assertEquals(0, t.removeNode(8));
		assertEquals(-1, t.removeNode(8));
		assertEquals(null, t.searchNode(8));
		assertEquals(0, t.addNode(10));
		assertEquals(-2, t.addNode(null));
		assertEquals(0, t.addNode(12));
		assertEquals(null, t.searchNode(null));
		assertEquals(0, t.addNode(8));
		assertEquals(0, t.removeNode(4));
		assertEquals(null, t.searchNode(4));
		assertEquals(0, t.addNode(4));
		assertEquals(-2, t.removeNode(null));
		assertEquals(-2, t.addNode(null));
		assertEquals(0, t.addNode(15));
		assertEquals(0, t.addNode(14));
		assertEquals(-1, t.addNode(12));
		assertEquals(0, t.removeNode(2));
		assertEquals(0, t.removeNode(1));
		assertEquals(0, t.removeNode(12));
		assertEquals(0, t.addNode(16));		
		assertEquals(-1, t.removeNode(13));
		assertEquals(-2, t.removeNode(null));
		assertEquals(0, t.addNode(13));
		assertEquals(0, t.addNode(3));
		assertEquals(0, t.addNode(2));
		assertEquals(-1, t.removeNode(1));
		assertEquals(-2, t.addNode(null));
		assertEquals(0, t.addNode(1));
		assertEquals("10:BF=0	3:BF=0	2:BF=-1	1:BF=0	6:BF=0	4:BF=0	8:BF=0	15:BF=-1	14:BF=-1	13:BF=0	16:BF=0	", t.preOrder());
		assertEquals("1:BF=0	2:BF=-1	3:BF=0	4:BF=0	6:BF=0	8:BF=0	10:BF=0	13:BF=0	14:BF=-1	15:BF=-1	16:BF=0	", t.inOrder());
		assertEquals("1:BF=0	2:BF=-1	4:BF=0	8:BF=0	6:BF=0	3:BF=0	13:BF=0	14:BF=-1	16:BF=0	15:BF=-1	10:BF=0	", t.postOrder());
		System.out.println(t.toString());
		System.out.println(t.preOrder());
		System.out.println(t.inOrder());
		System.out.println(t.postOrder());	
	}

/*
 * Prueba del test de la sesión 9 de Nestor
 */
	/**
	 * Test de la sesion 9
	 */
	@Test 
	void testSesion9() { 
		Integer[] nodos=new Integer[]{100,90,80,70,60,50,40,30,20,10}; 
		AVLTree<Integer> t; 
		t = new AVLTree<Integer> (); 
		for (int i=0; i<nodos.length;i++) {
			assertEquals(0,t.addNode(nodos[i]));
			System.out.println("Arbol:"+(i+1)+"\n"+t);
		} 
	} 	
}
