package ec.edu.ups.appdis.jpaModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Pagos")
@NamedQuery(name="Pago.findAll", query="SELECT s FROM Pago s")
public class Pago implements Serializable{

	private static final long serialVersionUID = 1094801825228386363L;
	@Id
    private int codigo;
	
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cedula", nullable=false)
	private Persona cliente;
	
	private Double costoTotal;
	
	@NotEmpty
	private String formaPago;
	
	@OneToMany(mappedBy = "pago")
	private List<Libro> listaLibros;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Persona getCliente() {
		return cliente;
	}

	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}

	public Double getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(Double costoTotal) {
		this.costoTotal = costoTotal;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public List<Libro> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(List<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}
	
	
}
