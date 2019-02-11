package ec.edu.ups.appdis.jpa.vista;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.edu.ups.appdis.jpa.bussiness.LoginBussiness;
import ec.edu.ups.appdis.jpa.util.SessionUtils;


@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{
	
	private static final long serialVersionUID = 1094801825228386363L;
	@Inject
	private FacesContext facesContext; //cada declaracion debe tener su propio inject

	@Inject
	private LoginBussiness logBussiness;

	private String usuario;
	private String contrasenia;
	

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	
	@PostConstruct
	public void init() {
		
	}
	
	public String login(){
		
		String socio = logBussiness.Logueo(usuario, contrasenia);
		System.out.println("loguin "+socio);
		System.out.println("usuario "+usuario);
		System.out.println("usuario "+contrasenia);

		if(socio !="no")
			return "about.xhtml";
		else
		System.out.println("Usuario o contrasenia incorrectos");
		FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO,"Usuario o contraseña incorrectos", "Intente de nuevo");//se imprime la excepcion y se muestre dentro del jsf 
        facesContext.addMessage(null, m);
		return "login-datos.xhtml";
	}
	
	public String validateUsernamePassword() {
		String socio = logBussiness.Logueo(usuario, contrasenia);
		if (socio !="no") {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", usuario);
			return "inicio.xhtml";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Usuario o contraseña incorrectos",
							"Por favor introduzca nuevamente el usuario y la contraseña"));
			return "login-datos.xhtml";
		}
	}

	//logout event, invalidate session
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login-datos.xhtml";
	}
}
