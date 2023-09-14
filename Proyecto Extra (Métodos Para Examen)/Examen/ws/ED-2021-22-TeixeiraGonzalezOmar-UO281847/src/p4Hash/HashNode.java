package p4Hash;

/**
 * Titulo: Clase HashNode
 * 
 * @author UO281847
 * @version 11/12/2021
 *
 * @param <T>, genérico
 */
public class HashNode<T> {
	/**
	 * Atributo info
	 */
	private T info;
	/**
	 * Atributo status
	 */
	private int status;
	
	/**
	 * Constante BORRADO
	 */
	public static final int BORRADO = -1;
	/**
	 * Constante VACIO
	 */
	public static final int VACIO = 0;
	/**
	 * Constante LLENO
	 */
	public static final int LLENO = 1;

	/**
	 * Constructor
	 */
	public HashNode () {
		info = null;
		status=VACIO;
	}
	
	/**
	 * Método que devuelve la info
	 * 
	 * @return info, info del nodo
	 */
	public T getInfo() {
		return info;
	}
	
	/**
	 * Método que elimina el nodo
	 */
	public void remove (){
		status=BORRADO;
	}
	
	/**
	 * Método que setea la info
	 * 
	 * @param elem, elem del nodo
	 */
	public void setInfo(T elem){
		info=elem;
		status=LLENO;
	}
	
	/**
	 * Método que devuelve el status
	 * 
	 * @return status, status del nodo
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * ToString del nodo
	 * 
	 * @return cadena, toString
	 */
	public String toString (){
		StringBuilder cadena=new StringBuilder("{");
		switch (getStatus()){
		case LLENO:
			cadena.append(info);
			break;
		case VACIO:
			cadena.append("_E_");
			break;
		case BORRADO:
			cadena.append("_D_");
		}
		cadena.append("}");
		return cadena.toString();
	}

}
