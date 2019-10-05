package skapaProyect;

public class Anuncio {
	
	protected Producto producto;
	protected String titulo;
	protected String descripcion;
	protected String categoria;
	
	public Anuncio(Producto producto, String titulo, String descripcion, String categoria) {
		super();
		this.producto = producto;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.categoria = categoria;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
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
	
	
	
	

}
