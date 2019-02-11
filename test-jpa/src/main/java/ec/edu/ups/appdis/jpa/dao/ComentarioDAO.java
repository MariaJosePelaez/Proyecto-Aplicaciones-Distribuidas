package ec.edu.ups.appdis.jpa.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.jpaModel.Comentario;
import ec.edu.ups.appdis.jpaModel.Libro;

public class ComentarioDAO {

	@Inject
	private EntityManager em;
	
	
	public void insert(Comentario comentario) {

		em.persist(comentario); // esta linea lo que hace el jpa el internamente hace el insert de persona y le lleva a la base de datos 
		
	}

	public void update(Comentario comentario) {

		em.merge(comentario);
	}

	public void remove(int id) {
		em.remove(read(id));
	}

	public Comentario read(int id) {

		Comentario aux = em.find(Comentario.class,id);//esta linea devuelve el registro de la base de datos que tiene esa id pero como una entidad, es solo cuando es el id de ahi hay otros 
		
		return aux;
	}

	
	/*public List<Comentario> getPersona(){
		
		String jpql = "SELECT P FROM Comentario p p.clienteCom";
		 Query query = em.createQuery(jpql,Comentario.class);
		 List<Comentario> lista = query.getResultList();
		return lista;
	}*/
	
	public List<Comentario> getPersona(){
		String jpql = "SELECT o FROM Comentario o JOIN FETCH o.clienteCom do ";
						
		Query query = em.createQuery(jpql, Comentario.class);
		List<Comentario> libro =  query.getResultList();
		return libro;
	}
}
