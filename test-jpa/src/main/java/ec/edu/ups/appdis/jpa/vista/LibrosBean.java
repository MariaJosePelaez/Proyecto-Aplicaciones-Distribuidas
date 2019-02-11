package ec.edu.ups.appdis.jpa.vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.appdis.jpa.bussiness.LibroBussiness;
import ec.edu.ups.appdis.jpa.bussiness.LibrosBussiness;
import ec.edu.ups.appdis.jpaModel.Libro;
import ec.edu.ups.appdis.jpaModel.Libros;

@ManagedBean
public class LibrosBean {

	@Inject
	private LibrosBussiness pBussiness;
	
	@Inject
	private FacesContext facesContext; //cada declaracion debe tener su propio inject
	
	private Libros newLibro;
	
	private List<Libros> libros; //necesito un bean property para poder exponer datos 
	
	private boolean editing=false;
	
	@PostConstruct // poesterior a que se construya 
	private void init() {
		newLibro = new Libros();
		
		editing = false;
		libros = pBussiness.getListadoLibro();
	
	}
	
	

	public LibrosBussiness getpBussiness() {
		return pBussiness;
	}



	public void setpBussiness(LibrosBussiness pBussiness) {
		this.pBussiness = pBussiness;
	}



	public Libros getNewLibro() {
		return newLibro;
	}



	public void setNewLibro(Libros newLibro) {
		this.newLibro = newLibro;
	}



	public List<Libros> getLibros() {
		return libros;
	}



	public void setLibros(List<Libros> libros) {
		this.libros = libros;
	}



	public boolean isEditing() {
		return editing;
	}

	public void setEditing(boolean editing) {
		this.editing = editing;
	}

	public String guardar() {
		System.out.println("editando" + editing);
		try {
			if(editing)
 
			pBussiness.actualizar(newLibro);	
			else
			pBussiness.save(newLibro);
				System.out.println("registro guardado");
				return "listaLibro?faces-redirect=true";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error al guardar");
			e.printStackTrace();
			 FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO,e.getMessage(), "Error al guardar");

		}
		
		return null;
	}
	
public String eliminar(int codigo) {
		
		try {
			pBussiness.eliminar(codigo);
			System.out.println("registro guardado");
			return "listaLibro?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error al guardar");
			e.printStackTrace();
			
			 FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO,e.getMessage(), "Delete successful"); 
		}
		
		return null;
	}

	public String editar(Libros libro) {
		editing = true;
		newLibro = libro;	
		return "registro-libro";
	}
}
