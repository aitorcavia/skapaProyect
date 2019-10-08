package skapaProyect;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculadoraImplTest {
	
	@Before
	public void setUp() {
		
	}

	@Test
	public void testSumar() {
		CalculadoraImpl c = new CalculadoraImpl();
		assertEquals(5, c.sumar(2, 3));
	}
	
	@Test
	public void testMultiplicar() {
		CalculadoraImpl c = new CalculadoraImpl();
		assertEquals(8, c.multiplicar(2, 4));
	}
	
	@Test
	public void testEsPar() {
		CalculadoraImpl c = new CalculadoraImpl();
		assertTrue(c.esPar(4));
	}

}
