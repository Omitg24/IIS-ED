package p3Arboles;

/**
 * Titulo: Interfaz EDPriorityQueue
 * 
 * @author UO281847
 * @version 19/11/2021
 */
public interface EDPriorityQueue<T extends Comparable<T>> {

	/**
	 * Se le pasa el elemento que se quiere insertar en la cola
	 * devuelve 0 si consigue insertarlo, negativo en caso contrario (-1 si no cabe, -2 cualquier otra causa)
	 * Si hay varios errores, se suman
	 * 
	 * @param elemento, elemento
	 * @return 0, -1 0 -2
	 */
	public int add(T elemento);

	/** 
	 * Devuelve y elimina el elemento con mayor prioridad (cima del monticulo), 
	 * o null si no hay elementos
	 * 
	 * @return min o null
	 */
	public T poll();
	
	/**
	 * Borra un elemento de la cola
	 * Se le pasa el elemento que se quiere eliminar de la cola
	 * devuelve 0 si estaba y lo elimina, negativo en caso contrario 
	 * (-1 si no estaba, -2 otras causas)
	 * 
	 * @param elemento, elemento
	 * @return 0 o -1
	 */
	public int remove (T elemento);

	/**
	 * Indica si no hay ningun elemento
	 * 
	 * @return true o false
	 */
	public boolean isEmpty();
	
	/**
	 * Elimina todos los elementos de la cola
	 */
	public void clear();
	
	/**  
	 * Devuelve una cadena con la informacion de los elementos que contiene el  
	 * monticulo en forma visible (recomendado inorden-derecha-izquierda tabulado)  
	 * 
	 * @return string, toString de la cadena
	*/
	public String toString();
}

