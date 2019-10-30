package skapaProyect;

import static org.junit.Assert.*;

import org.junit.Test;

public class anuncioTest {

	@Test
	public void testGetPrecio() {
		Anuncio a = new Anuncio (5, "titulo", "45", "categoria", "descripcion");
		assertEquals("categoria" , a.getCategoria());
		
	}

}
