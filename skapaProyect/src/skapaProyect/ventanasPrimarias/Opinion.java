package skapaProyect.ventanasPrimarias;

public class Opinion {
	private int idUsuario;
	private String titulo;
	private String descripcion;
	
	public Opinion(int idUsuario, String titulo, String descripcion) {
		super();
		this.idUsuario = idUsuario;
		this.titulo = titulo;
		this.descripcion = descripcion;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Opinion [idUsuario=" + idUsuario + ", titulo=" + titulo + ", descripcion=" + descripcion + "]";
	}
	
	
	
	
	
	

}
