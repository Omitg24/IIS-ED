package p4Hash.Pruebas;

/**
 * Titulo: Clase ClosedHashTable
 * 
 * @author UO281847
 * @version 11/12/2021
 * 
 * @param <T>, genérico
 */
public class ClosedHashTableColisiones<T> extends AbstractHashPruebas<T> {
// IMPORTANTE
//	No cambiar el nombre ni visibilidad de los atributos protected
	/**
	 * Atributo associativeArray
	 */
	protected HashNodePruebas<T> associativeArray[]; 
	/**
	 * Atributo hashSize
	 */
	protected int hashSize;	// tamañoo de la tabla, debe ser un numero primo
	/**
	 * Atributo numElems
	 */
	protected int numElems;	// numero de elementos en la tabla en cada momento.
	/**
	 * Constante LINEAL
	 */
	public static final int LINEAL = 0;	// Tipo de exploracion en caso de colision, por defecto sera LINEAL
	/**
	 * Constante CUADRATICA
	 */
	public static final int CUADRATICA = 1;
	/**
	 * Constante DOBLEHASH
	 */
	public static final int DOBLEHASH = 2;
	/**
	 * Atributo exploracion
	 */
	protected int exploracion; //exploracion que se realizara en caso de colision (LINEAL por defecto)
	/**
	 * Atributo fcUP
	 */
	protected double fcUP;
	/**
	 * Atributo fcDOWN
	 */
	protected double fcDOWN;
	/**
	 * Atributo colisiones;
	 */
	private int colisiones;
	
	/**
	 * Constructor para fijar el tamaño al numero primo >= que el parametro y el tipo de exploraciÃ³n al indicado
	 * el tipo de exploracion(LINEAL=0, CUADRATICA=1, ...), si invalido LINEAL
	 * 
	 * @param tam, tamaño
	 * @param expl, explicacion
	 */
	@SuppressWarnings("unchecked")
	public ClosedHashTableColisiones(int tam, int expl) {
		hashSize = nextPrimeNumber(tam);// Establece un tamaño valido si tam no es primo		
		associativeArray = (HashNodePruebas<T>[]) new HashNodePruebas[hashSize]; // Crea el array de HashNode's
	//	Completar lo que falta...
		for (int i=0; i<hashSize; i++) {
			associativeArray[i] = new HashNodePruebas<T>();
		}
		this.exploracion = expl;
		this.fcUP = 0.5;
		this.fcDOWN = 0.16;
	}

	/**
	 * Constructor para fijar el tamaño al numero primo >= que el parametro
	 * Se le pasa el tamaÃ±o de la table Hash, si no es un numero primo lo ajusta al primo superior
	 * el factor de carga limite, por encima del cual hay que redispersar (directa)
	 * el factor de carga limite, por debajo del cual hay que redispersar (inversa)
	 * el tipo de exploracion(LINEAL=0, CUADRATICA=1, ...), si invalido LINEAL
	 * 
	 * @param tam, tamaño
	 * @param fcUP, fcUp
	 * @param fcDOWN, fcDown
	 * @param expl, exploracion
	 */
	@SuppressWarnings("unchecked")
	public ClosedHashTableColisiones(int tam, double fcUP, double fcDOWN, int expl) { // Para la segunda clase
	//	Completar lo que falta...
		hashSize = nextPrimeNumber(tam);// Establece un tamaño valido si tam no es primo		
		associativeArray = (HashNodePruebas<T>[]) new HashNodePruebas[hashSize]; // Crea el array de HashNode's
		for (int i=0; i<hashSize; i++) {
			associativeArray[i] = new HashNodePruebas<T>();
		}
		this.exploracion = expl;
		this.fcUP = fcUP;
		this.fcDOWN = fcDOWN;
	}

	/**
	 * Devuelve el numero de elementos que contiene la tabla Hash en el momento de la invocacion
	 * 
	 * @return numOfElems, numero de elementos
	 */
	@Override
	public int getNumOfElems() {
	//	Completar lo que falta...
		return numElems;
	}
	/**
	 * Devuelve el tamaño de la tabla Hash
	 * 
	 * @return size, tamaño
	 */
	@Override
	public int getSize() {
	//	Completar lo que falta...
		return hashSize;
	}
	/**
	 * Método que devuelve el factor de carga de la tabla
	 * @return lf, factor de carga
	 */
	public double getLF() {
		return (double) (numElems*1.0)/hashSize;
	}
	/**
	 * Inserta un nuevo elemento en la tabla hash (que se le pasa) y devuelve 0 si lo ha insertado 
	 * o negativo en caso contrario (-1 si no encuentra sitio y -2 si el elemento no es válido)
	 * 
	 * @param elem, elemento a añadir
	 * @return 0, -1 o -2
	 */
	@Override
	public int add(T elem) {
	//	Completar lo que falta...
		if (elem==null) {
			return -2;
		} else if (getNumOfElems()==getSize()) {
			return -1;
		} else {
			int pos = fHash(elem);
			int iteraccion = 1;
			int col = 0;
			//Mientras este lleno, ir a la siguiente posición
			while (associativeArray[pos].getStatus() == HashNodePruebas.LLENO) {
				//Busqueda de la siguiente posicion
				pos = funcionExplor(elem, iteraccion);
				iteraccion++;
				col++;
			}
			
			associativeArray[pos].setInfo(elem);
			numElems++;
			this.colisiones = col;
			
			reDispersion();
			return 0;
		}
	}
	
	/**
	 * Método auxiliar que añade sin producir una redispersion
	 * 
	 * @param elem, elemento a añadir
	 * @return 0, -1 o -2
	 */
	private int addWithoutDispersion(T elem) {
		if (elem==null) {
			return -2;
		} else if (getNumOfElems()==getSize()) {
			return -1;
		} else {
			int pos = fHash(elem);
			int iteraccion = 1;
			//Mientras este lleno, ir a la siguiente posición
			while (associativeArray[pos].getStatus() == HashNodePruebas.LLENO) {
				//Busqueda de la siguiente posicion
				pos = funcionExplor(elem, iteraccion);
				iteraccion++;
			}
			
			associativeArray[pos].setInfo(elem);
			numElems++;
			return 0;
		}
	}
	
	/**
	 * Método que calcula la función de exploración y devuelve el valor de la posición a ocupar
	 * 
	 * @param elem, elemento
	 * @param iter, iteraccion
	 * @return pos, posicion
	 */
	private int funcionExplor(T elem, int iter) {
		if (exploracion == CUADRATICA) {
			return (fHash(elem) + iter*iter)%hashSize;			
		} else if (exploracion == DOBLEHASH) {
			return (fHash(elem) + iter*h(elem))%hashSize;
		} else {
			return (fHash(elem) + iter)%hashSize; 
		}		
	}
	
	/**
	 * Método que se emplea para la exploracion DOBLEHASH
	 * 
	 * @param elem, elemento
	 * @return int, valor
	 */
	private int h(T elem) {
		int R = previousPrimeNumber(getSize() - 1);
		int positiveValue = fHash(elem)%R;
		return R-positiveValue;
	}
	
	/**
	 * Busca y devuelve el elemento (igual al que se le pasa) encontrado en la tabla hash  
	 * o null si no lo encuentra
	 *  
	 * @param elem, elemento a buscar
	 * @return T, elemento
	 */
	@Override
	public T find(T elem) {
	//	Completar lo que falta...
		if (elem==null) {
			return null;
		} else {
			int pos = fHash(elem);
			int iteraccion = 1;		
			int col = 0;
			//Comprobación del tamaño, de la posicion y de que la posición del hash no esta vacío (si lo esta, no se puede encontrar, no hay nada)
			while (iteraccion <= getSize() && associativeArray[pos].getStatus() != HashNodePruebas.VACIO) {
				//Comprobar que hay algo dentro
				if (associativeArray[pos].getStatus() == HashNodePruebas.LLENO) {
					//Comprobar que son iguales
					if (associativeArray[pos].getInfo().equals(elem)) {
						return associativeArray[pos].getInfo();
					}
				} 
				//Busqueda de la siguiente posicion
				pos = funcionExplor(elem, iteraccion);
				
				iteraccion++;
				col++;
				this.colisiones = col;
			}
			return null;
		}

	}
	/**
	 * Borra un elemento (igual al que se le pasa) que se encuentra en la tabla hash 
	 * Devuelve 0 si lo ha borrado o negativo en caso contrario (-1 si no existe, y –2 en otros casos)
	 * 
	 * @param elem, elemento a eliminar
	 * @return 0, -1 o -2
	 */
	@Override
	public int remove(T elem) {
	//	Completar lo que falta...
		if (elem==null) {
			return -2;
		} else if (find(elem) == null || numElems == 0) {
			return -1;
		} else {
			int pos = fHash(elem);
			int iteraccion = 1;
			int col = 0;
			//Comprobación de que la posición no está vacía
			while (associativeArray[pos].getStatus() != HashNodePruebas.VACIO) {
				//Si hay algo en la posición
				if (associativeArray[pos].getStatus() == HashNodePruebas.LLENO) {
					//Si son iguales, lo elimina 
					if (associativeArray[pos].getInfo().equals(elem)) {						
						associativeArray[pos].remove();
						numElems--;
											
						inverseReDispersion();
						
						return 0;
					} 
				}
				pos = funcionExplor(elem, iteraccion);
				
				iteraccion++;
				col++;
				this.colisiones = col;
			}			
			return -1;
		}
	}

	/**
	 * Realiza una redispersion (aumentando el tamaño) al numero primo mayor que el doble del tamaño actual, 
	 * recolocando los elementos, e indicando si lo realiza correctamente o no
	 *  
	 * @return true o false 
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected boolean reDispersion () { // Para la segunda clase
	//	Completar lo que falta...
		if (getLF() > fcUP || getColisiones() >= 3) {
			HashNodePruebas<T>[] previousArray = associativeArray;
			int prevTam = getSize();
			
			int newTam = nextPrimeNumber(getSize()*2);
			associativeArray = new HashNodePruebas[newTam];
			this.numElems = 0;
			this.hashSize = newTam;
			
			for (int i=0; i<hashSize; i++) {
				associativeArray[i] = new HashNodePruebas<T>();
			}
			
			for (int i=0; i < prevTam; i++) {
				if (previousArray[i].getStatus() == HashNodePruebas.LLENO) {
					addWithoutDispersion(previousArray[i].getInfo());
				}				
			}
			return true;
		}
		return false;
	}
	/**
	 * Realiza una redispersion inversa (disminuyendo el tamaño) al número primo menor que la mitad del tamaño actual, 
	 * recolocando los elementos, e indicando si lo realiza correctamente o no 
	 *  
	 * @return true o false 
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected boolean inverseReDispersion() { // Para la segunda clase
	//	Completar lo que falta...
		if (getLF() < fcDOWN) {
			HashNodePruebas<T>[] previousArray = associativeArray;
			int prevTam = getSize();
			
			int newTam = previousPrimeNumber(getSize()/2);
			associativeArray = new HashNodePruebas[newTam];
			this.numElems = 0;
			this.hashSize = newTam;
			
			for (int i=0; i<hashSize; i++) {
				associativeArray[i] = new HashNodePruebas<T>();
			}
			
			for (int i=0; i < prevTam; i++) {
				if (previousArray[i].getStatus() == HashNodePruebas.LLENO) {
					addWithoutDispersion(previousArray[i].getInfo());
				}				
			}
			return true;
		}
		return false;
	}

	/**
	 * Convierte la tabla a una String que se pueda mostrar de forma "visible"
	 * 
	 * @return string, cadena 
	 */
	@Override
	public String toString (){
		StringBuilder cadena=new StringBuilder();
		for (int i=0;i< getSize();i++){
			cadena.append(associativeArray[i]);
			cadena.append(";");
		}
		cadena.append("[Size: ");
		cadena.append(getSize());
		cadena.append(" Num.Elems.: ");
		cadena.append(getNumOfElems());
		cadena.append("]");
		return cadena.toString();
	}
	
	/**
	 * Método que devuelve las colisiones
	 * @return colisiones
	 */
	public int getColisiones() {
		return colisiones;
	}
}
