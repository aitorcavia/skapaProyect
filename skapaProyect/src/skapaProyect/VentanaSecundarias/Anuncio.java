package skapaProyect.VentanaSecundarias;

public class Anuncio {
	
	public static int cont;
	private int idUsuario;
	private int idAnuncio;
	private String titulo;
	private String descripcion;
	private String categoria;
	private String precio;
	
	public Anuncio(int idUsuario, String titulo, String descripcion, String categoria, String precio) {
		super();
		this.idUsuario = idUsuario;
		this.idAnuncio = cont++;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.precio = precio;
	}
	
	public Anuncio() {
		super();
		this.idUsuario = 0;
		this.idAnuncio = cont++;
		this.titulo = "";
		this.descripcion = "";
		this.categoria = "";
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdAnuncio() {
		return idAnuncio;
	}

	public void setIdAnuncio(int idAnuncio) {
		this.idAnuncio = idAnuncio;
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	
	
	
	
}
