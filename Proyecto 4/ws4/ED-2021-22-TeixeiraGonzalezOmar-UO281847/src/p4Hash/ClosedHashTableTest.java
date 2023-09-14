package p4Hash;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Titulo: Clase ClosedHashTableTest
 * 
 * @author UO281847
 * @version 11/12/2021
 */
class ClosedHashTableTest {

//---------------------- PRUEBAS LINEALES SIN FACTORES DE CARGA ----------------------
/*
 * Pruebas del método add
 */
	/**
	 * Prueba de clase del método add
	 */
	@Test
	public void addLinearClassTest() {
		ClosedHashTable<Integer> h = new ClosedHashTable<Integer>(7,1,0,ClosedHashTable.LINEAL);
		assertEquals(0, h.add(-7));
		assertEquals(0, h.add(0));
		assertEquals(0, h.add(9));
		assertEquals(0, h.add(7));
		assertEquals(0, h.add(-8));
		assertEquals(0, h.add(6));
		assertEquals(0, h.add(-5));
		assertEquals(-1, h.add(3));
		System.out.println(h.toString());
	}	
	/**
	 * Prueba general del método add
	 */
	@Test
	public void addLinearGeneralTest() {
		ClosedHashTable<Integer> h = new ClosedHashTable<Integer>(6,1,0,ClosedHashTable.LINEAL);
		assertEquals(7, h.getSize());		
		assertEquals(0, h.getNumOfElems());		
		assertEquals(0, h.add(4));
		assertEquals(1, h.getNumOfElems());		
		assertEquals(0, h.add(0));
		assertEquals(2, h.getNumOfElems());
		assertEquals(-2, h.add(null));
		assertEquals(0, h.add(-7));
		assertEquals(0, h.add(-8));
		assertEquals(-2, h.add(null));
		assertEquals(4, h.getNumOfElems());
		assertEquals(0, h.add(9));
		assertEquals(0, h.add(5));
		assertEquals(0, h.add(2));
		assertEquals(7, h.getNumOfElems());
		assertEquals(-2, h.add(null));
		assertEquals(7, h.getNumOfElems());
		assertEquals(-1, h.add(12));
		assertEquals(7, h.getNumOfElems());
		System.out.println(h.toString());
	}

/*
 * Pruebas del método find
 */
	/**
	 * Prueba de clase del método find
	 */
	@Test
	public void findLinearClassTest() {
		ClosedHashTable<Integer> h = new ClosedHashTable<Integer>(7,1,0,ClosedHashTable.LINEAL);
		assertEquals(0, h.add(-7));
		assertEquals(0, h.add(0));
		assertEquals(0, h.add(9));
		assertEquals(0, h.add(7));
		assertEquals(0, h.add(-8));
		assertEquals(0, h.add(6));
		assertEquals(0, h.add(-5));
		
		assertEquals(-7, h.find(-7));
		assertEquals(7, h.find(7));
		assertEquals(null, h.find(null));
		assertEquals(0, h.find(0));
		System.out.println(h.toString());
	}	
	/**
	 * Prueba general del método find
	 */
	@Test
	public void findLinearGeneralTest() {
		ClosedHashTable<Integer> h = new ClosedHashTable<Integer>(6,1,0,ClosedHashTable.LINEAL);
		assertEquals(null, h.find(4));
		assertEquals(7, h.getSize());		
		assertEquals(0, h.getNumOfElems());		
		assertEquals(0, h.add(4));
		assertEquals(4, h.find(4));
		assertEquals(1, h.getNumOfElems());		
		assertEquals(0, h.add(0));
		assertEquals(0, h.find(0));
		assertEquals(2, h.getNumOfElems());
		assertEquals(-2, h.add(null));
		assertEquals(0, h.add(-7));
		assertEquals(null, h.find(-8));
		assertEquals(0, h.add(-8));
		assertEquals(-8, h.find(-8));
		assertEquals(-2, h.add(null));
		assertEquals(4, h.getNumOfElems());
		assertEquals(0, h.add(9));
		assertEquals(0, h.add(5));
		assertEquals(0, h.add(2));
		assertEquals(7, h.getNumOfElems());
		assertEquals(null, h.find(null));
		assertEquals(-2, h.add(null));		
		assertEquals(7, h.getNumOfElems());
		assertEquals(-1, h.add(12));
		assertEquals(7, h.getNumOfElems());
		System.out.println(h.toString());
	}

/*
 * Pruebas del método remove
 */
	/**
	 * Prueba de clase del método remove
	 */
	@Test
	public void removeLinearClassTest() {
		ClosedHashTable<Integer> h = new ClosedHashTable<Integer>(7,1,0,ClosedHashTable.LINEAL);
		assertEquals(0, h.add(-7));
		assertEquals(0, h.add(0));
		assertEquals(0, h.add(9));
		assertEquals(0, h.add(7));
		assertEquals(0, h.add(-8));
		assertEquals(0, h.add(6));
		assertEquals(0, h.add(-5));
		assertEquals(7, h.getNumOfElems());
		
		assertEquals(0, h.remove(0));
		assertEquals(0, h.remove(-8));
		assertEquals(-2, h.remove(null));
		assertEquals(-1, h.remove(1));
		assertEquals(0, h.remove(-7));		
		System.out.println(h.toString());
	}
	/**
	 * Prueba general del método add
	 */
	@Test
	public void removeLinearGeneralTest() {
		ClosedHashTable<Integer> h = new ClosedHashTable<Integer>(6,1,0,ClosedHashTable.LINEAL);
		assertEquals(-2, h.remove(null));
		assertEquals(-1, h.remove(4));
		assertEquals(7, h.getSize());		
		assertEquals(0, h.getNumOfElems());
		assertEquals(-1, h.remove(4));
		assertEquals(0, h.add(4));
		assertEquals(1, h.getNumOfElems());		
		assertEquals(0, h.add(0));
		assertEquals(2, h.getNumOfElems());
		assertEquals(-2, h.add(null));
		assertEquals(-2, h.remove(null));
		assertEquals(0, h.add(-7));
		assertEquals(0, h.add(-8));
		assertEquals(-2, h.add(null));
		assertEquals(4, h.getNumOfElems());
		assertEquals(0, h.add(9));
		assertEquals(0, h.add(5));
		assertEquals(-2, h.remove(null));
		assertEquals(0, h.add(2));
		assertEquals(7, h.getNumOfElems());
		assertEquals(-2, h.add(null));
		assertEquals(7, h.getNumOfElems());
		assertEquals(-1, h.add(12));
		assertEquals(7, h.getNumOfElems());
		
		assertEquals(-2, h.remove(null));
		assertEquals(0, h.remove(0));
		assertEquals(-1, h.remove(0));
		assertEquals(0, h.remove(-7));
		assertEquals(0, h.remove(9));
		assertEquals(0, h.remove(2));
		assertEquals(0, h.remove(4));
		assertEquals(0, h.remove(5));
		assertEquals(-1, h.remove(5));
		assertEquals(0, h.remove(-8));
		assertEquals(0, h.getNumOfElems());
		assertEquals(-2, h.remove(null));
		assertEquals(-1, h.remove(10));
		System.out.println(h.toString());
	}
/*
 * Pruebas de evolución
 */
	/**
	 * Prueba de evolución básica de tablas Hash
	 */
	@Test
	public void evolutionLinearBasicTest() {
		ClosedHashTable<Integer> h = new ClosedHashTable<Integer>(8,1,0,ClosedHashTable.LINEAL);		
		assertEquals(11, h.getSize());
		assertEquals(0, h.getNumOfElems());
		assertNull(h.find(0));
		assertEquals(-2, h.remove(null));
		assertEquals(-1, h.remove(0));
		assertEquals(-2, h.add(null));
		assertEquals(0, h.getNumOfElems());
		assertEquals(0, h.add(0));
		assertEquals(0, h.find(0));
		assertEquals(1, h.getNumOfElems());
		assertEquals(0, h.remove(0));
		assertEquals(-1, h.remove(0));
		assertNull(h.find(0));
		assertEquals(0, h.getNumOfElems());
		assertEquals(0, h.add(7));
		assertEquals(-2, h.add(null));
		assertEquals(0, h.add(21));
		assertEquals(0, h.add(24));
		assertEquals(0, h.add(27));
		assertEquals(4, h.getNumOfElems());
		assertEquals(24, h.find(24));
		assertEquals(0, h.remove(24));
		assertEquals(-1, h.remove(24));
		assertEquals(-1, h.remove(24));
		assertNull(h.find(24));
		assertEquals(-2, h.remove(null));
		assertEquals(3, h.getNumOfElems());
		assertEquals(0, h.add(24));
		assertEquals(4, h.getNumOfElems());
		assertEquals(0, h.add(35));
		assertEquals(0, h.add(23));
		assertEquals(6, h.getNumOfElems());
		assertEquals(23, h.find(23));
		assertEquals(0, h.remove(23));
		assertEquals(-1, h.remove(23));
		assertEquals(-1, h.remove(23));
		assertNull(h.find(23));
		assertEquals(-2, h.remove(null));
		assertEquals(-2, h.add(null));
		assertEquals(0, h.add(23));
		assertEquals(23, h.find(23));
		assertEquals(0, h.add(50));
		assertEquals(50, h.find(50));
		assertEquals(0, h.add(75));
		assertEquals(75, h.find(75));
		assertEquals(0, h.add(91));
		assertEquals(91, h.find(91));
		assertEquals(9, h.getNumOfElems());
		assertNull(h.find(63));
		assertEquals(-2, h.remove(null));
		assertEquals(-2, h.add(null));
		assertEquals(0, h.add(25));
		assertEquals(10, h.getNumOfElems());
		assertEquals(0, h.add(19));
		assertEquals(11, h.getNumOfElems());
		assertEquals(11, h.getSize());
		assertTrue(h.getNumOfElems() == h.getSize());
		assertEquals(-2, h.remove(null));
		assertEquals(0, h.remove(19));
		assertEquals(10, h.getNumOfElems());
		assertEquals(-1, h.remove(19));
		assertEquals(-1, h.remove(19));
		assertEquals(0, h.add(19));
		assertEquals(11, h.getNumOfElems());
		assertTrue(h.getNumOfElems() == h.getSize());
		assertEquals(-2, h.add(null));
		assertEquals(-1, h.add(18));
		assertEquals(0, h.remove(19));
		assertEquals(10, h.getNumOfElems());
		assertEquals(0, h.add(18));
		assertNull(h.find(19));
		assertEquals(18, h.find(18));
		assertEquals(23, h.find(23));
		assertNull(h.find(null));
		System.out.println(h.toString());
	}

//---------------------- PRUEBAS GENERALES CON FACTORES DE CARGA ---------------------
/*
 * Pruebas de add
 */
	/**
	 * Prueba linear de add con factores de carga
	 */
	@Test
	public void addLinearTest() {
		ClosedHashTable<Integer> h = new ClosedHashTable<Integer>(4,ClosedHashTable.LINEAL);
		assertEquals(5, h.getSize());
		assertEquals(0, h.getNumOfElems());
		assertEquals(-2, h.add(null));
		assertEquals(0, h.add(8));
		assertEquals(1, h.getNumOfElems());
		assertEquals(0.2, h.getLF(), 0.01);
		assertEquals(0, h.add(5));
		assertEquals(-2, h.add(null));
		assertEquals(0.4, h.getLF(), 0.01);
		assertEquals(0, h.add(11));
		assertEquals(11, h.getSize());
		assertEquals(3, h.getNumOfElems());
		assertEquals(0.27, h.getLF(), 0.01);		
		assertEquals(0, h.add(3));
		assertEquals(0.36, h.getLF(), 0.01);
		assertEquals(4, h.getNumOfElems());
		assertEquals(0, h.add(5));
		assertEquals(-2, h.add(null));
		assertEquals(5, h.getNumOfElems());
		assertEquals(0.45, h.getLF(), 0.01);
		assertEquals(0, h.add(10));
		assertEquals(6, h.getNumOfElems());
		assertEquals(23, h.getSize());
		assertEquals(0.26, h.getLF(), 0.01);
		assertEquals(-2, h.add(null));
		System.out.println(h.toString());
	}
	/**
	 * Prueba cuadrática de add con factores de carga
	 */
	@Test
	public void addCuadraticTest() {
		ClosedHashTable<Integer> h = new ClosedHashTable<Integer>(4,ClosedHashTable.CUADRATICA);
		assertEquals(5, h.getSize());
		assertEquals(0, h.getNumOfElems());
		assertEquals(-2, h.add(null));
		assertEquals(0, h.add(8));
		assertEquals(1, h.getNumOfElems());
		assertEquals(0.2, h.getLF(), 0.01);
		assertEquals(0, h.add(5));
		assertEquals(-2, h.add(null));
		assertEquals(0.4, h.getLF(), 0.01);
		assertEquals(0, h.add(11));
		assertEquals(11, h.getSize());
		assertEquals(3, h.getNumOfElems());
		assertEquals(0.27, h.getLF(), 0.01);		
		assertEquals(0, h.add(3));
		assertEquals(0.36, h.getLF(), 0.01);
		assertEquals(4, h.getNumOfElems());
		assertEquals(0, h.add(5));
		assertEquals(-2, h.add(null));
		assertEquals(5, h.getNumOfElems());
		assertEquals(0.45, h.getLF(), 0.01);
		assertEquals(0, h.add(10));
		assertEquals(6, h.getNumOfElems());
		assertEquals(23, h.getSize());
		assertEquals(0.26, h.getLF(), 0.01);
		assertEquals(-2, h.add(null));
		System.out.println(h.toString());
	}
	/**
	 * Prueba doble hash de add con factores de carga
	 */
	@Test
	public void addDobleHashTest() {
		ClosedHashTable<Integer> h = new ClosedHashTable<Integer>(4,ClosedHashTable.DOBLEHASH);
		assertEquals(5, h.getSize());
		assertEquals(0, h.getNumOfElems());
		assertEquals(-2, h.add(null));
		assertEquals(0, h.add(8));
		assertEquals(1, h.getNumOfElems());
		assertEquals(0.2, h.getLF(), 0.01);
		assertEquals(0, h.add(5));
		assertEquals(-2, h.add(null));
		assertEquals(0.4, h.getLF(), 0.01);
		assertEquals(0, h.add(11));
		assertEquals(11, h.getSize());
		assertEquals(3, h.getNumOfElems());
		assertEquals(0.27, h.getLF(), 0.01);		
		assertEquals(0, h.add(3));
		assertEquals(0.36, h.getLF(), 0.01);
		assertEquals(4, h.getNumOfElems());
		assertEquals(0, h.add(5));
		assertEquals(-2, h.add(null));
		assertEquals(5, h.getNumOfElems());
		assertEquals(0.45, h.getLF(), 0.01);
		assertEquals(0, h.add(10));
		assertEquals(6, h.getNumOfElems());
		assertEquals(23, h.getSize());
		assertEquals(0.26, h.getLF(), 0.01);
		assertEquals(-2, h.add(null));
		System.out.println(h.toString());
	}
/*
 * Pruebas de remove
 */
	/**
	 * Prueba linear de remove con factores de carga
	 */
	@Test
	public void removeLinearTest() {
		ClosedHashTable<Integer> h = new ClosedHashTable<Integer>(4,ClosedHashTable.LINEAL);
		assertEquals(0, h.add(8));
		assertEquals(0, h.add(5));
		assertEquals(0, h.add(5));
		assertEquals(0, h.add(7));
		assertEquals(0, h.add(2));
		assertEquals(0, h.add(10));
		assertEquals(0.26, h.getLF(), 0.01);
		assertEquals(23, h.getSize());
		assertEquals(6, h.getNumOfElems());
		assertEquals(-2, h.remove(null));
		assertEquals(-1, h.remove(14));
		assertEquals(0, h.remove(8));
		assertEquals(-1, h.remove(8));
		assertEquals(-1, h.remove(8));
		assertEquals(5, h.getNumOfElems());
		assertEquals(0.21, h.getLF(), 0.01);
		assertEquals(0, h.remove(5));
		assertEquals(4, h.getNumOfElems());
		assertEquals(-1, h.remove(8));
		assertEquals(0, h.remove(2));
		assertEquals(-2, h.remove(null));
		assertEquals(3, h.getNumOfElems());
		assertEquals(11, h.getSize());
		assertEquals(0.27, h.getLF(), 0.01);
		assertEquals(0, h.remove(10));
		assertEquals(2, h.getNumOfElems());
		assertEquals(-2, h.remove(null));
		assertEquals(0.18, h.getLF(), 0.01);
		assertEquals(0, h.remove(5));
		assertEquals(1, h.getNumOfElems());
		assertEquals(5, h.getSize());
		assertEquals(0.2, h.getLF(), 0.01);
		assertEquals(0, h.remove(7));
		assertEquals(-2, h.remove(null));
		assertEquals(-1, h.remove(7));
		assertEquals(0.0, h.getLF(), 0.01);
		assertEquals(3, h.getSize());
		System.out.println(h.toString());
	}
	/**
	 * Prueba cuadratica de remove con factores de carga
	 */
	@Test
	public void removeCuadraticTest() {
		ClosedHashTable<Integer> h = new ClosedHashTable<Integer>(4,ClosedHashTable.CUADRATICA);
		assertEquals(0, h.add(8));
		assertEquals(0, h.add(5));
		assertEquals(0, h.add(5));
		assertEquals(0, h.add(7));
		assertEquals(0, h.add(2));
		assertEquals(0, h.add(10));
		assertEquals(0.26, h.getLF(), 0.01);
		assertEquals(23, h.getSize());
		assertEquals(6, h.getNumOfElems());
		assertEquals(-2, h.remove(null));
		assertEquals(-1, h.remove(14));
		assertEquals(0, h.remove(8));
		assertEquals(-1, h.remove(8));
		assertEquals(-1, h.remove(8));
		assertEquals(5, h.getNumOfElems());
		assertEquals(0.21, h.getLF(), 0.01);
		assertEquals(0, h.remove(5));
		assertEquals(4, h.getNumOfElems());
		assertEquals(-1, h.remove(8));
		assertEquals(0, h.remove(2));
		assertEquals(-2, h.remove(null));
		assertEquals(3, h.getNumOfElems());
		assertEquals(11, h.getSize());
		assertEquals(0.27, h.getLF(), 0.01);
		assertEquals(0, h.remove(10));
		assertEquals(2, h.getNumOfElems());
		assertEquals(-2, h.remove(null));
		assertEquals(0.18, h.getLF(), 0.01);
		assertEquals(0, h.remove(5));
		assertEquals(1, h.getNumOfElems());
		assertEquals(5, h.getSize());
		assertEquals(0.2, h.getLF(), 0.01);
		assertEquals(0, h.remove(7));
		assertEquals(-2, h.remove(null));
		assertEquals(-1, h.remove(7));
		assertEquals(0.0, h.getLF(), 0.01);
		assertEquals(3, h.getSize());
		System.out.println(h.toString());
	}
	/**
	 * Prueba cuadratica de remove con factores de carga
	 */
	@Test
	public void removeDobleHashTest() {
		ClosedHashTable<Integer> h = new ClosedHashTable<Integer>(4,ClosedHashTable.DOBLEHASH);
		assertEquals(0, h.add(8));
		assertEquals(0, h.add(5));
		assertEquals(0, h.add(5));
		assertEquals(0, h.add(7));
		assertEquals(0, h.add(2));
		assertEquals(0, h.add(10));
		assertEquals(0.26, h.getLF(), 0.01);
		assertEquals(23, h.getSize());
		assertEquals(6, h.getNumOfElems());
		assertEquals(-2, h.remove(null));
		assertEquals(-1, h.remove(14));
		assertEquals(0, h.remove(8));
		assertEquals(-1, h.remove(8));
		assertEquals(-1, h.remove(8));
		assertEquals(5, h.getNumOfElems());
		assertEquals(0.21, h.getLF(), 0.01);
		assertEquals(0, h.remove(5));
		assertEquals(4, h.getNumOfElems());
		assertEquals(-1, h.remove(8));
		assertEquals(0, h.remove(2));
		assertEquals(-2, h.remove(null));
		assertEquals(3, h.getNumOfElems());
		assertEquals(11, h.getSize());
		assertEquals(0.27, h.getLF(), 0.01);
		assertEquals(0, h.remove(10));
		assertEquals(2, h.getNumOfElems());
		assertEquals(-2, h.remove(null));
		assertEquals(0.18, h.getLF(), 0.01);
		assertEquals(0, h.remove(5));
		assertEquals(1, h.getNumOfElems());
		assertEquals(5, h.getSize());
		assertEquals(0.2, h.getLF(), 0.01);
		assertEquals(0, h.remove(7));
		assertEquals(-2, h.remove(null));
		assertEquals(-1, h.remove(7));
		assertEquals(0.0, h.getLF(), 0.01);
		assertEquals(3, h.getSize());
		System.out.println(h.toString());
	}
/*
 * Pruebas de evolución:
 */
	/**
	 * Prueba de evolucion lineal con factores de carga
	 */
	@Test
	public void evolutionLinearTest() {
		ClosedHashTable<Integer> h = new ClosedHashTable<Integer>(4,ClosedHashTable.LINEAL);
		assertEquals(5, h.getSize());
		assertEquals(0, h.getNumOfElems());
		assertEquals(-2, h.remove(null));
		assertEquals(-1, h.remove(8));
		assertEquals(0, h.add(8));
		assertEquals(0.2, h.getLF(), 0.01);
		assertEquals(0, h.remove(8));
		assertEquals(0.0, h.getLF(), 0.01);
		assertEquals(3, h.getSize());
		assertEquals(-2, h.remove(null));
		assertEquals(0, h.getNumOfElems());
		assertEquals(0, h.add(8));
		assertEquals(0, h.remove(8));
		assertEquals(-1, h.remove(8));
		assertEquals(0, h.add(8));
		assertEquals(1, h.getNumOfElems());
		assertEquals(0.33, h.getLF(), 0.01);
		assertEquals(0, h.add(8));
		assertEquals(-2, h.add(null));
		assertEquals(-2, h.add(null));
		assertEquals(2, h.getNumOfElems());
		assertEquals(0, h.add(5));
		assertEquals(3, h.getNumOfElems());
		assertEquals(7, h.getSize());
		assertEquals(-2, h.add(null));
		assertEquals(8, h.find(8));
		assertEquals(null, h.find(7));
		assertEquals(0, h.add(7));
		assertEquals(0.23, h.getLF(), 0.01);
		assertEquals(4, h.getNumOfElems());
		assertEquals(17, h.getSize());
		assertEquals(0, h.add(10));
		assertEquals(-2, h.remove(null));
		assertEquals(0, h.remove(10));
		assertEquals(-1, h.remove(10));
		assertEquals(null, h.find(10));
		assertEquals(5, h.find(5));
		assertEquals(0, h.remove(5));
		assertEquals(0.17, h.getLF(), 0.01);
		assertEquals(0, h.remove(8));
		assertEquals(-2, h.add(null));
		assertEquals(0.28, h.getLF(), 0.01);
		assertEquals(2, h.getNumOfElems());
		assertEquals(7, h.getSize());
		assertEquals(-2, h.remove(null));
		assertEquals(0, h.remove(8));
		assertEquals(0.33, h.getLF(), 0.01);
		assertEquals(3, h.getSize());
		assertEquals(1, h.getNumOfElems());
		assertEquals(3, h.getSize());
		assertEquals(-2, h.remove(null));
		assertEquals(0, h.remove(7));
		assertEquals(0.0, h.getLF(), 0.01);
		assertEquals(null, h.find(5));		
		assertEquals(-2, h.remove(null));
		assertEquals(-2, h.add(null));
		assertEquals(-2, h.remove(null));
		assertEquals(0, h.add(2));
		assertEquals(0.33, h.getLF(), 0.01);
		assertEquals(0, h.add(5));
		assertEquals(0.28, h.getLF(), 0.01);
		assertEquals(2, h.getNumOfElems());
		assertEquals(0, h.add(9));
		assertEquals(0.42, h.getLF(), 0.01);
		assertEquals(-2, h.add(null));
		assertEquals(7, h.getSize());
		assertEquals(0, h.add(0));
		assertEquals(0.23, h.getLF(), 0.01);
		assertEquals(4, h.getNumOfElems());
		assertEquals(0, h.add(0));
		assertEquals(0.29, h.getLF(), 0.01);
		assertEquals(5, h.getNumOfElems());
		assertEquals(0, h.add(1));
		assertEquals(0.35, h.getLF(), 0.01);
		assertEquals(6, h.getNumOfElems());
		assertEquals(-2, h.add(null));
		assertEquals(0, h.find(0));
		assertEquals(0, h.find(0));
		assertEquals(2, h.find(2));
		assertEquals(1, h.find(1));
		assertEquals(5, h.find(5));
		assertEquals(9, h.find(9));
		assertEquals(0, h.remove(9));
		assertEquals(0.29, h.getLF(), 0.01);
		assertEquals(0, h.remove(0));
		assertEquals(0.23, h.getLF(), 0.01);
		assertEquals(4, h.getNumOfElems());
		assertEquals(-2, h.add(null));
		assertEquals(0, h.remove(1));
		assertEquals(-2, h.remove(null));
		assertEquals(-1, h.remove(1));
		assertEquals(-1, h.remove(1));
		assertEquals(0.17, h.getLF(), 0.01);
		assertEquals(3, h.getNumOfElems());
		assertEquals(17, h.getSize());
		assertEquals(0, h.remove(5));
		assertEquals(-2, h.remove(null));
		assertEquals(7, h.getSize());
		assertEquals(2, h.getNumOfElems());
		assertEquals(0.28, h.getLF(), 0.01);
		assertEquals(0, h.find(0));
		assertEquals(0, h.add(0));
		assertEquals(3, h.getNumOfElems());
		assertEquals(0.42, h.getLF(), 0.01);
		System.out.println(h.toString());
	}
	/**
	 * Prueba de evolucion cuadratica con factores de carga
	 */
	@Test
	public void evolutionCuadraticTest() {
		ClosedHashTable<Integer> h = new ClosedHashTable<Integer>(4,ClosedHashTable.CUADRATICA);
		assertEquals(5, h.getSize());
		assertEquals(0, h.getNumOfElems());
		assertEquals(-2, h.remove(null));
		assertEquals(-1, h.remove(8));
		assertEquals(0, h.add(8));
		assertEquals(0.2, h.getLF(), 0.01);
		assertEquals(0, h.remove(8));
		assertEquals(0.0, h.getLF(), 0.01);
		assertEquals(3, h.getSize());
		assertEquals(-2, h.remove(null));
		assertEquals(0, h.getNumOfElems());
		assertEquals(0, h.add(8));
		assertEquals(0, h.remove(8));
		assertEquals(-1, h.remove(8));
		assertEquals(0, h.add(8));
		assertEquals(1, h.getNumOfElems());
		assertEquals(0.33, h.getLF(), 0.01);
		assertEquals(0, h.add(8));
		assertEquals(-2, h.add(null));
		assertEquals(-2, h.add(null));
		assertEquals(2, h.getNumOfElems());
		assertEquals(0, h.add(5));
		assertEquals(3, h.getNumOfElems());
		assertEquals(7, h.getSize());
		assertEquals(-2, h.add(null));
		assertEquals(8, h.find(8));
		assertEquals(null, h.find(7));
		assertEquals(0, h.add(7));
		assertEquals(0.23, h.getLF(), 0.01);
		assertEquals(4, h.getNumOfElems());
		assertEquals(17, h.getSize());
		assertEquals(0, h.add(10));
		assertEquals(-2, h.remove(null));
		assertEquals(0, h.remove(10));
		assertEquals(-1, h.remove(10));
		assertEquals(null, h.find(10));
		assertEquals(5, h.find(5));
		assertEquals(0, h.remove(5));
		assertEquals(0.17, h.getLF(), 0.01);
		assertEquals(0, h.remove(8));
		assertEquals(-2, h.add(null));
		assertEquals(0.28, h.getLF(), 0.01);
		assertEquals(2, h.getNumOfElems());
		assertEquals(7, h.getSize());
		assertEquals(-2, h.remove(null));
		assertEquals(0, h.remove(8));
		assertEquals(0.33, h.getLF(), 0.01);
		assertEquals(3, h.getSize());
		assertEquals(1, h.getNumOfElems());
		assertEquals(3, h.getSize());
		assertEquals(-2, h.remove(null));
		assertEquals(0, h.remove(7));
		assertEquals(0.0, h.getLF(), 0.01);
		assertEquals(null, h.find(5));		
		assertEquals(-2, h.remove(null));
		assertEquals(-2, h.add(null));
		assertEquals(-2, h.remove(null));
		assertEquals(0, h.add(2));
		assertEquals(0.33, h.getLF(), 0.01);
		assertEquals(0, h.add(5));
		assertEquals(0.28, h.getLF(), 0.01);
		assertEquals(2, h.getNumOfElems());
		assertEquals(0, h.add(9));
		assertEquals(0.42, h.getLF(), 0.01);
		assertEquals(-2, h.add(null));
		assertEquals(7, h.getSize());
		assertEquals(0, h.add(0));
		assertEquals(0.23, h.getLF(), 0.01);
		assertEquals(4, h.getNumOfElems());
		assertEquals(0, h.add(0));
		assertEquals(0.29, h.getLF(), 0.01);
		assertEquals(5, h.getNumOfElems());
		assertEquals(0, h.add(1));
		assertEquals(0.35, h.getLF(), 0.01);
		assertEquals(6, h.getNumOfElems());
		assertEquals(-2, h.add(null));
		assertEquals(0, h.find(0));
		assertEquals(0, h.find(0));
		assertEquals(2, h.find(2));
		assertEquals(1, h.find(1));
		assertEquals(5, h.find(5));
		assertEquals(9, h.find(9));
		assertEquals(0, h.remove(9));
		assertEquals(0.29, h.getLF(), 0.01);
		assertEquals(0, h.remove(0));
		assertEquals(0.23, h.getLF(), 0.01);
		assertEquals(4, h.getNumOfElems());
		assertEquals(-2, h.add(null));
		assertEquals(0, h.remove(1));
		assertEquals(-2, h.remove(null));
		assertEquals(-1, h.remove(1));
		assertEquals(-1, h.remove(1));
		assertEquals(0.17, h.getLF(), 0.01);
		assertEquals(3, h.getNumOfElems());
		assertEquals(17, h.getSize());
		assertEquals(0, h.remove(5));
		assertEquals(-2, h.remove(null));
		assertEquals(7, h.getSize());
		assertEquals(2, h.getNumOfElems());
		assertEquals(0.28, h.getLF(), 0.01);
		assertEquals(0, h.find(0));
		assertEquals(0, h.add(0));
		assertEquals(3, h.getNumOfElems());
		assertEquals(0.42, h.getLF(), 0.01);
		System.out.println(h.toString());
	}
	/**
	 * Prueba de evolucion doble hash con factores de carga
	 */
	@Test
	public void evolutionDobleHashTest() {
		ClosedHashTable<Integer> h = new ClosedHashTable<Integer>(4,ClosedHashTable.DOBLEHASH);
		assertEquals(5, h.getSize());
		assertEquals(0, h.getNumOfElems());
		assertEquals(-2, h.remove(null));
		assertEquals(-1, h.remove(8));
		assertEquals(0, h.add(8));
		assertEquals(0.2, h.getLF(), 0.01);
		assertEquals(0, h.remove(8));
		assertEquals(0.0, h.getLF(), 0.01);
		assertEquals(3, h.getSize());
		assertEquals(-2, h.remove(null));
		assertEquals(0, h.getNumOfElems());
		assertEquals(0, h.add(8));
		assertEquals(0, h.remove(8));
		assertEquals(-1, h.remove(8));
		assertEquals(0, h.add(8));
		assertEquals(1, h.getNumOfElems());
		assertEquals(0.33, h.getLF(), 0.01);
		assertEquals(0, h.add(8));
		assertEquals(-2, h.add(null));
		assertEquals(-2, h.add(null));
		assertEquals(2, h.getNumOfElems());
		assertEquals(0, h.add(5));
		assertEquals(3, h.getNumOfElems());
		assertEquals(7, h.getSize());
		assertEquals(-2, h.add(null));
		assertEquals(8, h.find(8));
		assertEquals(null, h.find(7));
		assertEquals(0, h.add(7));
		assertEquals(0.23, h.getLF(), 0.01);
		assertEquals(4, h.getNumOfElems());
		assertEquals(17, h.getSize());
		assertEquals(0, h.add(10));
		assertEquals(-2, h.remove(null));
		assertEquals(0, h.remove(10));
		assertEquals(-1, h.remove(10));
		assertEquals(null, h.find(10));
		assertEquals(5, h.find(5));
		assertEquals(0, h.remove(5));
		assertEquals(0.17, h.getLF(), 0.01);
		assertEquals(0, h.remove(8));
		assertEquals(-2, h.add(null));
		assertEquals(0.28, h.getLF(), 0.01);
		assertEquals(2, h.getNumOfElems());
		assertEquals(7, h.getSize());
		assertEquals(-2, h.remove(null));
		assertEquals(0, h.remove(8));
		assertEquals(0.33, h.getLF(), 0.01);
		assertEquals(3, h.getSize());
		assertEquals(1, h.getNumOfElems());
		assertEquals(3, h.getSize());
		assertEquals(-2, h.remove(null));
		assertEquals(0, h.remove(7));
		assertEquals(0.0, h.getLF(), 0.01);
		assertEquals(null, h.find(5));		
		assertEquals(-2, h.remove(null));
		assertEquals(-2, h.add(null));
		assertEquals(-2, h.remove(null));
		assertEquals(0, h.add(2));
		assertEquals(0.33, h.getLF(), 0.01);
		assertEquals(0, h.add(5));
		assertEquals(0.28, h.getLF(), 0.01);
		assertEquals(2, h.getNumOfElems());
		assertEquals(0, h.add(9));
		assertEquals(0.42, h.getLF(), 0.01);
		assertEquals(-2, h.add(null));
		assertEquals(7, h.getSize());
		assertEquals(0, h.add(0));
		assertEquals(0.23, h.getLF(), 0.01);
		assertEquals(4, h.getNumOfElems());
		assertEquals(0, h.add(0));
		assertEquals(0.29, h.getLF(), 0.01);
		assertEquals(5, h.getNumOfElems());
		assertEquals(0, h.add(1));
		assertEquals(0.35, h.getLF(), 0.01);
		assertEquals(6, h.getNumOfElems());
		assertEquals(-2, h.add(null));
		assertEquals(0, h.find(0));
		assertEquals(0, h.find(0));
		assertEquals(2, h.find(2));
		assertEquals(1, h.find(1));
		assertEquals(5, h.find(5));
		assertEquals(9, h.find(9));
		assertEquals(0, h.remove(9));
		assertEquals(0.29, h.getLF(), 0.01);
		assertEquals(0, h.remove(0));
		assertEquals(0.23, h.getLF(), 0.01);
		assertEquals(4, h.getNumOfElems());
		assertEquals(-2, h.add(null));
		assertEquals(0, h.remove(1));
		assertEquals(-2, h.remove(null));
		assertEquals(-1, h.remove(1));
		assertEquals(-1, h.remove(1));
		assertEquals(0.17, h.getLF(), 0.01);
		assertEquals(3, h.getNumOfElems());
		assertEquals(17, h.getSize());
		assertEquals(0, h.remove(5));
		assertEquals(-2, h.remove(null));
		assertEquals(7, h.getSize());
		assertEquals(2, h.getNumOfElems());
		assertEquals(0.28, h.getLF(), 0.01);
		assertEquals(0, h.find(0));
		assertEquals(0, h.add(0));
		assertEquals(3, h.getNumOfElems());
		assertEquals(0.42, h.getLF(), 0.01);
		System.out.println(h.toString());
	}
}