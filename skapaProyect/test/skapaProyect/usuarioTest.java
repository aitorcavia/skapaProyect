package skapaProyect;

import static org.junit.Assert.*;

import org.junit.Test;

public class usuarioTest {

	@Test
	public void testGetNombre() {
		Usuario u = new Usuario ("Tony", "Chavarria", "ant@gmail.com", "tony123");
		assertEquals("Tony", u.getNombre());
	}
	
	@Test
	public void testGetApellido() {
		Usuario u = new Usuario ("Tony", "Chavarria", "ant@gmail.com", "tony123");
		assertEquals("Chavarria", u.getApellido());
	}
	@Test
	public void testGetCorreo() {
		Usuario u = new Usuario ("Tony", "Chavarria", "ant@gmail.com", "tony123");
		assertEquals("ant@gmail.com", u.getCorreo());
	}
	@Test
	public void testGetContrasenya() {
		Usuario u = new Usuario ("Tony", "Chavarria", "ant@gmail.com", "tony123");
		assertEquals("tony123", u.getContrasenya());
	}

}
