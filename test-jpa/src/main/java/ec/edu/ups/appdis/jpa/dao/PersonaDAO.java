package ec.edu.ups.appdis.jpa.dao;

import java.util.List;


import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.jpaModel.Persona;

  //para los objetis de acceso a datos deben ser sin estado, se recomienda para esta tipo de objetos porq tienen anexado el control de la transaccionalidad en el caso de una falla hacen un rollbak y si va bien un commit
public class PersonaDAO {

	
	//@PersistenceContext   // estas dos lineas proveen a la conexion con la base de datos yo ya tengo acceso a la base de datos, esto lo que hace es pedir al servidor
	@Inject
	private EntityManager em;
	
	
	public void insert(Persona persona) {

		em.persist(persona); // esta linea lo que hace el jpa el internamente hace el insert de persona y le lleva a la base de datos 
		
	}

	public void update(Persona persona) {

		em.merge(persona);
	}

	public void remove(String id) {
		em.remove(read(id));
	}

	public Persona read(String id) {

		Persona aux = em.find(Persona.class,id);//esta linea devuelve el registro de la base de datos que tiene esa id pero como una entidad, es solo cuando es el id de ahi hay otros 
		
		return aux;
	}

	
	public List<Persona> getPersona(){
		
		String jpql = "SELECT P FROM Persona p ";
		 Query query = em.createQuery(jpql,Persona.class);
		 List<Persona> lista = query.getResultList();
		return lista;
	}
	
	
	
	public List<Persona> obtenerLibros(){
		String jpql = "SELECT o FROM Persona o JOIN FETCH o.listaPagos do ";
		Query query = em.createQuery(jpql, Persona.class);
		List<Persona> libro =  query.getResultList();
		for(Persona l : libro) {			
			l.getCedula();
			l.getNombre();
		}
		return libro;
	}
	

}
