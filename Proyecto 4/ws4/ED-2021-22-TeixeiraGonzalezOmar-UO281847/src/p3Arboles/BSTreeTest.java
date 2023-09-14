package p3Arboles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * Titulo: Clase BSTreeTest
 * 
 * @author UO281847
 * @version 05/11/2021
 */
class BSTreeTest {
	/**
	 * Atributo t
	 */
	private BSTree<Integer> t;	
//---------------------------------- Pruebas -----------------------------------
/*
 * Prueba del método addNode:
 */
	/**
	 * Test del método addNode
	 */
	@Test
	public void addNodeTest() {
		t = new BSTree<Integer>(); 
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
		t = new BSTree<Integer>();
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
		BSTree<String> t = new BSTree<String>();
		assertNull(t.searchNode("A"));
		assertEquals(0, t.addNode("A"));
		assertEquals("A", t.searchNode("A"));
		assertEquals(0, t.addNode("B"));
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
 * Prueba del método removeNode:
 */
	/**
	 * Test del método removeNode
	 */	
	@Test
	public void removeNodeTest() {
		t = new BSTree<Integer>();	
		assertEquals(0, t.addNode(10));
		assertEquals(0, t.addNode(4));
		assertEquals(0, t.removeNode(4));
		assertEquals(-2, t.removeNode(null));
		assertEquals(0, t.addNode(3));
		assertEquals(0, t.addNode(8));
		assertEquals(0, t.addNode(9));
		assertEquals(0, t.removeNode(9));
		assertEquals(0, t.addNode(12));		
		assertEquals(0, t.removeNode(12));		
		assertEquals(-1, t.removeNode(12));
		assertEquals(-1, t.removeNode(9));
		assertEquals(-2, t.removeNode(null));
		System.out.println(t.toString());		
	}	
	
/*
 * Prueba de evolución del arbol:
 */
	/**
	 * Test de evolución
	 */
	@Test
	public void evolutionTest() {
		t = new BSTree<Integer>();		
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
		System.out.println(t.toString());	
	}

/**
 * Test de la sesion 8 de Nestor
 */
	/**
	 * Test de la sesion 8
	 */
	@Test 
	public void test_Sesion8() { 
	BSTree<Integer> t; 
	int n=1; 
	t = new BSTree<Integer>(); 
	assertEquals(0,t.addNode(100)); 
	System.out.println("Arbol:"+(++n)+"\n"+t); 
	assertEquals(0,t.addNode(50)); 
	System.out.println("Arbol:"+(++n)+"\n"+t); 
	assertEquals(0,t.addNode(150)); 
	System.out.println("Arbol:"+(++n)+"\n"+t); 
	assertEquals(0,t.removeNode(100)); 
	System.out.println("Arbol:"+(++n)+"\n"+t); 
	t = new BSTree<Integer>();
	assertEquals(0,t.addNode(100)); 
	System.out.println("Arbol:"+(++n)+"\n"+t); 
	assertEquals(0,t.addNode(50)); 
	System.out.println("Arbol:"+(++n)+"\n"+t); 
	assertEquals(0,t.addNode(150)); 
	System.out.println("Arbol:"+(++n)+"\n"+t); 
	assertEquals(0,t.removeNode(100)); 
	System.out.println("Arbol:"+(++n)+"\n"+t); 
	assertEquals(0,t.removeNode(50)); 
	System.out.println("Arbol:"+(++n)+"\n"+t); 
	t = new BSTree<Integer>(); 
	System.out.println("Arbol:"+(++n)+"\n"+t); 
	assertEquals(0,t.addNode(10)); 
	System.out.println("Arbol:"+(++n)+"\n"+t); 
	assertEquals(-1,t.removeNode(20)); 
	System.out.println("Arbol:"+(++n)+"\n"+t); 
	t = new BSTree<Integer>(); 
	System.out.println("Arbol:"+(++n)+"\n"+t); 
	assertEquals(0,t.addNode(10)); 
	System.out.println("Arbol:"+(++n)+"\n"+t); 
	assertEquals(0,t.removeNode(10)); 
	System.out.println("Arbol:"+(++n)+"\n"+t); 
	} 

//-------------------------------- Recorridos ----------------------------------
/*
 * Pruebas del método preOrder: 
 */
	/**
	 * Test del método preOrder 1
	 */
	@Test
	public void preOrderTest1() {
		t = new BSTree<Integer>(); 
		assertEquals(0, t.addNode(10));
		assertEquals(0, t.addNode(4));
		assertEquals(0, t.addNode(3));
		assertEquals(0, t.addNode(8));
		assertEquals(0, t.addNode(9));
		assertEquals(0, t.addNode(12));		
		assertEquals(0, t.addNode(13));
		assertEquals(0, t.addNode(11));
		System.out.println(t.toString());	
		assertEquals("10\t4\t3\t8\t9\t12\t11\t13\t", t.preOrder());
	}	
	/**
	 * Test del método preOrder 2
	 */
	@Test
	public void preOrderTest2() {
		t = new BSTree<Integer>(); 
		assertEquals(0, t.addNode(9));
		assertEquals(0, t.addNode(1));
		assertEquals(0, t.addNode(2));
		assertEquals(0, t.addNode(3));
		assertEquals(0, t.addNode(4));
		assertEquals(0, t.addNode(10));
		assertEquals(0, t.addNode(7));
		assertEquals(0, t.addNode(13));
		assertEquals(0, t.addNode(12));
		assertEquals(0, t.addNode(16));
		System.out.println(t.toString());	
		assertEquals("9\t1\t2\t3\t4\t7\t10\t13\t12\t16\t", t.preOrder());
	}
		
/*
 * Pruebas del método postOrder:
 */
	/**
	 * Test del método postOrder 1
	 */
	@Test
	public void postOrderTest1() {
		t = new BSTree<Integer>(); 
		assertEquals(0, t.addNode(10));
		assertEquals(0, t.addNode(4));
		assertEquals(0, t.addNode(3));
		assertEquals(0, t.addNode(8));
		assertEquals(0, t.addNode(9));
		assertEquals(0, t.addNode(12));		
		assertEquals(0, t.addNode(13));
		assertEquals(0, t.addNode(11));
		System.out.println(t.toString());	
		assertEquals("3\t9\t8\t4\t11\t13\t12\t10\t", t.postOrder());
	}
	/**
	 * Test del método postOrder 2
	 */
	@Test
	public void postOrderTest2() {
		t = new BSTree<Integer>(); 
		assertEquals(0, t.addNode(9));
		assertEquals(0, t.addNode(1));
		assertEquals(0, t.addNode(2));
		assertEquals(0, t.addNode(3));
		assertEquals(0, t.addNode(4));
		assertEquals(0, t.addNode(10));
		assertEquals(0, t.addNode(7));
		assertEquals(0, t.addNode(13));
		assertEquals(0, t.addNode(12));
		assertEquals(0, t.addNode(16));
		System.out.println(t.toString());	
		assertEquals("7\t4\t3\t2\t1\t12\t16\t13\t10\t9\t", t.postOrder());
	}

/*
 * Pruebas del método inOrder:
 */
	/**
	 * Test del método inOrder 1
	 */
	@Test
	public void inOrderTest1() {
		t = new BSTree<Integer>(); 
		assertEquals(0, t.addNode(10));
		assertEquals(0, t.addNode(4));
		assertEquals(0, t.addNode(3));
		assertEquals(0, t.addNode(8));
		assertEquals(0, t.addNode(9));
		assertEquals(0, t.addNode(12));		
		assertEquals(0, t.addNode(13));
		assertEquals(0, t.addNode(11));
		System.out.println(t.toString());	
		assertEquals("3\t4\t8\t9\t10\t11\t12\t13\t", t.inOrder());
	}
	/**
	 * Test del método inOrder 2
	 */
	@Test
	public void inOrderTest2() {
		t = new BSTree<Integer>(); 
		assertEquals(0, t.addNode(9));
		assertEquals(0, t.addNode(1));
		assertEquals(0, t.addNode(2));
		assertEquals(0, t.addNode(3));
		assertEquals(0, t.addNode(4));
		assertEquals(0, t.addNode(10));
		assertEquals(0, t.addNode(7));
		assertEquals(0, t.addNode(13));
		assertEquals(0, t.addNode(12));
		assertEquals(0, t.addNode(16));
		System.out.println(t.toString());	
		assertEquals("1\t2\t3\t4\t7\t9\t10\t12\t13\t16\t", t.inOrder());
	}
}