package skapaProyect;

public class Calculadora {

	public int sumar (int a, int b) {
		return a+b;
	}
	
	public int restar (int a, int b) {
		int solucion;
		if (a>b) {
			solucion = a-b;
		}else {
			solucion = b-a;
		}
		
		return solucion;
	}
	
	public int multiplicar (int a, int b) {
		return a*b;
	}
	
	public boolean esPar (int a) {
		boolean solucion;
		if (a%2 == 0) {
			solucion = true;
		}else {
			solucion = false;
		}
		return solucion;
	}
}
