package ec.edu.ups.appdis.jpa.util;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Resources {
	
	@Produces    //estas tres lines dicen estas tres lineas esxpongan en mi api ccdi
	@PersistenceContext   // estas dos lineas proveen a la conexion con la base de datos yo ya tengo acceso a la base de datos, esto lo que hace es pedir al servidor
	
	private EntityManager em;
	
	  @Produces
	    public Logger produceLog(InjectionPoint injectionPoint) {
	        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	    }

	    @Produces
	    @RequestScoped
	    public FacesContext produceFacesContext() {
	        return FacesContext.getCurrentInstance();
	    }
	
}
