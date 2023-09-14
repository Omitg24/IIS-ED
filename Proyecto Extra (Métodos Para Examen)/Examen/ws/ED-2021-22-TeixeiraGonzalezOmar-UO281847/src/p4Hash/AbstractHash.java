package p4Hash;

/**
 * Titulo: Clase AbstractHash
 * 
 * @author UO281847
 * @version 11/12/2021
 * 
 * @param <T>, genérico
 */
public abstract class AbstractHash <T>{

	/**
	 * Devuelve el numero de elementos que contiene la tabla Hash en el momento de la invocacion
	 * 
	 * @return numOfElems, numero de elementos
	 */
	abstract public int getNumOfElems();

	/**
	 * Devuelve el tamaño de la tabla Hash
	 * 
	 * @return size, tamaño
	 */
	abstract public int getSize();
	
	/**
	 * Inserta un nuevo elemento en la tabla hash (que se le pasa) y devuelve 0 si lo ha insertado 
	 * o negativo en caso contrario (-1 si no encuentra sitio y -2 si el elemento no es válido)
	 * 
	 * @param elem, elemento a añadir
	 * @return 0, -1 o -2
	 */
	abstract public int  add(T elem);

	/**
	 * Busca y devuelve el elemento (igual al que se le pasa) encontrado en la tabla hash  
	 * o null si no lo encuentra
	 *  
	 * @param elem, elemento a buscar
	 * @return T, elemento
	 */
	abstract public T find(T elem);

	/**
	 * Borra un elemento (igual al que se le pasa) que se encuentra en la tabla hash 
	 * Devuelve 0 si lo ha borrado o negativo en caso contrario (-1 si no existe, y –2 en otros casos)
	 * 
	 * @param elem, elemento a eliminar
	 * @return 0, -1 o -2
	 */
	abstract public int remove(T elem);

	/**
	 * Realiza una redispersion (aumentando el tamaño) al numero primo mayor que el doble del tamaño actual, 
	 * recolocando los elementos, e indicando si lo realiza correctamente o no
	 *  
	 * @return true o false 
	 */
	abstract protected boolean reDispersion ();

	/**
	 * Realiza una redispersion inversa (disminuyendo el tamaño) al número primo menor que la mitad del tamaño actual, 
	 * recolocando los elementos, e indicando si lo realiza correctamente o no 
	 *  
	 * @return true o false 
	 */
	abstract protected boolean inverseReDispersion();

	/**
	 * Convierte la tabla a una String que se pueda mostrar de forma "visible"
	 * 
	 * @return string, cadena 
	 */
	abstract public String toString ();

	/**
	 * Calcula el resultado de aplicar la funcion hash basada en modulo, sobre el parametro  
	 * Utiliza hashCode() y convierte posibles negativos a positivos 
	 * 
	 * @param elem, elemento
	 * @return position, posicion
	 */
	protected int fHash(T elem){ // fHash basada en MODULO... 
		int position=elem.hashCode()%getSize(); 
		return position<0 ? position+getSize() : position; 
	} 

	/**
	 * 
	 * Calcula si un numero positivo es un numero primo, los negativos devuelve que no
	 * 
	 * @param n, el numero que queremos comprobar
	 * @return true si es primo, false en caso contrario
	 */
	protected boolean isPositivePrime(int n){
		if (n<2 || (n>2 && n%2==0))
			 return false;
		if (n<=7)
			 return true;
		for (int i=3;i*i<=n;i+=2) //impares
			 if (n%i==0)
				 return false; // no es primo
		return true;
	 }
	 
	 /**
	  * Método que devuelve el siguiente numero primo
	  * 
	  * @param n, el numero de partida
	  * @return Si el numero es primo, el mismo numero; y sino, el primer primo encontrado MAYOR que el numero de partida
	  */
	protected int nextPrimeNumber(int n){
		if (n<=3) 
			return 3; // No permite primos menores de 3
		for (;!isPositivePrime(n);n++);
		return n;
	 }
	 
	 /**
	  * Método que devuelve el numero primo previo
	  * 
	  * @param n El numero de partida
	  * @return Si el numero es primo, el mismo numero; y sino, el primer primo encontrado MENOR que el numero de partida
	  */
	protected int previousPrimeNumber (int n){
		if (n<=3) // No permite primos menores de 3
			return 3;
		for(;!isPositivePrime(n);n--);
		return n;
	 }

}
