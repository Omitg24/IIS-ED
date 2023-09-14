package p3Arboles.Pruebas;

import p3Arboles.EDPriorityQueue;

/**
 * Titulo: Clase EDBinaryHeap
 * 
 * @author UO281847
 * @version 19/11/2021
 */
 public class EDBinaryHeapPruebas<T extends Comparable<T>> implements EDPriorityQueue<T>{
	/**
	 * Atributo elementos
	 */
	protected T[] elementos;
	/**
	 * Atributo elementos 
	 */ 
	protected int numElementos;

	/**
	 * Constructor 
	 * 
	 * @param numMaxElementos, numero máximo de elementos
	 */
	@SuppressWarnings("unchecked")
	public EDBinaryHeapPruebas(int numMaxElementos) {
		elementos = (T[]) new Comparable[numMaxElementos];
	}
	
	/**
	 * Se le pasa el elemento que se quiere insertar en la cola
	 * devuelve 0 si consigue insertarlo, negativo en caso contrario (-1 si no cabe, -2 cualquier otra causa)
	 * Si hay varios errores, se suman
	 * 
	 * @return 0, -1 0 -2
	 */
	@Override
	public int add(T info) {
		int possibleError = addWrongError(info);
		if (possibleError != 0) { 
			return possibleError;
		} else {
			if (isEmpty()) {
				return addFirst(info);
			} else {
				return addNormal(info);
			}			
		}		
	}
	
	/**
	 * Método que añade al principio el nodo
	 * 
	 * @param info, info del nodo
	 * @return 0
	 */
	private int addFirst(T info) {
		numElementos++;
		elementos[0] = info;		
		return 0;
	}
	
	/**
	 * Método que añade el nodo en el siguiente lugar posible del montículo
	 * 
	 * @param info, info del nodo
	 * @return 0
	 */
	private int addNormal(T info) {
		numElementos++;
		elementos[numElementos-1] = info;		
		filtradoAscendente(numElementos-1);
		return 0;
	}
	
	/**
	 * Método que comprueba los erores posibles de añadir el nodo
	 * 
	 * @param info, info del nodo
	 * @return 0, -1 o -2
	 */
	private int addWrongError(T info) {
		int error = 0;
		if (isFull()) {
			error = error - 1;
		} 
		if (info == null) {
			error = error - 2;
		}
		return error;
	}
	
	/** 
	 * Devuelve y elimina el elemento con mayor prioridad (cima del monticulo), 
	 * o null si no hay elementos
	 * 
	 * @return min o null
	 */
	@Override
	public T poll() {
		if (isEmpty()) {
			return null;
		} else {
			T min = elementos[0];
			elementos[0] = elementos[numElementos-1];
			elementos[numElementos-1] = null;
			numElementos--;
			filtradoDescendente(0);
			return min;
		}		
	}

	/**
	 * Borra un elemento de la cola
	 * Se le pasa el elemento que se quiere eliminar de la cola
	 * devuelve 0 si estaba y lo elimina, negativo en caso contrario 
	 * (-1 si no estaba, -2 otras causas)
	 * 
	 * @param info, info del nodo
	 * @return 0 o -1
	 */
	@Override
	public int remove(T info) {
		if(isEmpty()) {
			return -1;
		} else if (info==null) {
			return -2;
		} else {
			int pos = search(info);
			if (pos==-1) {
				return pos;
			} else {
				elementos[pos]=elementos[numElementos-1];
				elementos[numElementos-1] = null;
				numElementos--;
				filtradoDescendente(pos);			
			}		
		}
		return 0;
	}
	/**
	 * Método que busca el elemento en el array
	 * 
	 * @param info, info del nodo
	 * @return i o -1
	 */
	private int search(T info) {		
		for (int i=0; i<numElementos;i++) {
			if (elementos[i].equals(info)) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * Indica si no hay ningun elemento
	 * 
	 * @return true o false
	 */
	@Override
	public boolean isEmpty() {
		return numElementos==0;
	}
	
	/**
	 * Indica si está lleno el monitculo
	 * 
	 * @return true o false
	 */
	private boolean isFull() {
		return numElementos==elementos.length;
	}

	/**
	 * Elimina todos los elementos de la cola
	 */
	@Override
	public void clear() {
		for (int i=0; i<elementos.length; i++) {
			elementos[i]=null;
		}
		numElementos=0;			
	}

	/**  
	 * Devuelve una cadena con la informacion de los elementos que contiene el  
	 * monticulo en forma visible (recomendado inorden-derecha-izquierda tabulado)  
	 * 
	 * @return string, toString de la cadena
	*/
	public String toString() {
	// Por ejemplo el arbol tumbado...  
		StringBuilder cadena = new StringBuilder();  
		cadena.append(inOrdenDerechaTabulado(0,0));  
		return cadena.toString();   
	}


	/**
	 * Método auxiliar para el toString
	 * 
	 * @param p, p
	 * @param esp, esp
	 * @return toString
	 */
    // el arbol que empieza en indice p tumbado con esp tabulaciones..
    private String inOrdenDerechaTabulado(int p,int esp) {
        String cadena="";
        if (p<numElementos) {
            int izq = Math.abs(2*p+1);
            int der = Math.abs(2*p+2);
            cadena+=inOrdenDerechaTabulado(der,esp+1);
            for(int i = 0;i<esp;i++)
                cadena+="\t";
            cadena += elementos[p]+"\n";
            cadena+=inOrdenDerechaTabulado(izq,esp+1);
        }
        return cadena;
    }

    /**
     * Realiza una filtrado ascendente de minimos en el monticulo
     * 
     * Se le pasa el indice del elemento a filtrar
     * 
     * @param i, index
     */
    protected void filtradoAscendente(int i) {	
    	int pos = (i-1)/2;
    	if (pos>=0) { //Comprobación de que se puede añadir
	    	if (elementos[i].compareTo(elementos[pos])<0) {
	    		T aux = elementos[i];
	    		elementos[i] = elementos[pos];
	    		elementos[pos] = aux;
	    		filtradoAscendente(pos);
	    	}
    	}
    }

    /**
     * Realiza una filtrado descendente de minimos en el monticulo
     * 
     * Se le pasa el indice del elemento a filtrar
     * 
     * @param i, index
     */
    protected void filtradoDescendente(int i) {
    	int posL = Math.abs(2*i+1);
    	int posR = Math.abs(2*i+2);
    	if (posL < elementos.length && posR < elementos.length) { //Comprobación de que se puede añadir
    		if (elementos[posR] != null) { //Tiene 2 hijos
    			if (elementos[i].compareTo(elementos[posL])>0 && 
    					elementos[i].compareTo(elementos[posR])>0) { //El padre es mayor que sus dos hijos
    				if (elementos[posR].compareTo(elementos[posL])>0) { //El hijo izquierdo es menor que el derecho
    					T aux = elementos[i];
    		    		elementos[i] = elementos[posL];
    		    		elementos[posL] = aux;    		    		
    		    		filtradoDescendente(posL);
    				} else { //El hijo derecho es menor que el izquierdo
    					T aux = elementos[i];
    		    		elementos[i] = elementos[posR];
    		    		elementos[posR] = aux;
    		    		filtradoDescendente(posR);
    				} 
    			} else if (elementos[i].compareTo(elementos[posL])>0) { //El padre es mayor que su hijo izquierdo
    				T aux = elementos[i];
		    		elementos[i] = elementos[posL];
		    		elementos[posL] = aux;		    		
		    		filtradoDescendente(posL);
    			} else if (elementos[i].compareTo(elementos[posR])>0) { //El padre es mayor que su hijo derecho
    				T aux = elementos[i];
		    		elementos[i] = elementos[posR];
		    		elementos[posR] = aux;
		    		filtradoDescendente(posR);
    			} 
    		} else if (elementos[posL] != null){ //Tiene 1 hijo (el izquierdo)
    			if (elementos[i].compareTo(elementos[posL])>0) { //El padre es mayor que su hijo
	    			T aux = elementos[i];
		    		elementos[i] = elementos[posL];
		    		elementos[posL] = aux;
		    		filtradoDescendente(posL);
    			}
    		}
    	}
    }
    
    /**
     * Método que devuelve el máximo de la cola de prioridad
     * 
     * @return max, maximo de la cola
     */
    public T devolverMaximo() {
    	int mitad = elementos.length/2;
    	
    	T max = elementos[mitad];
    	
    	for  (int i=mitad; i<elementos.length; i++) {
    		if (elementos[i]!=null) {
    			if (max.compareTo(elementos[i])<0) {
        			max = elementos[i];
        		}
    		}    		
    	}
    	
    	return max;
    }
    
    /**
     * Método que busca el elemento pasado como parámetro, lo compara con el de la 
     * posición pasada y en función de si es mayor o menor realiza un filtrado 
     * descendente o ascendente respectivamente. Condiciones: si el monticulo está
     * vacío devuelve -1. Si la posición no es válida devuelve -2, Subi sustituye el
     * elemento que había en la poisición por el nuevo, realiza un filtrado ascendente 
     * o descendente en función de si es menor o mayor que el elemento recién 
     * cambiado y devuelve 0.
     * 
     * @param pos, posicion
     * @param elemento, elemento
     * @return 0, -1 o -2
     */
    public int cambiarPrioridad(int pos, T elemento) {
    	if (isEmpty()) {
    		return -1;
    	} else if (pos < 0 || pos >= numElementos || elemento == null) {
    		return -2;
    	} else {
    		T original = this.elementos[pos];
    		this.elementos[pos] = elemento;
    		if (elemento.compareTo(original)>0) {
    			filtradoDescendente(pos);
    		} else if (elemento.compareTo(original)<0) {
    			filtradoAscendente(pos);
    		}
    	}
    	return 0;
    }
    /**
     * Método que devuelve el recorrido en preOrden del monticulo
     * @return preOrder
     */
    public String preOrder() {
    	String cadena = "";
    	if (isEmpty()) {
    		return cadena;
    	}
    	return recursivePreOrder(0);
    }
    /**
     * Método que devuelve el recorrido en preOrden del monticulo
     * @return preOrder
     */
	private String recursivePreOrder(int i) {
		String cadena = elementos[i].toString();
		cadena = cadena + "-";
		if (2*i+1 < numElementos) {
			cadena = cadena + recursivePreOrder(2*i+1);
		}
		if (2*i+2 < numElementos) {
			cadena = cadena + recursivePreOrder(2*i+2);
		}
		return cadena;
	}
    /**
     * Método que devuelve el recorrido en inOrden del monticulo
     * @return inOrder
     */
	public String inOrder() {
    	String cadena = "";
    	if (isEmpty()) {
    		return cadena;
    	}
    	return recursiveInOrder(0);
    }
	/**
     * Método que devuelve el recorrido en inOrden del monticulo
     * @return inOrder
     */
	private String recursiveInOrder(int i) {
		String cadena = "";
		if (2*i+1 < numElementos) {
			cadena = cadena + recursiveInOrder(2*i+1);
		}
		cadena = cadena +  elementos[i].toString();
		cadena = cadena + "-";
		if (2*i+2 < numElementos) {
			cadena = cadena + recursiveInOrder(2*i+2);
		}
		return cadena;
	}
	/**
     * Método que devuelve el recorrido en postOrden del monticulo
     * @return postOrder
     */
	public String postOrder() {
    	String cadena = "";
    	if (isEmpty()) {
    		return cadena;
    	}
    	return recursivePostOrder(0);
    }
	/**
     * Método que devuelve el recorrido en postOrden del monticulo
     * @return postOrder
     */
	private String recursivePostOrder(int i) {
		String cadena = "";
		if (2*i+1 < numElementos) {
			cadena = cadena + recursivePostOrder(2*i+1);
		}		
		if (2*i+2 < numElementos) {
			cadena = cadena + recursivePostOrder(2*i+2);
		}
		cadena = cadena + elementos[i].toString();
		cadena = cadena + "-";
		return cadena;
	}
}