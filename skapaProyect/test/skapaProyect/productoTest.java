package skapaProyect;

import static org.junit.Assert.*;

import org.junit.Test;

public class productoTest {

	@Test
	public void testGetPrecio() {
		Producto p = new Producto (3.4);
		assertEquals(Double.toString(3.4), Double.toString(p.getPrecio()));
		
	}

}
