package p3Arboles;

/** 
 * Titulo: Clase AVLTree
 * Clase derivada de BSTree a√±adiendo funcionalidad de AVL 
 * @author UO281847 
 * @version 05/11/2021 
 */ 
public class AVLTree <T extends Comparable<T> >extends BSTree <T> { 
 
	/** 
	 * Constructor  
	 */ 
	public AVLTree() {
		super();
	} 
  
	/* (non-Javadoc) 
	 * @see BSTree#addNode(java.lang.Comparable) 
	 * Redefine inserci√≥n para funcionalidad AVL 
	 */ 
	public int addNode (T info){		
		try {			
			if (info!=null) {				
				setRoot(recursiveAddNode(info, (AVLNode<T>) getRoot()));
				return 0;				
			}
			return -2;
		} catch (RuntimeException e) {
			return -1;
		}
	}
	
	/**
	 * MÈtodo recursivo de aÒadir nodo al arbol
	 * 
	 * @param info, info del nodo
	 * @param raiz, raiz del nodo
	 * @return nodo, nodo
	 */
	private AVLNode<T> recursiveAddNode(T info, AVLNode<T> raiz){		
		if (raiz == null) {
			return new AVLNode<T>(info);
		}
		if (info.equals(raiz.getInfo())) {
			throw new RuntimeException("El nodo ya existe");
		}
		if (info.compareTo(raiz.getInfo()) < 0) {
			raiz.setLeft(recursiveAddNode(info, raiz.getLeft()));
		} else if (info.compareTo(raiz.getInfo()) > 0) {
			raiz.setRight(recursiveAddNode(info, raiz.getRight()));
		}
		return updateAndBalanceIfNecesary(raiz);
	}
	
	/** 
	 * se le pasa el arbol que se quiere actualizar Height, BF  
	 * y balancear si fuese necesario 
	 * y devuelve la raiz del arbol por si ha cambiado
	 * 
	 * @param raiz, raiz del nodo
	 * @return nodo, nodo
	 */ 
	private AVLNode<T> updateAndBalanceIfNecesary (AVLNode<T> raiz){		
		raiz.updateHeight();
		if (raiz.getBF() == 2) {
			if (raiz.getRight().getBF() >= 0) {
				raiz = singleRightRotation (raiz);				
			} else {
				raiz = doubleRightRotation(raiz);
			}	
									
		} else if (raiz.getBF()==-2) {
			if (raiz.getLeft().getBF() <= 0) {
				raiz = singleLeftRotation (raiz);
			} else {
				raiz = doubleLeftRotation(raiz);				
			}		
		}		
		return (raiz); 
	}
 
	/** 
	 * Se le pasa la raiz del arbol a balancear con rotacion simple 
	 * devuelve la raiz del nuevo arbol que ha cambiado 
	 * 
	 * @param raiz, raiz del nodo
	 * @return aux, nodo auxiliar
	 */ 
	private AVLNode<T> singleLeftRotation (AVLNode<T> raiz){
		AVLNode<T> aux = raiz.getLeft();
		raiz.setLeft(aux.getRight());
		aux.setRight(raiz);		
		updateAndBalanceIfNecesary(raiz);
		return updateAndBalanceIfNecesary(aux);
	} 
 
 
	/** 
	 * Se le pasa la raiz del arbol a balancear con rotacion doble 
	 * devuelve la raiz del nuevo arbol que ha cambiado 
	 * 
	 * @param raiz, raiz del nodo
	 * @return aux, nodo auxiliar
	 */ 
	private AVLNode<T> doubleLeftRotation(AVLNode<T> raiz) {
		raiz.setLeft(singleRightRotation(raiz.getLeft()));
		return singleLeftRotation(raiz);
	}
 
	/** 
	 * Se le pasa la raiz del arbol a balancear con rotacion simple 
	 * devuelve la raiz del nuevo arbol que ha cambiado
	 * 
	 * @param raiz, raiz del nodo
	 * @return aux, nodo auxiliar
	 */ 
	private AVLNode<T> singleRightRotation (AVLNode<T> raiz){
		AVLNode<T> aux = raiz.getRight();
		raiz.setRight(aux.getLeft());
		aux.setLeft(raiz);
		updateAndBalanceIfNecesary(raiz);
		return updateAndBalanceIfNecesary(aux);
	}  
	/** 
	 * Se le pasa la raiz del arbol a balancear con rotacion doble 
	 * Devuelve la raiz del nuevo arbol que ha cambiado 
	 * 
	 * @param raiz, raiz del nodo
	 * @return aux, nodo auxiliar
	 */ 
	private AVLNode<T> doubleRightRotation(AVLNode<T> raiz) {
		raiz.setRight(singleLeftRotation(raiz.getRight()));
		return singleRightRotation(raiz);
	}
 
	/* (non-Javadoc) 
	 * @see BSTree#removeNode(java.lang.Comparable) 
	 * Redefinici√≥n para incluir caracter√≠sticas AVL 
	 */ 
	public int removeNode (T info) {
		try {			
			if (info!=null) {				
				setRoot(recursiveRemoveNode(info, (AVLNode<T>) getRoot()));
				return 0;				
			}
			return -2;
		} catch (RuntimeException e) {
			return -1;
		}
	}
	/**
	 * MÈtodo recursivo de removeNode
	 * 
	 * @param info, info del nodo
	 * @param raiz, raiz del nodo
	 * @return nodo, nodo actualizado
	 */
	private AVLNode<T> recursiveRemoveNode(T info, AVLNode<T> raiz) {
		if (raiz==null) {
			throw new RuntimeException("El nodo no existe");
		} else if (info.compareTo(raiz.getInfo()) < 0 ) {
			raiz.setLeft(recursiveRemoveNode(info, raiz.getLeft()));
		} else if (info.compareTo(raiz.getInfo()) > 0 ) {
			raiz.setRight(recursiveRemoveNode(info, raiz.getRight()));
		} else if (info.equals(raiz.getInfo())) {
			if (raiz.getLeft()==null) {
				return raiz.getRight();
			} else if (raiz.getRight()==null) {
				return raiz.getLeft();
			}
			raiz.setInfo(maxNode(raiz.getLeft()));
			raiz.setLeft(recursiveRemoveNode(raiz.getInfo(), raiz.getLeft()));			
		}
		raiz.updateHeight();
		return updateAndBalanceIfNecesary(raiz);	
	}
} 