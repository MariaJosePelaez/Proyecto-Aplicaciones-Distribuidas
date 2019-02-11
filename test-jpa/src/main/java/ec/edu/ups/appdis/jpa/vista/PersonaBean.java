package ec.edu.ups.appdis.jpa.vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.appdis.jpa.bussiness.PersonaBussiness;
import ec.edu.ups.appdis.jpaModel.Persona;


@ManagedBean
public class PersonaBean {

	@Inject
	private PersonaBussiness pBussiness;
	
	@Inject
	private FacesContext facesContext; //cada declaracion debe tener su propio inject
	
	private Persona newPersona;
	
	private List<Persona> personas; //necesito un bean property para poder exponer datos 
	
	private boolean editing=false;
	
	@PostConstruct // poesterior a que se construya 
	private void init() {
		newPersona = new Persona();
		editing = false;
		personas = pBussiness.getListadoPersona();
	
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public Persona getNewPersona() {
		return newPersona;
	}

	public void setNewPersona(Persona newPersona) {
		this.newPersona = newPersona;
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
			//bandera 
			pBussiness.actualizar(newPersona);	
			else
			if(pBussiness.save(newPersona)==true) {
				System.out.println("registro guardado");
				return "listPersonas?faces-redirect=true";
			}else {
				System.out.println("Cedula incorrecta");
				FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO,"Cedula Incorrecta", "Registro incorrecto");//se imprime la excepcion y se muestre dentro del jsf 
	            facesContext.addMessage(null, m);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error al guardar");
			e.printStackTrace();
			 FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO,e.getMessage(), "Error al guardar");//se imprime la excepcion y se muestre dentro del jsf 
	            facesContext.addMessage(null, m);//objeto que tiene referencia a la vista de un cliente del cliente que hace la solicitud 
	            
	            //logger significa que sobre el sout hay una implementacion que mejora el tipo de manejo de logs ya se clasifican de diferentes niveles de bugs activar en un ambiente de desarrollo todos los logs 
	            //y en ambiente de produccion no se van a ver 
	            
	            //se configura cuando ya no quiero que se miestre se puede configurar errores fatales y se puede configurar que mande un error al correo 
	            //existe la posibilidad de mandat a un archivo los logs y a una base de datos 
		}
		
		return null;
	}
	
public String eliminar(String cedula) {
		
		try {
			pBussiness.eliminar(cedula);
			System.out.println("registro guardado");
			return "listPersonas?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error al guardar");
			e.printStackTrace();
			
			 FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO,e.getMessage(), "Delete successful");//se imprime la excepcion y se muestre dentro del jsf 
	            facesContext.addMessage(null, m);//objeto que tiene referencia a la vista de un cliente del cliente que hace la solicitud 
	            
	            //logger significa que sobre el sout hay una implementacion que mejora el tipo de manejo de logs ya se clasifican de diferentes niveles de bugs activar en un ambiente de desarrollo todos los logs 
	            //y en ambiente de produccion no se van a ver 
	            
	            //se configura cuando ya no quiero que se miestre se puede configurar errores fatales y se puede configurar que mande un error al correo 
	            //existe la posibilidad de mandat a un archivo los logs y a una base de datos 
		}
		
		return null;
	}

	public String editar(Persona persona) {
		editing = true;
		newPersona = persona;	
		return "registro-usuario";
	}
		
}
