package ec.edu.ups.appdis.jpa.vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.appdis.jpa.bussiness.PagoBussiness;
import ec.edu.ups.appdis.jpaModel.Pago;

@ManagedBean
public class PagoBean {

	@Inject
	private PagoBussiness pBussiness;
	
	@Inject
	private FacesContext facesContext; //cada declaracion debe tener su propio inject
	
	private Pago newPago;
	
	private List<Pago> pagos; //necesito un bean property para poder exponer datos 
	
	private boolean editing=false;
	
	@PostConstruct // poesterior a que se construya 
	private void init() {
		newPago = new Pago();
		editing = false;
		pagos = pBussiness.listarPago();
	
	}
	
	public PagoBussiness getpBussiness() {
		return pBussiness;
	}

	public void setpBussiness(PagoBussiness pBussiness) {
		this.pBussiness = pBussiness;
	}



	public Pago getNewPago() {
		return newPago;
	}



	public void setNewPago(Pago newPago) {
		this.newPago = newPago;
	}



	public List<Pago> getPagos() {
		return pagos;
	}



	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
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
 
			pBussiness.actualizar(newPago);	
			else
			pBussiness.save(newPago);
				System.out.println("registro guardado");
				return "listaPagos?faces-redirect=true";
			
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
			return "listaPagos?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error al guardar");
			e.printStackTrace();
			
			 FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO,e.getMessage(), "Delete successful"); 
		}
		
		return null;
	}

	public String editar(Pago pago) {
		editing = true;
		newPago = pago;	
		return "registro-pagos";
	}
	
}
