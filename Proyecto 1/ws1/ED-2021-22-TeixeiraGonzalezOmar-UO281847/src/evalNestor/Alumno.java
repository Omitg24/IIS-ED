//  NO MODIFICAR NOMBRE DE ESTE PAQUETE
package evalNestor;

public class Alumno {
	// Poned vuestros apellidos, nombre y UO; sustituyendolos en las asignaciones de debajo...
	String nombre="Omar", // Primera en may�sculas y si es compuesto, sin espacios
			apellido1="Teixeira", // Primera en may�sculas y si es compuesto, sin espacios
			apellido2="Gonz�lez", // Primera en may�sculas y si es compuesto, sin espacios
			uo="UO281847"; // El UO en may�sculas
	
	public String getNombreFicheroAlumno(){
		return apellido1+apellido2+nombre+"-"+uo;
	}

	public String email() {
		return uo+"@uniovi.es";
	}
	
}
