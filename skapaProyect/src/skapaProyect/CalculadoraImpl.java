package skapaProyect;

public class CalculadoraImpl implements Calculadora{

	@Override
	public int sumar(int a, int b) {
		return a + b;
		
	}

	@Override
	public int restar(int a, int b) {
		return a - b ;
	}

	@Override
	public int multiplicar(int a, int b) {
		return a * b;
	}

	@Override
	public boolean esPar(int a) {
		return a % 2 == 0;
	}

}
