package p2Grafos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

/**
 * Título: Clase GraphNoDirigidoTest
 * 
 * @author UO281847
 * @version 15/10/2021
 */
public class GraphNoDirigidoTest {
	/**
	 * Atributo g
	 */
	private GraphNoDirigido<Integer> g;
	
	/**
	 * Prueba del grafo no dirigido
	 */
	@Test
	public void GraphTest() {
		g = new GraphNoDirigido<Integer>(3);
		assertEquals(0, g.addNode(1));
		assertEquals(-1, g.addNode(1));
		assertEquals(0, g.getNode(1));
		assertEquals(-1, g.getNode(2));
		assertEquals(0, g.addNode(2));
		assertEquals(-1,g.addNode(2));
		assertEquals(0,g.addNode(3));		
		assertEquals(-2, g.addNode(4));
		assertEquals(0, g.addEdge(1, 2, 2));		
		assertEquals(-4,g.addEdge(1, 2, 2));
		assertEquals(2, g.getEdge(1,2));
		assertEquals(2, g.getEdge(2,1));
		assertEquals(-1, g.addEdge(4,1,3));
		assertEquals(-2, g.addEdge(1,4,6));		
		assertEquals(0, g.removeNode(1));
		assertFalse(g.existsEdge(1, 2));
		assertFalse(g.existsEdge(2, 1));
		assertEquals(0,g.addNode(4));
		assertEquals(-2, g.addEdge(4,1,3));
		assertEquals(-1, g.addEdge(1, 4, 4));
		assertEquals(0, g.addEdge(2, 4, 4));		
		assertTrue(g.existsEdge(2, 4));
		assertTrue(g.existsEdge(4, 2));
		assertEquals(0,g.addEdge(4, 3, 1));
		assertEquals(0,g.removeEdge(2, 4));
		assertEquals(-4,g.removeEdge(4, 2));
		assertEquals(0,g.removeNode(2));
		assertEquals(-1,g.removeNode(2));
		assertEquals(-1,g.removeEdge(2, 4));
		assertEquals(-2,g.removeEdge(4, 2));
	}
}

