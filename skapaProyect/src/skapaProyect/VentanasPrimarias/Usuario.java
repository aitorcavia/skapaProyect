package skapaProyect.VentanasPrimarias;

import java.util.ArrayList;

public class Usuario {
	
	public static int cont = 0;
	private int id;
	private String nomUsuario;
	private String contrasenya;
	private String correo;
	private String nombre;
	private String apellidos;
	private String ubicacion;
	private String direccionIP;
	
	public Usuario(String nomUsuario, String contrasenya, String correo, String nombre, String apellidos,
			String ubicacion, String direccionIP) {
		super();
		this.nomUsuario = nomUsuario;
		this.contrasenya = contrasenya;
		this.correo = correo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.ubicacion = ubicacion;
		this.direccionIP = direccionIP;
	}
	
	public Usuario(String nomUsuario, String contrasenya, String correo) {
		super();
		this.nomUsuario = nomUsuario;
		this.contrasenya = contrasenya;
		this.correo = correo;

	}
	
	public Usuario() {
		super();
		this.nomUsuario = "";
		this.contrasenya = "";
		this.correo = "";
		this.nombre = "";
		this.apellidos = "";
		this.ubicacion = "";
		this.direccionIP = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getDireccionIP() {
		return direccionIP;
	}

	public void setDireccionIP(String direccionIP) {
		this.direccionIP = direccionIP;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nomUsuario=" + nomUsuario + ", contrasenya=" + contrasenya + ", correo="
				+ correo + ", nombre=" + nombre + ", apellidos=" + apellidos + ", ubicacion=" + ubicacion
				+ ", direccionIP=" + direccionIP + "]";
	}
	
	
	
	
	
	
	

}