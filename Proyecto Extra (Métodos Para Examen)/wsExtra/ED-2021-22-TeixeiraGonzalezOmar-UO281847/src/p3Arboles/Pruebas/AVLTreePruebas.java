package p3Arboles.Pruebas;

/** 
 * Titulo: Clase AVLTree
 * Clase derivada de BSTree a√±adiendo funcionalidad de AVL 
 * @author UO281847 
 * @version 05/11/2021 
 */ 
public class AVLTreePruebas <T extends Comparable<T> >extends BSTreePruebas <T> { 
 
	/** 
	 * Constructor  
	 */ 
	public AVLTreePruebas() {
		super();
	} 
  
	/* (non-Javadoc) 
	 * @see BSTree#addNode(java.lang.Comparable) 
	 * Redefine inserci√≥n para funcionalidad AVL 
	 */ 
	public int addNode (T info){		
		try {			
			if (info!=null) {				
				setRoot(recursiveAddNode(info, (AVLNodePruebas<T>) getRoot()));
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
	private AVLNodePruebas<T> recursiveAddNode(T info, AVLNodePruebas<T> raiz){		
		if (raiz == null) {
			return new AVLNodePruebas<T>(info);
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
	private AVLNodePruebas<T> updateAndBalanceIfNecesary (AVLNodePruebas<T> raiz){		
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
	private AVLNodePruebas<T> singleLeftRotation (AVLNodePruebas<T> raiz){
		AVLNodePruebas<T> aux = raiz.getLeft();
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
	private AVLNodePruebas<T> doubleLeftRotation(AVLNodePruebas<T> raiz) {
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
	private AVLNodePruebas<T> singleRightRotation (AVLNodePruebas<T> raiz){
		AVLNodePruebas<T> aux = raiz.getRight();
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
	private AVLNodePruebas<T> doubleRightRotation(AVLNodePruebas<T> raiz) {
		raiz.setRight(singleLeftRotation(raiz.getRight()));
		return singleRightRotation(raiz);
	}
	
	/**
	* Se le pasa un objeto comparable que se busca
	* Devuelve el objeto encontrado que cumple que es "equals" con el
	* buscado, null si no lo encuentra por cualquier motivo
	* 
	* @param info, info del nodo
	* @return info, info del nodo
	*/
	public AVLNodePruebas<T> searchNode(T info) {
		if (info==null) {
			return null;
		}		
		return recursiveSearch(info, (AVLNodePruebas<T>) getRoot());
	}
	/**
	 * MÈtodo recursivo de busqueda del nodo
	 * 
	 * @param info, info del nodo
	 * @param raiz, raiz del nodo
	 * @return true o false
	 */
	private AVLNodePruebas<T> recursiveSearch(T info, AVLNodePruebas<T> raiz) {
		if (raiz == null) {
			return null;
		}
		if (raiz.getInfo().equals(info)) {
			return raiz;
		}		
		if (raiz.getInfo().compareTo(info) > 0) {
			return recursiveSearch(info, raiz.getLeft());
		} else {
			return recursiveSearch(info, raiz.getRight());
		}
	}	
 
	/* (non-Javadoc) 
	 * @see BSTree#removeNode(java.lang.Comparable) 
	 * Redefinici√≥n para incluir caracter√≠sticas AVL 
	 */ 
	public int removeNode (T info) {
		try {			
			if (info!=null) {				
				setRoot(recursiveRemoveNode(info, (AVLNodePruebas<T>) getRoot()));
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
	private AVLNodePruebas<T> recursiveRemoveNode(T info, AVLNodePruebas<T> raiz) {
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
	
	/**
	 * MÈtodo que devuelve el padre de un elemento
	 * 
	 * @param clave, clave a devolver el padre
	 * @return padre
	 */
	public T padreDe(T clave){
		if (clave == null) {
			return null;
		} 
		return recursivePadreDe(clave, (AVLNodePruebas<T>) getRoot());
	}

	/**
	 * MÈtodo recursivo del padre
	 * 
	 * @param clave, clave a devolver el padre
	 * @param raiz, raiz
	 * @return padre
	 */
	private T recursivePadreDe(T clave, AVLNodePruebas<T> raiz) {
		if (raiz.getLeft() != null) {
			if (clave.equals(raiz.getLeft().getInfo())) {
				return raiz.getInfo();
			} else if (clave.compareTo(raiz.getInfo()) < 0) {
				return recursivePadreDe(clave, raiz.getLeft());
			}
		}
		if (raiz.getRight() != null) {
			if (clave.equals(raiz.getRight().getInfo())) {
				return raiz.getInfo();
			} else if (clave.compareTo(raiz.getInfo()) > 0 ) {
				return recursivePadreDe(clave, raiz.getRight());
			}
		}
		return null;
		
//		if (raiz.getLeft()!=null && raiz.getRight()!=null) {
//			if (clave.equals(raiz.getLeft().getInfo()) || clave.equals(raiz.getRight().getInfo())) {
//				return raiz.getInfo();
//			} else if (clave.compareTo(raiz.getInfo()) < 0) {
//				return recursivePadreDe(clave, raiz.getLeft());
//			} else if (clave.compareTo(raiz.getInfo()) > 0 ) {
//				return recursivePadreDe(clave, raiz.getRight());
//			}
//		} else if (raiz.getLeft() != null) {
//			if (clave.equals(raiz.getLeft().getInfo())) {
//				return raiz.getInfo();
//			} else if (clave.compareTo(raiz.getInfo()) < 0) {
//				return recursivePadreDe(clave, raiz.getLeft());
//			}
//		} else if (raiz.getRight() != null) {
//			if (clave.equals(raiz.getRight().getInfo())) {
//				return raiz.getInfo();
//			} else if (clave.compareTo(raiz.getInfo()) > 0 ) {
//				return recursivePadreDe(clave, raiz.getRight());
//			}
//		}
//		return null;
	}
	
	/**
	 * MÈtodo que devuelve el numero de aristas entre dos nodos del arbol
	 * 
	 * @param clave1, clave 1 del arbol
	 * @param clave2, clave 2 del arbol
	 * @return numAristas
	 */
	public int numAristas(T clave1, T clave2) {
		if (clave1==null || clave2 == null || clave1.equals(clave2)) {
			return -1;
		}
		return recursiveNumAristas(searchNode(clave1),searchNode(clave2));
	}
	
	/**
	 * MÈtodo recursivo que devuelve el numero de aristas entre dos nodos del arbol
	 * 
	 * @param clave1, clave 1 del arbol
	 * @param clave2, clave 2 del arbol
	 * @return numAristas
	 */
	private int recursiveNumAristas(AVLNodePruebas<T> clave1, AVLNodePruebas<T> clave2) {
		if(clave1 == null) {
			return 0;
		}
		if (clave1.getInfo().compareTo(clave2.getInfo()) > 0) {
			return recursiveNumAristas(clave1.getLeft(), clave2) + 1;
		} else if (clave1.getInfo().compareTo(clave2.getInfo()) < 0) {
			return recursiveNumAristas(clave1.getRight(), clave2) + 1;
		} else {
			return 0;
		}
	}
	
	/**
	 * MÈtodo que devuelve el hermano
	 * 
	 * @param clave, clave del nodo
	 * @return hermano
	 */
	@SuppressWarnings("unlikely-arg-type")
	public T getHermano(T clave) {
		if (clave == null || clave.equals(getRoot())) {
			return null;
		} 
		return recursiveHermanoDe(clave, (AVLNodePruebas<T>) getRoot());
	}
	
	/**
	 * MÈtodo recursivo que devuelve el hermano
	 * 
	 * @param clave, clave del nodo
	 * @param raiz, raiz
	 * @return hermano
	 */
	private T recursiveHermanoDe(T clave, AVLNodePruebas<T> raiz) {
		if (raiz.getLeft() != null) {
			if (clave.equals(raiz.getLeft().getInfo())) {
				if (raiz.getRight() != null) {
					return raiz.getRight().getInfo();
				}
				return null;
			} else if (clave.compareTo(raiz.getInfo()) < 0) {
				return recursiveHermanoDe(clave, raiz.getLeft());
			}
		}
		if (raiz.getRight() != null) {
			if (clave.equals(raiz.getRight().getInfo())) {
				if (raiz.getLeft() != null) {
					return raiz.getLeft().getInfo();
				}
				return null;
			} else if (clave.compareTo(raiz.getInfo()) > 0) {
				return recursiveHermanoDe(clave, raiz.getRight());
			} 
		}
		return null;
	}
	
	/**
	 * MÈtodo que calcula la media de los factores de balance del arbol
	 * @return media
	 */
	public double mediaBF() {
		double sumaBF = recursiveSumarBF((AVLNodePruebas<T>) getRoot());
		double numNodes = recursiveContarNodos((AVLNodePruebas<T>) getRoot());
		return sumaBF / numNodes;
	}
	
	/**
	 * MÈtodo que calcula la suma de los factores de balance del arbol
	 * @return media
	 */
	private double recursiveSumarBF(AVLNodePruebas<T> node) {
		if (node==null) {
			return 0;
		}
		return node.getBF() + recursiveSumarBF(node.getLeft()) + recursiveSumarBF(node.getRight());
	}
	
	/**
	 * MÈtodo que calcula el numero total de nodos del arbol
	 * @return media
	 */
	private double recursiveContarNodos(AVLNodePruebas<T> node) {
		if (node==null) {
			return 0;
		}
		return 1 + recursiveContarNodos(node.getLeft()) + recursiveContarNodos(node.getRight());
	}
	
	/**
	 * MÈtodo que calcula el porcentaje de numero de nodos intermedios del arbol
	 * @return porcentaje
	 */
	public double porcentajeNodosIntermedios() {		
		double numIntermedios = recursiveContarNodosIntermedios((AVLNodePruebas<T>) getRoot());
		double numNodes = recursiveContarNodos((AVLNodePruebas<T>) getRoot());
		if (numNodes==0) {
			return 0;
		}
		return (numIntermedios/numNodes)*100;
	}
	
	/**
	 * MÈtodo que calcula el numero de nodos intermedios del arbol
	 * @return nodos intermedios
	 */
	private double recursiveContarNodosIntermedios(AVLNodePruebas<T> node) {
		if (node.getRight()==null && node.getLeft()==null) {
			return 0;
		} else if (node.getRight()==null) {
			return recursiveContarNodosIntermedios(node.getLeft());
		} else if (node.getLeft()==null) {
			return recursiveContarNodosIntermedios(node.getRight());
		}
		return 1 + recursiveContarNodosIntermedios(node.getLeft()) + recursiveContarNodosIntermedios(node.getRight());
	}
	
	/**
	 * Metodo que devuelve el camino entre dos nodos
	 * 
	 * @param clave1 que es la clave del nodo 1
	 * @param clave2 que es la clave del nodo 2
	 * @return null si la clave es null o el elemento no existe o la llamada al metodo recursivo en caso correcto
	 */
	public String camino(T clave1, T clave2) {
		if(clave1 == null || clave2 == null) {
			return null;
		}
		
		AVLNodePruebas<T> nodo1 = searchNode(clave1);
		AVLNodePruebas<T> nodo2 = searchNode(clave2);		
		
		if(nodo1 == null || nodo2 == null) {
			return null;
		}
		
		try {
			return caminoR(nodo1, nodo2);
		} catch (RuntimeException e) {
			return null;
		}
	}
	
	/**
	 * Metodo auxiliar recursivo que calcula el camino entre dos nodos
	 * 
	 * @param clave1 que es el nodo
	 * @param clave2 que es la clave del nodo 2
	 * @return el camino entre dos nodso de tipo String
	 * @throws ElementoNoExisteException
	 */
	private String caminoR(AVLNodePruebas<T> clave1, AVLNodePruebas<T> clave2) throws RuntimeException {
		if(clave1 == null) {
			throw new RuntimeException();
		}
		if(clave2.getInfo().equals(clave1.getInfo())) {
			return clave1.getInfo() + "";
		} else if(clave1.getInfo().compareTo(clave2.getInfo()) > 0) {
			return clave1.getInfo() + "-" + caminoR(clave1.getLeft(), clave2);
		} else {
			return clave1.getInfo() + "-" + caminoR(clave1.getRight(), clave2);
		}
	}
} 