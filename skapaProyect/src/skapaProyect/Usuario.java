package skapaProyect;

public class Usuario {

	protected String usuario;
	protected String contrasenya;
	protected String correo;
	
	public Usuario(String usuario, String contrasenya, String correo) {
		super();
		this.usuario = usuario;
		this.contrasenya = contrasenya;
		this.correo = correo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
		return "Usuario [usuario=" + usuario + ", contrasenya=" + contrasenya + ", correo=" + correo + "]";
	}
	
	
	
	
	
	
}
