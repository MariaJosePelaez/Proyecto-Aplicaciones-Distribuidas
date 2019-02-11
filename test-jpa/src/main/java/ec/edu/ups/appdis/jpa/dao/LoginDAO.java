package ec.edu.ups.appdis.jpa.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.jpaModel.Persona;

public class LoginDAO {
	
	@Inject
	private EntityManager em;

	public Persona BuscarLog(String email, String contrasenia) {
		try {
		
		Query query = em.createQuery("SELECT s FROM Persona s WHERE s.email =:email AND s.contrasenia =:contrasenia" , Persona.class); 
		query.setParameter("email", email);
		query.setParameter("contrasenia", contrasenia);
		Persona persona = (Persona) query.getSingleResult();
	    System.out.println("socio encontrado "+persona.getNombre());
	    if(persona!=null)
		return persona;
	    	
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
