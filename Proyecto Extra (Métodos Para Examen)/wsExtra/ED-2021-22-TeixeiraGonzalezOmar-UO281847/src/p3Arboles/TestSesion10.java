package p3Arboles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Titulo: Clase TestSesion10
 * 
 * @author UO281847
 * @version 12/11/2021
 */
class TestSesion10 {
	/**
	 * Atributo t
	 */
	private AVLTree<Integer> t;
		
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
}
