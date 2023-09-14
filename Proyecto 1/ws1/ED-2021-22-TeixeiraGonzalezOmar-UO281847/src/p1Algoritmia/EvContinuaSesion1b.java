package p1Algoritmia;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import evalNestor.Alumno;

class EvContinuaSesion1b {

	@Test
	void test() {
		int[] param= {0,20,100,
				0,1,5,25,
				0,1,5,10,20,
				0,1,5,10,20,
				0,1,10,15,20,27,
				0,1,10,15,103,110};
		Algorithms alg=new Algorithms();
		int i=0;
		FileWriter file = null;
		PrintWriter pw;
		Alumno al= new Alumno();
		
		try {
			file = new FileWriter(al.getNombreFicheroAlumno()+".log");
			pw = new PrintWriter(file);
			LocalDateTime ahora= LocalDateTime.now();
			pw.println("Alumno:"+al.getNombreFicheroAlumno());
			pw.println("TimeStamp: "+InetAddress.getLocalHost()+" "+ahora);

			pw.println("\nFactoriales:\nfactorial("+param[i]+"): "+alg.factorial(param[i++]));
			pw.println("factorial("+param[i]+"): "+alg.factorial(param[i++]));
			pw.println("factorial("+param[i]+"): "+alg.factorial(param[i++]));
	
			pw.println("\nFibonacci:\nfibonacci("+param[i]+"): "+alg.fibonacci(param[i++]));
			pw.println("fibonacci("+param[i]+"): "+alg.fibonacci(param[i++]));
			pw.println("fibonacci("+param[i]+"): "+alg.fibonacci(param[i++]));
			pw.println("fibonacci("+param[i]+"): "+alg.fibonacci(param[i++]));
			
			pw.println("\nPotencias de 2 (Rec1):\npow2Rec1("+param[i]+"): "+alg.pow2Rec1(param[i++]));
			pw.println("pow2Rec1("+param[i]+"): "+alg.pow2Rec1(param[i++]));
			pw.println("pow2Rec1("+param[i]+"): "+alg.pow2Rec1(param[i++]));
			pw.println("pow2Rec1("+param[i]+"): "+alg.pow2Rec1(param[i++]));
			pw.println("pow2Rec1("+param[i]+"): "+alg.pow2Rec1(param[i++]));
			
			pw.println("\nPotencias:\npotenciaRec(2,"+param[i]+"): "+alg.potenciaRec(2,param[i++]));
			pw.println("potenciaRec(2,"+param[i]+"): "+alg.potenciaRec(2,param[i++]));
			pw.println("potenciaRec(2,"+param[i]+"): "+alg.potenciaRec(2,param[i++]));
			pw.println("potenciaRec(2,"+param[i]+"): "+alg.potenciaRec(2,param[i++]));
			pw.println("potenciaRec(2,"+param[i]+"): "+alg.potenciaRec(2,param[i++]));
	
			pw.println("\nRestos:\nrestoDivRec("+param[i]+",10): "+alg.restoDivRec(param[i++],10));
			pw.println("restoDivRec("+param[i]+",10): "+alg.restoDivRec(param[i++],10));
			pw.println("restoDivRec("+param[i]+",10): "+alg.restoDivRec(param[i++],10));
			pw.println("restoDivRec("+param[i]+",10): "+alg.restoDivRec(param[i++],10));
			pw.println("restoDivRec("+param[i]+",10): "+alg.restoDivRec(param[i++],10));
			pw.println("restoDivRec("+param[i]+",10): "+alg.restoDivRec(param[i++],10));
				
			pw.println("\nDivisiones enteras:\ndivEntRec("+param[i]+",10): "+alg.divEntRec(param[i++],10));
			pw.println("divEntRec("+param[i]+",10): "+alg.divEntRec(param[i++],10));
			pw.println("divEntRec("+param[i]+",10): "+alg.divEntRec(param[i++],10));
			pw.println("divEntRec("+param[i]+",10): "+alg.divEntRec(param[i++],10));
			pw.println("divEntRec("+param[i]+",10): "+alg.divEntRec(param[i++],10));
			pw.println("divEntRec("+param[i]+",10): "+alg.divEntRec(param[i++],10));
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

}
