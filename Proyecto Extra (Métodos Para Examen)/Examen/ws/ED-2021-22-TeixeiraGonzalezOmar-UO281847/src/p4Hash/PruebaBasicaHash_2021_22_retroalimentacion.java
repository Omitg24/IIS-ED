package p4Hash;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import evalNestor.Alumno;

/**
 * Titulo: Clase PruebaBasicaHash_2021_22_retroalimentacion
 * 
 * @author UO281847
 * @version 11/12/2021
 */
public class PruebaBasicaHash_2021_22_retroalimentacion {
	/**
	 * Método main
	 * @param args, argumento
	 */
	public static void main(String[] args) {
		Alumno al = new Alumno();

		FileWriter file = null;
		PrintWriter pw;

		try
		{
			file = new FileWriter(al.getNombreFicheroAlumno()+"-BasicaHash.txt",true);
			pw = new PrintWriter(file);
			pruebaBasica(pw);
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
	 * Prueba básica de add, find y remove
	 * @param pw, printwriter
	 */
//	@Test
	public static void pruebaBasica(PrintWriter pw) {
		ClosedHashTable<Integer> h = new ClosedHashTable<>(5, ClosedHashTable.LINEAL);
		int operacion=0;
		pw.println("Empieza la prueba basica de Hash: ");		
		pw.println("h=new ClosedHashTable<Integer>(5,ClosedHashTable.LINEAL): ");
		int valores[]=new int[] {0,5,0,10,0,15,0,10,5,15,0,10,0,10,0,5,0,15};
		for (int i=1; i<=valores.length; i++) {
			if (operacion<6) { // adds
				pw.println("Operacion "+i+" h.addNode("+valores[i-1]+"): "+h.add(valores[i-1]));
			} else if (operacion<10){
				pw.println("Operacion "+i+" h.find("+valores[i-1]+"): "+h.find(valores[i-1]));
			}
			else { // removes
				pw.println("Operacion "+i+" h.removeNode("+valores[i-1]+"): "+h.remove(valores[i-1]));
			}
			operacion++;
			pw.println("Estado "+(i)+"-> "+h.toString());
		}

		pw.println("Termina la prueba basica de Heap.\n");

	}

}
