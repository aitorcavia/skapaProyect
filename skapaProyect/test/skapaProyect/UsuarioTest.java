package skapaProyect;

import static org.junit.Assert.*;

import org.junit.Test;

import skapaProyect.ventanasPrimarias.Usuario;

public class UsuarioTest {
	


	@Test
	public void testGetNombre() {
		Usuario u = new Usuario ("Tony", "tony123", "tony@gmail.com");
		assertEquals("Tony", u.getNombre());
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
