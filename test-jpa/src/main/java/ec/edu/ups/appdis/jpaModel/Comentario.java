package ec.edu.ups.appdis.jpaModel;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "Comentarios")
@NamedQuery(name="Comentario.findAll", query="SELECT s FROM Comentario s")
public class Comentario implements Serializable{

	
	private static final long serialVersionUID = 1094801825228386363L;
	
	@Id
	@GeneratedValue
    private int codigo;
	
	@NotEmpty
	private String texto;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id", nullable=false)
	private Libro libro;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cedula", nullable=false)
	private Persona clienteCom;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Persona getClienteCom() {
		return clienteCom;
	}

	public void setClienteCom(Persona clienteCom) {
		this.clienteCom = clienteCom;
	}
	
	
	
}
