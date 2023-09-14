//  NO MODIFICAR NOMBRE DE ESTE PAQUETE
package evalNestor;

/**
 * Titulo: Clase Alumno
 * 
 * @author Omitg
 * @version 24/09/2021
 */
public class Alumno {
	// Poned vuestros apellidos, nombre y UO; sustituyendolos en las asignaciones de debajo...
	String nombre="Omar", // Primera en may�sculas y si es compuesto, sin espacios
			apellido1="Teixeira", // Primera en may�sculas y si es compuesto, sin espacios
			apellido2="Gonz�lez", // Primera en may�sculas y si es compuesto, sin espacios
			uo="UO281847"; // El UO en may�sculas
	/**
	 * M�todo que devuelve el nombre del fichero del alumno
	 * 
	 * @return fichero, nombre del fichero
	 */
	public String getNombreFicheroAlumno(){
		return apellido1+apellido2+nombre+"-"+uo;
	}

	/**
	 * M�todo que devuelve el email
	 * 
	 * @return email, email
	 */
	public String email() {
		return uo+"@uniovi.es";
	}
	
}
