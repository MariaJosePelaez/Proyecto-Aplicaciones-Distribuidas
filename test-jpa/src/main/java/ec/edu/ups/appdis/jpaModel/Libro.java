package ec.edu.ups.appdis.jpaModel;

import java.io.Serializable;
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

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Libros")
@NamedQuery(name="Libro.findAll", query="SELECT s FROM Libro s")
public class Libro implements Serializable{

	private static final long serialVersionUID = 1094801825228386363L;
	
	@Id
    private int id;
	
	@NotEmpty
    private String autor;
	
	@NotEmpty
    private String titulo;
	
	@NotEmpty
	private String descripcion;
	
	@NotEmpty
	private String categoria;
	
	private Double costo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "libro")
	private List<Comentario> comentarios;

	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codigo", nullable=false)
	private Pago pago;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cedula", nullable=false)
	private Persona clienteLib;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
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

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}


	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	

	public Persona getClienteLib() {
		return clienteLib;
	}

	public void setClienteLib(Persona clienteLib) {
		this.clienteLib = clienteLib;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	
	
}
