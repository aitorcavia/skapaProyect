package skapaProyect.ventanasPrimarias;

public class UsuarioAdministradores extends Usuario {
	private String controlDeVerificacion;
	private String controlDeUsuarios;
	private String controlDeInterfaz;
	private String controlDeRecuperacionDeContrasenyas;
	
	public UsuarioAdministradores(String nomUsuario, String contrasenya, String correo, 
			String nombre, String apellidos,
			String ubicacion, String direccionIP, String controlDeVerificacion,
			String controlDeUsuarios,
			String controlDeInterfaz, String controlDeRecuperacionDeContrasenyas) {
		super(nomUsuario, contrasenya, correo, nombre, apellidos, ubicacion, direccionIP);
		this.controlDeVerificacion = controlDeVerificacion;
		this.controlDeUsuarios = controlDeUsuarios;
		this.controlDeInterfaz = controlDeInterfaz;
		this.controlDeRecuperacionDeContrasenyas = controlDeRecuperacionDeContrasenyas;
	}
	public UsuarioAdministradores() {
		super();
		this.controlDeVerificacion = "";
		this.controlDeUsuarios = "";
		this.controlDeInterfaz = "";
		this.controlDeRecuperacionDeContrasenyas = "";
	}
	public String getControlDeVerificacion() {
		return controlDeVerificacion;
	}
	public void setControlDeVerificacion(String controlDeVerificacion) {
		this.controlDeVerificacion = controlDeVerificacion;
	}
	public String getControlDeUsuarios() {
		return controlDeUsuarios;
	}
	public void setControlDeUsuarios(String controlDeUsuarios) {
		this.controlDeUsuarios = controlDeUsuarios;
	}
	public String getControlDeInterfaz() {
		return controlDeInterfaz;
	}
	public void setControlDeInterfaz(String controlDeInterfaz) {
		this.controlDeInterfaz = controlDeInterfaz;
	}
	public String getControlDeRecuperacionDeContrasenyas() {
		return controlDeRecuperacionDeContrasenyas;
	}
	public void setControlDeRecuperacionDeContrasenyas(String controlDeRecuperacionDeContrasenyas) {
		this.controlDeRecuperacionDeContrasenyas = controlDeRecuperacionDeContrasenyas;
	}
	
}
