package ec.edu.ups.appdis.jpaModel;

public class Estado {

	private String cedula;
	private String nombre;
	private String fecha;
	private Double costoTotal;
	private String FormaPago;
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Double getCostoTotal() {
		return costoTotal;
	}
	public void setCostoTotal(Double costoTotal) {
		this.costoTotal = costoTotal;
	}
	public String getFormaPago() {
		return FormaPago;
	}
	public void setFormaPago(String formaPago) {
		FormaPago = formaPago;
	}
	
	
}
