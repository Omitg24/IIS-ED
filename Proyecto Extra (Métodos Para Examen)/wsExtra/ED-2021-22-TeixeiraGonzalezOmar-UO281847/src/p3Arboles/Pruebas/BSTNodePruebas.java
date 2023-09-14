package p3Arboles.Pruebas;

/** 
 * Titulo: Clase BSTNode
 * 
 * @author UO281847
 * @version 05/11/2021
 */
public class BSTNodePruebas <T extends Comparable<T>>{ 
	/**
	 * Atributo info
	 */
	private T info;
	/**
	 * Atributo left
	 */
	private BSTNodePruebas<T> left;
	/**
	 * Atributo right
	 */
	private BSTNodePruebas<T> right;   
	/** 
	* Se le pasa un objeto comparable
	* 
	* @param info, info
	*/ 
	public BSTNodePruebas (T info) {
		setInfo(info);
		setLeft(null);
		setRight(null);		
	} 	 
	/** 
	* Se le pasa la informacion que se quiere meter en el nodo
	* 
	* @param info, info
	*/ 
	protected void setInfo(T info) {
		this.info = info;
	} 	 
	/** 
	* Devuelve la informacion que almacena el nodo
	* 
	* @return info, info
	*/ 
	public T getInfo() {
		return info;
	} 	 
	/** 
	* Se le pasa el nodo que se quiere enlazar en el subarbol izquierdo
	* 
	* @param left, izquierda 
	*/ 
	public void setLeft(BSTNodePruebas<T> left){
		this.left = left;
	} 	
	/** 
	* Se le pasa el nodo que se quiere enlazar en el subarbol derecho 
	* 
	* @param right, derecha
	*/ 
	public void setRight(BSTNodePruebas<T> right){
		this.right = right;
	} 
	/** 
	* Devuelve el subarbol izquierdo 
	* 
	* @return left, left
	*/ 
	public BSTNodePruebas<T> getLeft () {
		return left;
	} 	
	/** 
	* Devuelve el subarbol derecho 
	* 
	* @return left, left
	*/ 
	public BSTNodePruebas<T> getRight () {
		return right;
	} 	
	/* (non-Javadoc) 
	* @see java.lang.Object#toString() 
	*/ 
	public String toString() { 
		return info.toString(); 
	}  
} 