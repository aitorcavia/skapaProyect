package skapaProyect;

import static org.junit.Assert.*;

import org.junit.Test;

public class anuncioTest {

	@Test
	public void testGetPrecio() {
		Producto p = new Producto(44.5);
		Anuncio a = new Anuncio (p, "titulo", "descripcion", "categoria");
		assertEquals("categoria" , a.getCategoria());
		
	}

}
