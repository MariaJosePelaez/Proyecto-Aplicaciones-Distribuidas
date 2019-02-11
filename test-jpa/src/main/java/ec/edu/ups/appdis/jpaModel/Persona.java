package ec.edu.ups.appdis.jpaModel;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Personas")
@NamedQuery(name="Persona.findAll", query="SELECT s FROM Persona s")

public class Persona implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotEmpty
   private String cedula;
	
	@NotEmpty
   private String nombre;
	
	@NotEmpty
	@Size(max = 60)
   private String direccion;
	
    @Temporal(TemporalType.DATE)
   private Date fecha;
	
   @NotEmpty
   private String email;
   
   @NotEmpty
   private String contrasenia;
   //hay que especificar el nombre o la columna que va a ser el foreign key
   //JoinColumn el nombre que se ponga ahi sera el nombre de la columna de relacion foreign de la tabla tengo el padre y tengo el detalle 
   //esto es para poder borrar en cascada y borre a los hijos tambien si quiero borrar al padre y quiero que tambien borre a los hijos 
   //CascadeType.ALL CON ESA PROPIEDAD LE DIJO QUE CUANDO MANDO A PERSISTIR AL PADRE HACE EL INSERT EN LOS HIJOS Y SI BORRO AL PADRE TAMBIEN SE BORRA LOS HIJOS
   //fetch hace el producto cartesiano internamente, si quiero que me devuelva los datos de las asociaciones hay el EAGER es cuando nosotros le decimos que el rato que consulte automaticamente traiga todas las relaciones
   //LAZY hace un consumo excesivo de base de datos 
   
   @NotEmpty
   private String telefono;

   @JsonIgnore
   @OneToMany(mappedBy = "cliente")
  	private List<Pago> listaPagos;
   
   @JsonIgnore
   @OneToMany(mappedBy = "clienteLib")
 	private List<Libro> listaLibros;

   @JsonIgnore
   @OneToMany(mappedBy = "clienteCom")
	private List<Comentario> listaComentarios;
   
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
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
 
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public String getContrasenia() {
	return contrasenia;
}
public void setContrasenia(String contrasenia) {
	this.contrasenia = contrasenia;

}
public List<Pago> getListaPagos() {
	return listaPagos;
}
public void setListaPagos(List<Pago> listaPagos) {
	this.listaPagos = listaPagos;
}
public List<Libro> getListaLibros() {
	return listaLibros;
}
public void setListaLibros(List<Libro> listaLibros) {
	this.listaLibros = listaLibros;
}
public List<Comentario> getListaComentarios() {
	return listaComentarios;
}
public void setListaComentarios(List<Comentario> listaComentarios) {
	this.listaComentarios = listaComentarios;
}


   
}
