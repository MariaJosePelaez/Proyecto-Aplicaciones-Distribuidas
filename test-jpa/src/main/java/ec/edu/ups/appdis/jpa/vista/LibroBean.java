package ec.edu.ups.appdis.jpa.vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.appdis.jpa.bussiness.LibroBussiness;
import ec.edu.ups.appdis.jpaModel.Libro;


@ManagedBean
public class LibroBean {

	@Inject
	private LibroBussiness pBussiness;
	
	@Inject
	private FacesContext facesContext; //cada declaracion debe tener su propio inject
	
	private Libro newLibro;
	
	private List<Libro> libros; //necesito un bean property para poder exponer datos 
	
	private boolean editing=false;
	
	@PostConstruct // poesterior a que se construya 
	private void init() {
		newLibro = new Libro();
		
		editing = false;
		libros = pBussiness.getListadoLibro();
	
	}
	
	

	public LibroBussiness getpBussiness() {
		return pBussiness;
	}



	public void setpBussiness(LibroBussiness pBussiness) {
		this.pBussiness = pBussiness;
	}



	public Libro getNewLibro() {
		return newLibro;
	}



	public void setNewLibro(Libro newLibro) {
		this.newLibro = newLibro;
	}



	public List<Libro> getLibros() {
		return libros;
	}



	public void setLibros(List<Libro> libros) {
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

	public String editar(Libro libro) {
		editing = true;
		newLibro = libro;	
		return "registro-libro";
	}
}
