package skapaProyect.VentanaSecundarias;

public class Tarjeta {
	private String tipo;
	private String numeroTarjeta;
	private String fecha ;
	private String codigoDeSeguridad ;
	private String codigoPostal2;
	private String nombreCompleto;
	private String direccion;
	private String lineaSegundaDireccion;
	private String ciudad;
	private String estadoProvincia;
	private String codigoPostal;
	
	public Tarjeta(String tipo, String numeroTarjeta, String fecha, String codigoDeSeguridad, String codigoPostal2,
			String nombreCompleto, String direccion, String lineaSegundaDireccion, String ciudad,
			String estadoProvincia, String codigoPostal) {
		super();
		this.tipo = tipo;
		this.numeroTarjeta = numeroTarjeta;
		this.fecha = fecha;
		this.codigoDeSeguridad = codigoDeSeguridad;
		this.codigoPostal2 = codigoPostal2;
		this.nombreCompleto = nombreCompleto;
		this.direccion = direccion;
		this.lineaSegundaDireccion = lineaSegundaDireccion;
		this.ciudad = ciudad;
		this.estadoProvincia = estadoProvincia;
		this.codigoPostal = codigoPostal;
	}
	public Tarjeta() {
		super();
		this.tipo = "";
		this.numeroTarjeta = "";
		this.fecha = "";
		this.codigoDeSeguridad = "";
		this.codigoPostal2 = "";
		this.nombreCompleto = "";
		this.direccion = "";
		this.lineaSegundaDireccion = "";
		this.ciudad = "";
		this.estadoProvincia = "";
		this.codigoPostal = "";
	}
	
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getCodigoDeSeguridad() {
		return codigoDeSeguridad;
	}
	public void setCodigoDeSeguridad(String codigoDeSeguridad) {
		this.codigoDeSeguridad = codigoDeSeguridad;
	}
	public String getCodigoPostal2() {
		return codigoPostal2;
	}
	public void setCodigoPostal2(String codigoPostal2) {
		this.codigoPostal2 = codigoPostal2;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getLineaSegundaDireccion() {
		return lineaSegundaDireccion;
	}
	public void setLineaSegundaDireccion(String lineaSegundaDireccion) {
		this.lineaSegundaDireccion = lineaSegundaDireccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getEstadoProvincia() {
		return estadoProvincia;
	}
	public void setEstadoProvincia(String estadoProvincia) {
		this.estadoProvincia = estadoProvincia;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	
	
}
