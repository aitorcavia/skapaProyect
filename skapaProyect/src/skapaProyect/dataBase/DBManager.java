package skapaProyect.dataBase;

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

import skapaProyect.ventanaSecundarias.Tarjeta;
import skapaProyect.ventanasPrimarias.Anuncio;
import skapaProyect.ventanasPrimarias.Opinion;
import skapaProyect.ventanasPrimarias.Usuario;


public class DBManager {

	private Connection conn = null; 
	
	//CREAR CONEXION CON BD
	public void connect() throws DBException { 
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:data/BD.db");
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
	
	//REGISTRAR NUEVO USUARIO
	public void registrarUsuario(Usuario usuario) throws DBException{
		
		String nomUsuario = usuario.getNomUsuario();
		String contrasenya = usuario.getContrasenya();
		String correo = usuario.getCorreo();
		String direccionIP = usuario.getDireccionIP();
		
		
		try (Statement stmt= conn.createStatement()) {
			stmt.executeUpdate("INSERT INTO usuario (nomUsuario, contrasenya, correo, direccionIP) VALUES ('" + nomUsuario + "', '"+ contrasenya + "', '" + correo + "', '" + direccionIP + "')");
		} catch (SQLException e) {
			throw new DBException("No ha sido posible ejecutar la query");
		}
		
	}

	//COMPROBAR NOMUSUARIO EXISTE
	public boolean comprobarNomUsuario(Usuario usuario) throws DBException{
		boolean existe;
		String nomUsuario = usuario.getNomUsuario();
		
		try (PreparedStatement stmt = conn.prepareStatement("SELECT id, nomUsuario, contrasenya, correo FROM usuario WHERE nomUsuario = ?")) {
			stmt.setString(1, nomUsuario);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				existe = true;
			}else {
				existe = false;
			}
					
		} catch (SQLException e) {
			throw new DBException("Error obteniendo datos de la query", e);
		}
		
		return existe;
	}
	
	//LOGIN DE USUARIO
		public boolean loginUsuario (String nomUsuario, String contrasenya) throws DBException{
			
			boolean acceso = false;
			
			if (nomUsuario.contains("@")) {
				try (PreparedStatement stmt = conn.prepareStatement("SELECT id, nomUsuario, contrasenya, correo FROM usuario WHERE correo = ? AND contrasenya = ?")) {
					stmt.setString(1, nomUsuario);
					stmt.setString(2, contrasenya);
					
					ResultSet rs = stmt.executeQuery();
					
					if (rs.next()) {
						acceso = true;
					}else {
						acceso = false;
					}
					
				} catch (SQLException e) {
					throw new DBException("Error obteniendo datos de la query", e);
				}
				
			}else {
				try (PreparedStatement stmt = conn.prepareStatement("SELECT id, nomUsuario, contrasenya, correo FROM usuario WHERE nomUsuario = ? AND contrasenya = ?")) {
					stmt.setString(1, nomUsuario);
					stmt.setString(2, contrasenya);
					
					ResultSet rs = stmt.executeQuery();
					
					if (rs.next()) {
						acceso = true;
					}else {
						acceso = false;
					}
					
				} catch (SQLException e) {
					throw new DBException("Error obteniendo datos de la query", e);
				}
			}
			
			return acceso;
		}
	
	
	//LISTAR TODOS LOS USUARIOS
	public List<Usuario> getAllUsers() throws DBException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT id, nomUsuario, contrasenya, correo FROM user");

			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNomUsuario(rs.getString("nomUsuario"));
				usuario.setContrasenya(rs.getString("contrasenya"));
				usuario.setCorreo(rs.getString("correo"));
				usuarios.add(usuario);
			}
			
			return usuarios;
		} catch (SQLException e) {
			throw new DBException("Error obteniendo todos los usuarios'", e);
		}
	}
	
	//OBTENER ID DE NOMUSUARIO
	public int obtenerId (String nomUsuario) throws DBException{
		int idUsuario = 0;
		if (!nomUsuario.contains("@")) {
			try (PreparedStatement stmt = conn.prepareStatement("SELECT id, nomUsuario, contrasenya, correo, nombre, apellidos, ubicacion, direccionIP FROM usuario WHERE nomUsuario = ?")) {
				stmt.setString(1, nomUsuario);
				ResultSet rs = stmt.executeQuery();
				rs.next();
				idUsuario = rs.getInt("id");
				
			} catch (SQLException e) {
				throw new DBException("Error obteniendo todos los usuarios'", e);
			}	
		}else {
			try (PreparedStatement stmt = conn.prepareStatement("SELECT id, nomUsuario, contrasenya, correo, nombre, apellidos, ubicacion, direccionIP FROM usuario WHERE correo = ?")) {
				stmt.setString(1, nomUsuario);
				ResultSet rs = stmt.executeQuery();
				rs.next();
				idUsuario = rs.getInt("id");
				
			} catch (SQLException e) {
				throw new DBException("Error obteniendo todos los usuarios'", e);
			}	
		}
		
			
		return idUsuario;
	}
	
	//ACTUALIZAR BASE DE DATOS
	public void actualizarBase (Usuario usuario) throws DBException{
	
		
		try (PreparedStatement stmt = conn.prepareStatement("UPDATE usuario	SET nombre= ?, apellidos = ?, correo = ?, ubicacion = ? WHERE id= ?")) {
			stmt.setString(1, usuario.getNombre());
			stmt.setString(2, usuario.getApellidos());
			stmt.setString(3, usuario.getCorreo());
			stmt.setString(4, usuario.getUbicacion());
			stmt.setInt(5, usuario.getId());
			stmt.executeUpdate();
			
			
		
		} catch (SQLException e) {
			throw new DBException("Error obteniendo todos los usuarios'", e);
		}	
	}
	
	//OBTENER USUARIO POR LA ID
	public Usuario buscarUsuarioId(int id) throws DBException {
		try (PreparedStatement stmt = conn.prepareStatement("SELECT id, nomUsuario, contrasenya, correo, nombre, apellidos, ubicacion, direccionIP FROM usuario WHERE id = ?")) {
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNomUsuario(rs.getString("nomUsuario"));
				usuario.setContrasenya(rs.getString("contrasenya"));
				usuario.setCorreo(rs.getString("correo"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellidos(rs.getString("apellidos"));
				usuario.setUbicacion(rs.getString("ubicacion"));
				usuario.setDireccionIP(rs.getString("direccionIP"));
				return usuario;
				
			} else {
				return new Usuario();
			}
		} catch (SQLException e) {
			throw new DBException("Error obteniendo el usuario con id " + id, e);
		}
	}
		
	
	//LISTAR TODOS LOS ANUNCIOS
		public List<Anuncio> listarAnuncios() throws DBException {
			List<Anuncio> anuncios = new ArrayList<Anuncio>();
			try (Statement stmt = conn.createStatement()) {
				ResultSet rs = stmt.executeQuery("SELECT idUsuario, idAnuncio, titulo, descripcion, precio, categoria FROM anuncio");

				while(rs.next()) {
					Anuncio anuncio = new Anuncio();
					anuncio.setIdUsuario(rs.getInt("idUsuario"));
					anuncio.setIdAnuncio(rs.getInt("idAnuncio"));
					anuncio.setTitulo(rs.getString("titulo"));
					anuncio.setPrecio(rs.getString("precio"));
					anuncio.setCategoria(rs.getString("categoria"));
					anuncio.setDescripcion(rs.getString("descripcion"));
					anuncios.add(anuncio);
				}
				
				return anuncios;
				
			} catch (SQLException e) {
				throw new DBException("Error obteniendo todos los anuncios'", e);
			}
		}
		
	//LISTAR TODOS LOS ANUNCIOS POR IdUsuario
	public ArrayList<Anuncio> listarAnunciosIdUsuario(int idUsuario) throws DBException {
		ArrayList<Anuncio> anuncios = new ArrayList<Anuncio>();
		try (PreparedStatement stmt = conn.prepareStatement("SELECT idUsuario, idAnuncio, titulo, descripcion, precio, categoria FROM anuncio WHERE idUsuario = ?")) {
			stmt.setInt(1, idUsuario);
			
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				Anuncio anuncio = new Anuncio();
				anuncio.setIdUsuario(rs.getInt("idUsuario"));
				anuncio.setIdAnuncio(rs.getInt("idAnuncio"));
				anuncio.setTitulo(rs.getString("titulo"));
				anuncio.setPrecio(rs.getString("precio"));
				anuncio.setCategoria(rs.getString("categoria"));
				anuncio.setDescripcion(rs.getString("descripcion"));
				anuncios.add(anuncio);
			}
			
			return anuncios;
			
		} catch (SQLException e) {
			throw new DBException("Error obteniendo todos los anuncios'", e);
		}
	}
			
			
	//LISTAR TODOS LOS ANUNCIOS POR FILTRO buscador, categoria, provincia, precio		
	public List<Anuncio> listarAnunciosFiltro (String texto, String categoria, String provincia, String precio1, String precio2) throws DBException {
		List<Anuncio> anuncios = new ArrayList<Anuncio>();
		
		int cont = 0;
		
		String query = "SELECT idUsuario, idAnuncio, titulo, descripcion, precio, categoria FROM anuncio WHERE titulo LIKE ?";
		if (!categoria.equals(">Seleccionar categoria<")) {
			query = query + " AND categoria = ?";
			cont = cont + 1;
		}
		if (!precio1.isEmpty() && !precio2.isEmpty()) {
			query = query + " AND precio BETWEEN ? AND ?";
			cont = cont + 2;
		}
			
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, "%" + texto + "%");
			
			if (cont ==1) {
				stmt.setString(2, categoria);
			}else if (cont ==2) {
				stmt.setString(2, precio1);
				stmt.setString(3, precio2);
			}else if (cont ==3) {
				stmt.setString(2, categoria);
				stmt.setString(3, precio1);
				stmt.setString(4, precio2);
			}
			
			
			//stmt.setString(4, provincia);
			
			
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				
				Anuncio anuncio = new Anuncio();
				anuncio.setIdUsuario(rs.getInt("idUsuario"));
				anuncio.setIdAnuncio(rs.getInt("idAnuncio"));
				anuncio.setTitulo(rs.getString("titulo"));
				anuncio.setPrecio(rs.getString("precio"));
				anuncio.setCategoria(rs.getString("categoria"));
				anuncio.setDescripcion(rs.getString("descripcion"));
				anuncios.add(anuncio);
			}
			
			return anuncios;
			
		} catch (SQLException e) {
			throw new DBException("Error obteniendo todos los anuncios'", e);
		}
	}
	

	
	//CREACION DE USUARIO POR PRIMERA VEZ (GENERACION AUTOMATICA DE ID)
	public void store(Usuario usuario) throws DBException {
		try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO user (nomUsuario, contrasenya, correo) VALUES (?, ?, ?)");
			Statement stmtForId = conn.createStatement()) {
			stmt.setString(1, usuario.getNomUsuario());
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
		try (PreparedStatement stmt = conn.prepareStatement("UPDATE usuario SET nomUsuario=?, contrasenya=?, correo=? WHERE id=?")) {
			stmt.setString(1, usuario.getNomUsuario());
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
	
	//INSERTAR DATOS A TARJETA
	public void insertarDatosTarjeta (Tarjeta tarjeta) throws DBException{
		
		try (Statement stmt= conn.createStatement()) {
			
			int idUsuario = tarjeta.getidUsuario();
			String tipo =  tarjeta.getTipo();
			String numeroTarjeta = tarjeta.getNumeroTarjeta();
			String fecha =	tarjeta.getFecha();
			String codigoDeSeguridad = tarjeta.getCodigoDeSeguridad();
			String codigoPostal2 =	tarjeta.getCodigoPostal2();
			String nombreCompleto =	tarjeta.getNombreCompleto();
			String direccion =	tarjeta.getDireccion();
			String lineaSegundaDireccion = tarjeta.getLineaSegundaDireccion();
			String ciudad =	tarjeta.getCiudad();
			String estadoProvincia	= tarjeta.getEstadoProvincia();
			String codigoPostal	= tarjeta.getCodigoPostal();
			
			stmt.executeUpdate("INSERT INTO tarjeta (idUsuario, tipo, numeroTarjeta, fecha, codigoDeSeguridad, codigoPostal2, nombreCompleto,direccion, lineaSegundaDireccion, ciudad, estadoProvincia, codigoPostal) VALUES ('" + idUsuario + "', '" + tipo + "' , '" + numeroTarjeta + "', '" + fecha + "', '" + codigoDeSeguridad + "', '" + nombreCompleto + "', '" + codigoPostal2 + "', '" + direccion + "', '" + lineaSegundaDireccion + "', '" + ciudad + "', '" + estadoProvincia + "', '" + codigoPostal + "')");
			
			
		} catch (SQLException e) {
			throw new DBException("No ha sido posible ejecutar la query");
		}
	}
	
	//INSERTAR NUEVA OPINION
	public void insertarOpinion (Opinion opinion) throws DBException{
		
		try (Statement stmt= conn.createStatement()) {
			
			int idUsuario = opinion.getIdUsuario();
			String titulo = opinion.getTitulo();
			String descripcion = opinion.getDescripcion();
			
			stmt.executeUpdate("INSERT INTO opinion (idUsuario, titulo, descripcion) VALUES ('"+ idUsuario + "', '" + titulo + "', '" + descripcion + "')");
		
		} catch (SQLException e) {
			throw new DBException("No ha sido posible ejecutar la query");
}
	}
	
	//ELIMINAR UN ANUNCIO POR ID
	public void eliminarAnuncio (int idAnuncio) throws DBException{
		try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM anuncio WHERE idAnuncio = ?")){
			stmt.setInt(1, idAnuncio);
			stmt.executeUpdate();
			
			
		}catch (SQLException e) {
			throw new DBException("No ha sido posible ejecutar la query");
		}
	}
	
	//ELIMINAR TODOS LOS ANUNCIOS POR IDU
	
	public void eliminarAnunciosU (int idUsuario) throws DBException{
		try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM anuncio WHERE idUsuario = ?")){
			stmt.setInt(1, idUsuario);
			stmt.executeUpdate();
			
		}catch (SQLException e) {
			throw new DBException("No ha sido posible ejecutar la query");
		}
	}
	
	//CAMBIAR CONTRASENYA USUARIO
	public void cambiarContrsenya (Usuario user) throws DBException{
		try (PreparedStatement stmt = conn.prepareStatement("UPDATE usuario SET contrasenya= ? WHERE nomUsuario ='"+ user.getNomUsuario() + "'")){
			stmt.setString(1, user.getContrasenya());
			stmt.executeUpdate();
			
			
		}catch (SQLException e) {
			throw new DBException("No ha sido posible ejecutar la query");
		}
	}
	
	//INSERTAR NUEVO ANUNCIO
	public void insertarAnuncio (Anuncio anuncio) throws DBException{
		try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO anuncio (idUsuario, titulo, precio, categoria, descripcion) VALUES (?, ?, ?, ?, ? )")){
			stmt.setInt(1, anuncio.getIdUsuario());
			stmt.setString(2, anuncio.getTitulo());
			stmt.setString(3, anuncio.getPrecio());
			stmt.setString(4, anuncio.getCategoria());
			stmt.setString(5, anuncio.getDescripcion());
			stmt.executeUpdate();
			
		}catch (SQLException e) {
			throw new DBException("No ha sido posible ejecutar la query");
		}
	}
	
	//ELIMINAR CUENTA
	public void eliminarUsuario (int idUsuario) throws DBException{
		try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM usuario WHERE id = ?")){
			stmt.setInt(1, idUsuario);
			stmt.executeUpdate();
			
			
		}catch (SQLException e) {
			throw new DBException("No ha sido posible ejecutar la query");
		}
	}
	
}