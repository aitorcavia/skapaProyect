package skapaProyect;

import static org.junit.Assert.*;

import org.junit.Test;

import skapaProyect.ventanaSecundarias.Tarjeta;

public class TarjetaTest {
	
	@Test
	public void testTipo() {
		Tarjeta tarjeta = new Tarjeta("PayPal", "24556534442", "20190120", "6777", "6533", "Anton Chavarria", "Barakaldo", "Ajo", "Barakaldo", "Vizkaya", "48661", 0);
		assertEquals(tarjeta.getTipo(), "PayPal");
	}
	
	@Test
	public void testNumero() {
		Tarjeta tarjeta = new Tarjeta("PayPal", "24556534442", "20190120", "6777", "6533", "Anton Chavarria", "Barakaldo", "Ajo", "Barakaldo", "Vizkaya", "48661", 0);
		assertEquals(tarjeta.getNumeroTarjeta(), "24556534442");
	}
	
	@Test
	public void testFecha() {
		Tarjeta tarjeta = new Tarjeta("PayPal", "24556534442", "20190120", "6777", "6533", "Anton Chavarria", "Barakaldo", "Ajo", "Barakaldo", "Vizkaya", "48661", 0);
		assertEquals(tarjeta.getFecha(), "20190120");
	}
	
	@Test
	public void testCodigo() {
		Tarjeta tarjeta = new Tarjeta("PayPal", "24556534442", "20190120", "6777", "6533", "Anton Chavarria", "Barakaldo", "Ajo", "Barakaldo", "Vizkaya", "48661", 0);
		assertEquals(tarjeta.getCodigoDeSeguridad(), "6777");
	}
	
	@Test
	public void testCodigoPostal2() {
		Tarjeta tarjeta = new Tarjeta("PayPal", "24556534442", "20190120", "6777", "6533", "Anton Chavarria", "Barakaldo", "Ajo", "Barakaldo", "Vizkaya", "48661", 0);
		assertEquals(tarjeta.getCodigoPostal2(), "6533");
	}
	
	@Test
	public void testEstadoProvincial() {
		Tarjeta tarjeta = new Tarjeta("PayPal", "24556534442", "20190120", "6777", "6533", "Anton Chavarria", "Barakaldo", "Ajo", "Barakaldo", "Vizkaya", "48661", 0);
		assertEquals(tarjeta.getEstadoProvincia(), "Vizkaya");
	}

	
}
