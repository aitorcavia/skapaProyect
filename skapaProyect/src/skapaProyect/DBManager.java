package skapaProyect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBManager {

	private Connection conn = null; 
	
	//CREAR CONEXION CON BD
	public void connect() throws DBException {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:data/sample.db");
		} catch (ClassNotFoundException e) {
			throw new DBException("Error cargando el driver de la BD", e);
		} catch (SQLException e) {
			throw new DBException("Error conectando a la BD", e);
		}
	}
	
	//CERRAR CONEXION CON BD
	public void disconnect() throws DBException {
		try {
			conn.close();
		} catch (SQLException e) {
			throw new DBException("Error cerrando la conexión con la BD", e);
		}
	}
	
	
	//LISTAR TODOS LOS USUARIOS
	public List<Usuario> getAllUsers() throws DBException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT id, nombre, contrasenya, correo FROM user");

			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("combre"));
				usuario.setContrasenya(rs.getString("contrasenya"));
				usuario.setCorreo(rs.getString("correo"));
				usuarios.add(usuario);
			}
			
			return usuarios;
		} catch (SQLException e) {
			throw new DBException("Error obteniendo todos los usuarios'", e);
		}
	}
	
	//OBTENER USUARIO POR LA ID
	public Usuario getUser(int id) throws DBException {
		try (PreparedStatement stmt = conn.prepareStatement("SELECT id, nombre, contrasenya, correo FROM usuario WHERE id = ?")) {
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("name"));
				usuario.setContrasenya(rs.getString("contrasenya"));
				usuario.setCorreo(rs.getString("correo"));
				return usuario;
			} else {
				return new Usuario();
			}
		} catch (SQLException e) {
			throw new DBException("Error obteniendo el usuario con id " + id, e);
		}
	}
	
	
	
	//CREACION DE USUARIO POR PRIMERA VEZ (GENERACION AUTOMATICA DE ID)
	public void store(Usuario usuario) throws DBException {
		try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO user (nombre, contrasenya, correo) VALUES (?, ?, ?)");
			Statement stmtForId = conn.createStatement()) {
			stmt.setString(1, usuario.getNombre());
			stmt.setString(2, usuario.getContrasenya());
			stmt.setString(3, usuario.getCorreo());
			
			stmt.executeUpdate();
			
			//obtiene el id que se acaba de autogenerar
			ResultSet rs = stmtForId.executeQuery("SELECT last_insert_rowid() AS id FROM usuario");
			if (rs.next()) {
				int newId = rs.getInt("id");
				usuario.setId(newId);
			} else {
				throw new DBException("Error generando el id autoincremental");
			}
		} catch (SQLException e) {
			throw new DBException("No se pudo guardar el usuario en la BD", e);
		}
	}
	
	//ACTUALIZAR USUARIO YA EXISTENTE CON UN ID
	public void update(Usuario usuario) throws DBException {
		try (PreparedStatement stmt = conn.prepareStatement("UPDATE usuario SET nombre=?, contrasenya=?, correo=? WHERE id=?")) {
			stmt.setString(1, usuario.getNombre());
			stmt.setString(2, usuario.getContrasenya());
			stmt.setString(3, usuario.getCorreo());
			stmt.setInt(4, usuario.getId());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DBException("No se pudo guardar el usuario en la BD", e);
		}
	}
	
	//ELIMINAR USUARIO EXISTENTE
	public void delete(Usuario usuario) throws DBException {
		try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM usuario WHERE id=?")) {
			stmt.setInt(1, usuario.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DBException("No se pudo elimiar el usuario con id " + usuario.getId(), e);
		}
	}
}