package skapaProyect.VentanasPrimarias;

import java.util.ArrayList;

public class Usuario {
	
	public static int cont = 0;
	private int id;
	private String nombre;
	private String contrasenya;
	private String correo;
	
	public Usuario(String nombre, String contrasenya, String correo) {
		super();
		this.id = cont++;
		this.nombre = nombre;
		this.contrasenya = contrasenya;
		this.correo = correo;
	}
	
	public Usuario() {
		super();
		this.id = cont++;
		this.nombre = "";
		this.contrasenya = "";
		this.correo = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contrasenya=" + contrasenya + ", correo=" + correo + "]";
	}
	
	
	
	

}