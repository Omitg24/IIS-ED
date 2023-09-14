//  NO MODIFICAR NOMBRE DE ESTE PAQUETE, crear (si no existe ya) un paquete nuevo en vuestro proyecto que se llame asi: "evalNestor"
//  y meted en el esta clase
package evalNestor;

import p2Grafos.Graph;

/**
 * Titulo: Clase EvalGraph
 * 
 * @author UO281847
 * @version 08/10/2021
 * @param <T>, genérico
 */
public class EvalGraph<T> extends Graph<T> {
	/**
	 * Alumno
	 */
	Alumno alum=new Alumno();

	/**
	 * Constructor EvalGraph
	 * 
	 * @param i, param
	 */
	public EvalGraph(int i) {
		super(i);
	}
	/**
	 * Constructor EvalGraph con más parámetros
	 * 
	 * @param i, param
	 * @param initialNodes, nodos iniciales
	 * @param initialEdges, aristas iniciales
	 * @param initialWeights, pesos iniciales
	 */
	public EvalGraph(int i,T initialNodes[], boolean[][] initialEdges, double [][] initialWeights){
		super(i,initialNodes,initialEdges,initialWeights);
	}

	/**
	 * Constructor EvalGraph con aún más parametros
	 * 	
	 * @param i, param
	 * @param initialNodes, nodos iniciales
	 * @param initialEdges, aristas iniciales
	 * @param initialWeights, pesos iniciales
	 * @param initialAfloyd, matriz A de Floyd inicial
	 * @param initialPfloyd, matriz P de Floyd inicial
	 */// nuevo constructor en EvalGraph
    public EvalGraph(int i,T initialNodes[], boolean[][] initialEdges, double [][] initialWeights, double [][] initialAfloyd, int [][] initialPfloyd){ 
        super(i,initialNodes,initialEdges,initialWeights,initialAfloyd,initialPfloyd); 
    } 
    
    /**
     * Método que devuelve el nombre del fichero del alumno
     *  
     * @return fichero, nombre del fichero
     */
	public String getNombreFicheroAlumno(){
		return alum.getNombreFicheroAlumno();
	}
}


/*  //  deben estar incluidos estos constructores en la clase Graph 
	public Graph (int tam, T initialNodes[], boolean[][] initialEdges, double [][] initialWeights) {
		// Llama al constructor original
		this(tam); 
		
		// Pero modifica los atributos con los parametros para hacer pruebas...
		numNodes = initialNodes.length;
		
		for (int i=0;i<numNodes;i++) {
			// Si el vector de nodos se llama de otra forma (distinto de "nodes"), refactorizar para que se llama "nodes"
			nodes[i]=initialNodes[i];
			for (int j=0;j<numNodes;j++){
				// Si la matriz de aristas se llama de otra forma (distinto de "edges"), refactorizar para que se llama "edges"
				edges[i][j]=initialEdges[i][j];
				// Si la matriz de pesos se llama de otra forma (distinto de "weights"), refactorizar para que se llama "weights"
				weights[i][j]=initialWeights[i][j];
			}
		}

	} 
	
	// Nuevo constructor en vuestro Graph, hay que mantener tambien los anteriores... 
    public Graph (int tam, T initialNodes[], boolean[][] initialEdges, double [][] initialWeights, double [][] initialAfloyd, int [][] initialPfloyd) { 
        // Llama al constructor anterior de inicializaciÃ³n 
        this(tam, initialNodes,initialEdges,initialWeights);  
         
        // Pero modifica los atributos que almacenan las matrices de Floyd con los parÃ¡metros para hacer pruebas... 
         
        if (initialAfloyd!=null && initialPfloyd!=null){ 
            // Si la matriz A de floyd se llama de otra forma (distinto de "aFloyd"), refactorizar para que se llame "aFloyd"
            aFloyd=initialAfloyd; 
            // Si la matriz P de floyd se llama de otra forma (distinto de "pFloyd"), refactorizar para que se llame "pFloyd"
            pFloyd=initialPfloyd; 
        } 
  
    } 
 */
