package p3Arboles;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import evalNestor.Alumno;

/**
 * Titulo: Clase PruebaBasicaHeap_2021_22_Retroalimentacion
 * 
 * @author Nestor
 * @version 19/11/2021
 */
public class PruebaBasicaHeap_2021_22_Retroalimentacion {

	/**
	 * Método que lanza el programa
	 * 
	 * @param args, argumento
	 */
	public static void main(String[] args) {
		Alumno al = new Alumno();

		FileWriter file = null;
		PrintWriter pw;

		try
		{
			file = new FileWriter(al.getNombreFicheroAlumno()+"-BasicaHeap.txt",true);
			pw = new PrintWriter(file);
//			pruebasVariadas();
			pruebaBasicaAdd(pw);
//			pruebaBasicaGrafos_Edges(pw);
//			pruebaBasicaGrafos_Evolucion(pw);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null)
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		} 
	}

	/**
	 * Pruebas básicas del add
	 * 
	 * @param pw, printWriter
	 */
	static public void pruebaBasicaAdd(PrintWriter pw){
		EDBinaryHeap<Integer> g=new EDBinaryHeap<Integer>(10);
		int linea=1;
		pw.println("Empieza la prueba basica de Heap: ");		
		pw.println("g=new EDBinaryHeap<Integer>(10): ");		

		for (int nodo=10; nodo>0; nodo--) {
			pw.println((linea++)+" g.addNode("+nodo+"): "+g.add(nodo)); 
			pw.println(g.toString());
		}

		for (int nodo=10; nodo>0; nodo--) {
			pw.println((linea++)+" g.poll(): "+g.poll()+"\n"); 
			pw.println(g.toString());
		}

		pw.println("Termina la prueba basica de Heap.\n");

	}
	

}
