package p1Algoritmia;

import org.junit.jupiter.api.Test;
import evalNestor.Alumno;

class EvContinuaSesion1a {

	@Test
	void test() {
		Algorithms alg=new Algorithms();
		Alumno al= new Alumno();
		
			System.out.println("Alumno:"+al.getNombreFicheroAlumno());

			System.out.println("factorial("+0+"): "+alg.factorial(0));
			System.out.println("factorial("+1+"): "+alg.factorial(1));
	
			System.out.println("fibonacci("+0+"): "+alg.fibonacci(0));
			System.out.println("fibonacci("+1+"): "+alg.fibonacci(1));
			System.out.println("fibonacci("+2+"): "+alg.fibonacci(2));
			
			System.out.println("pow2Rec1("+0+"): "+alg.pow2Rec1(0));
			System.out.println("pow2Rec1("+1+"): "+alg.pow2Rec1(1));
			
			System.out.println("potenciaRec(2,"+0+"): "+alg.potenciaRec(2,0));
			System.out.println("potenciaRec(2,"+1+"): "+alg.potenciaRec(2,1));
	
			System.out.println("restoDivRec("+0+",10): "+alg.restoDivRec(0,10));
			System.out.println("restoDivRec("+11+",10): "+alg.restoDivRec(11,10));
			System.out.println("restoDivRec("+10+",10): "+alg.restoDivRec(10,10));
				
			System.out.println("divEntRec("+0+",10): "+alg.divEntRec(0,10));
			System.out.println("divEntRec("+11+",10): "+alg.divEntRec(11,10));
			System.out.println("divEntRec("+10+",10): "+alg.divEntRec(10,10));

	}

}
