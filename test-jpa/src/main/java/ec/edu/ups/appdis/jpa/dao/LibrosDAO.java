package ec.edu.ups.appdis.jpa.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.jpaModel.Libro;
import ec.edu.ups.appdis.jpaModel.Libros;

public class LibrosDAO {

	@Inject
	private EntityManager em;
	
	
	public void insert(Libros libro) {

		em.persist(libro); // esta linea lo que hace el jpa el internamente hace el insert de persona y le lleva a la base de datos 
		
	}

	public void update(Libros libro) {

		em.merge(libro);
	}

	public void remove(int id) {
		em.remove(read(id));
	}

	public Libros read(int id) {

		Libros aux = em.find(Libros.class,id);//esta linea devuelve el registro de la base de datos que tiene esa id pero como una entidad, es solo cuando es el id de ahi hay otros 
		
		return aux;
	}

public List<Libros> getPersona(){
		
		String jpql = "SELECT o FROM Libros o ";
		 Query query = em.createQuery(jpql,Libro.class);
		 List<Libros> lista = query.getResultList();
		return lista;
	}
}
