//  NO MODIFICAR NOMBRE DE ESTE PAQUETE
package evalNestor;

public class Alumno {
	// Poned vuestros apellidos, nombre y UO; sustituyendolos en las asignaciones de debajo...
	String nombre="Omar", // Primera en mayúsculas y si es compuesto, sin espacios
			apellido1="Teixeira", // Primera en mayúsculas y si es compuesto, sin espacios
			apellido2="González", // Primera en mayúsculas y si es compuesto, sin espacios
			uo="UO281847"; // El UO en mayúsculas
	
	public String getNombreFicheroAlumno(){
		return apellido1+apellido2+nombre+"-"+uo;
	}

	public String email() {
		return uo+"@uniovi.es";
	}
	
}
