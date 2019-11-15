package skapaProyect;


import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import skapaProyect.DataBase.DBException;
import skapaProyect.DataBase.DBManager;
import skapaProyect.VentanasPrimarias.Usuario;

public class DBManagerTest {

	private DBManager dbManager = null;

	@Before
	public void setUp() throws ClassNotFoundException, SQLException, DBException { 
		Class.forName("org.sqlite.JDBC");
		
		Connection conn = DriverManager.getConnection("jdbc:sqlite:data/sample.db");
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("CREATE TABLE IF NOT EXISTS usuario (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre VARCHAR, contrasenya VARCHAR, correo VARCHAR)");
		
		stmt.executeUpdate("INSERT INTO usuario (nombre, contrasenya, correo) VALUES ('Anton', 'tony123', 'tony@gmail.com')");
		stmt.executeUpdate("INSERT INTO usuario (nombre, contrasenya, correo) VALUES ('Gaizka', 'wily123', 'gaizka@gmail.com')");
		stmt.executeUpdate("INSERT INTO usuario (nombre, contrasenya, correo) VALUES ('Aitor', 'cavia123', 'cavia@gmail.com')");
		
		stmt.close();
		conn.close();
		
		dbManager = new DBManager();
		dbManager.connect();
	}
	
	@Test
	public void testGetAllusuarios() throws DBException {
		List<Usuario> usuarios = dbManager.getAllUsers();
		assertEquals(3, usuarios.size());
	}
	
	@Test
	public void testGetUser() throws DBException {
		Usuario usuario = dbManager.getUser(2);
		assertEquals(2, usuario.getId());
		assertEquals("Isaac", usuario.getNombre());
		assertEquals("Newton", usuario.getContrasenya());
	}
	
	@Test
	public void testGetUserNotFound() throws DBException {
		Usuario usuario = dbManager.getUser(50);
		assertEquals(-1, usuario.getId());
	}
	
	/*@Test
	public void testGetUsersBirthBeforeDate() throws DBException {
		Calendar calendar = new GregorianCalendar(1777, 4, 30, 12, 0, 0);
		List<Usuario> usuarios = dbManager.getUsersBirthBeforeDate(calendar.getTime());
		assertEquals(2, usuarios.size());
		
		assertEquals("Carl Friedrich", usuarios.get(0).getNombre());
		assertEquals("Isaac", usuarios.get(1).getNombre());
	}
	*/
	
	@Test
	public void testStore() throws DBException {
		Usuario usuario = new Usuario();
		usuario.setNombre("Leonhard");
		usuario.setContrasenya("Euler");
		usuario.setCorreo("Leonard@gmail.com");
		
		dbManager.store(usuario);
		assertEquals(4, usuario.getId());
	}
	
	@Test
	public void testUpdate() throws DBException {
		Usuario usuario = dbManager.getUser(1);
		usuario.setNombre("Carl F.");
		dbManager.update(usuario);
		
		Usuario updated = dbManager.getUser(1);
		assertEquals("Carl F.", updated.getNombre());
	}
	
	@Test
	public void deleteUser() throws DBException {
		Usuario usuario = dbManager.getUser(2);
		dbManager.delete(usuario);
		
		List<Usuario> usuarios = dbManager.getAllUsers();
		assertEquals(2, usuarios.size());
	}
	
	@After
	public void tearDown() throws DBException, SQLException {
		dbManager.disconnect();
		
		Connection conn = DriverManager.getConnection("jdbc:sqlite:data/sample.db");
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("DROP TABLE usuario");
		
		stmt.close();
		conn.close();
	}
}
