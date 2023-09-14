package p3Arboles.Pruebas;


/**
 * Titulo: Clase AVLNode
 * Clase derivada de BSTNode añadiendo funcionalidad de AVL
 * 
 * @author UO281847
 * @version 05/11/2021 
 */
public class AVLNodePruebas<T extends Comparable<T>> extends BSTNodePruebas<T>  {
	/**
	 * Para almacenar la altura del nodo
	 */
	protected int height;

	/**
	 * Para almacenar al Factor de balance.
	 * Puede no existir y calcularse cada vez a partir de la altura de los hijos.
	 */
	protected int balanceFactor;

	/**
	 * Llama al padre y aÃ±ade la informacion propia
	 * se le pasa la informacion que se mete en el nuevo nodo
	 * 
	 * @param info, info del nodo
	 */
	public AVLNodePruebas(T info){
		super(info);
		height=1;
		balanceFactor=0;
	}

	/**
	 * devuelve la altura del arbol del cual es raiz el nodo en cuestion
	 * 
	 * @return height, altura
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Devuelve el factor de balance segun equilibrio del arbol del cual es raiz
	 * 
	 * @return balanceFactor, factor de balance
	 */
	public int getBF() {
		return balanceFactor;
	}

	/**
	 * Actualiza la altura del nodo en el arbol utilizando la altura de los hijos
	 * y si es preciso actualiza el FB
	 */
	protected void updateHeight() {
		int heightR = 0;
		int heightL = 0;
		
		if (getLeft() != null) {
			heightL = getLeft().getHeight();
		}		
		if (getRight() != null) {
			heightR = getRight().getHeight();
		}
		
		this.balanceFactor = heightR - heightL;
		height = 1 + Math.max(heightR, heightL);
	}


	/* (non-Javadoc)
	 * @see BSTNode#getLeft()
	 */
	public AVLNodePruebas<T> getLeft(){
		return (AVLNodePruebas<T>) super.getLeft();
	}


	/* (non-Javadoc)
	 * @see BSTNode#getRight()
	 */
	public AVLNodePruebas<T> getRight() {
		return (AVLNodePruebas<T>) super.getRight();
	}

	/* (non-Javadoc)
	 * @see BSTNode#toString()
	 * Añade factor de balance
	 */
	public String toString() {
		return super.toString()+":BF="+ getBF();
	}

}