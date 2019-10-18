package skapaProyect;

import static org.junit.Assert.*;

import org.junit.Test;

public class usuarioTest {

	@Test
	public void testGetNombre() {
		Usuario u = new Usuario ("Tony", "tony123", "tony@gmail.com");
		assertEquals("Tony", u.getUsuario());
	}
	
	@Test
	public void testGetCorreo() {
		Usuario u = new Usuario ("Tony", "tony123", "tony@gmail.com");
		assertEquals("tony@gmail.com", u.getCorreo());
	}
	@Test
	public void testGetContrasenya() {
		Usuario u = new Usuario ("Tony", "tony123", "tony@gmail.com");
		assertEquals("tony123", u.getContrasenya());
	}

}
