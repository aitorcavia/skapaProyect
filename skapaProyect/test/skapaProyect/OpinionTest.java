package skapaProyect;

import static org.junit.Assert.*;

import org.junit.Test;

import skapaProyect.ventanasPrimarias.Opinion;

public class OpinionTest {

	@Test
	public void testIdUsuario() {
		Opinion opinion = new Opinion(0, "Buena app", "Aplicacion facil y sencilla");
		assertEquals(opinion.getIdUsuario(), 0);
	}
	
	@Test
	public void testTitulo() {
		Opinion opinion = new Opinion(0, "Buena app", "Aplicacion facil y sencilla");
		assertEquals(opinion.getTitulo(), "Buena app");
	}
	
	@Test
	public void testDescripcion() {
		Opinion opinion = new Opinion(0, "Buena app", "Aplicacion facil y sencilla");
		assertEquals(opinion.getDescripcion(), "Aplicacion facil y sencilla");
	}

}
