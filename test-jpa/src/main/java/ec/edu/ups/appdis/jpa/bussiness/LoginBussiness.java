package ec.edu.ups.appdis.jpa.bussiness;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.appdis.jpa.dao.LoginDAO;
import ec.edu.ups.appdis.jpaModel.Estado;
import ec.edu.ups.appdis.jpaModel.Persona;

@Stateless
public class LoginBussiness {
	
	@Inject
	private  LoginDAO logDao;
	
	public String Logueo (String correo, String contrasenia) {
		Persona persona = logDao.BuscarLog(correo,contrasenia);
		System.out.println("logueo Bussiness "+persona);
		if(persona !=null) 
			return "si";
		else
		return "no";
	}
	
	public Persona LogueoMovil (String correo, String contrasenia) {
		Persona persona = logDao.BuscarLog(correo,contrasenia);
		System.out.println("logueo Bussiness "+persona);
		
		if(persona !=null) {
			return persona;
		
	}
		return null;
}

}
