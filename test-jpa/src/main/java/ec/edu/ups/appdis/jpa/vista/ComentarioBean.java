package ec.edu.ups.appdis.jpa.vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.appdis.jpa.bussiness.ComentarioBussiness;
import ec.edu.ups.appdis.jpaModel.Comentario;

@ManagedBean
public class ComentarioBean {

	@Inject
	private ComentarioBussiness pBussiness;
	
	@Inject
	private FacesContext facesContext; //cada declaracion debe tener su propio inject
	
	private Comentario newComentario;
	
	private List<Comentario> comentarios; //necesito un bean property para poder exponer datos 
	
	private boolean editing=false;
	
	@PostConstruct // poesterior a que se construya 
	private void init() {
		newComentario = new Comentario();
		editing = false;
		comentarios = pBussiness.getListadoComentario();
	
	}
	
	


	public ComentarioBussiness getpBussiness() {
		return pBussiness;
	}




	public void setpBussiness(ComentarioBussiness pBussiness) {
		this.pBussiness = pBussiness;
	}




	public Comentario getNewComentario() {
		return newComentario;
	}




	public void setNewComentario(Comentario newComentario) {
		this.newComentario = newComentario;
	}




	public List<Comentario> getComentarios() {
		return comentarios;
	}




	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
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
 
			pBussiness.actualizar(newComentario);	
			else
			pBussiness.save(newComentario);
				System.out.println("registro guardado");
				return "listPersonas?faces-redirect=true";
			
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
			return "listPersonas?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error al guardar");
			e.printStackTrace();
			
			 FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO,e.getMessage(), "Delete successful"); 
		}
		
		return null;
	}

	public String editar(Comentario comentario) {
		editing = true;
		newComentario = comentario;	
		return "create-persona";
	}
}
