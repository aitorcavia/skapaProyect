package skapaProyect.ventanasPrimarias;

public class UsuarioVerificado extends Usuario implements Verificador{
	private String verificado;

	public UsuarioVerificado(String nomUsuario, String contrasenya, 
			String correo, String nombre, String apellidos,
			String ubicacion, String direccionIP, String verificado) 
	{
		super(nomUsuario, contrasenya, correo, nombre, apellidos,
				ubicacion, direccionIP);
		this.verificado = verificado;
	}

	public UsuarioVerificado() {
		super("", "", "", "", "", "", "");
		this.verificado = "";
	}

	public String getVerificado() {
		return verificado;
	}

	public void setVerificado(String verificado) {
		this.verificado = verificado;
	}

	@Override
	public void verificable() {
		System.out.println("Esta cuenta esta verificada ¬/");
	}
	
	
	

}
