package ec.edu.ups.appdis.jpa.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.jpaModel.Libro;
import ec.edu.ups.appdis.jpaModel.Persona;


public class LibroDAO {

	@Inject
	private EntityManager em;
	
	
	public void insert(Libro libro) {

		em.persist(libro); // esta linea lo que hace el jpa el internamente hace el insert de persona y le lleva a la base de datos 
		
	}

	public void update(Libro libro) {

		em.merge(libro);
	}

	public void remove(int id) {
		em.remove(read(id));
	}

	public Libro read(int id) {

		Libro aux = em.find(Libro.class,id);//esta linea devuelve el registro de la base de datos que tiene esa id pero como una entidad, es solo cuando es el id de ahi hay otros 
		
		return aux;
	}

	
	public List<Libro> getPersona(){
		
		String jpql = "SELECT o FROM Libro o JOIN FETCH o.clienteLib do ";
		 Query query = em.createQuery(jpql,Libro.class);
		 List<Libro> lista = query.getResultList();
		return lista;
	}
	
	public List<Libro> buscarLibro(String categoria){
		String jpql = "SELECT o FROM Libro o JOIN FETCH o.clienteLib do "
						+ "WHERE o.categoria = :categoria ";
		Query query = em.createQuery(jpql, Libro.class);
		query.setParameter("categoria",categoria);
		List<Libro> libro =  query.getResultList();
		return libro;
	}
	
	public List<Libro> buscarLibroporid(String email){
		String jpql = "SELECT o FROM Libro o JOIN FETCH o.clienteLib do "
						+ "WHERE o.clienteLib.email = :email ";
		Query query = em.createQuery(jpql, Libro.class);
		query.setParameter("email",email);
		List<Libro> libro =  query.getResultList();
		return libro;
	}

}
