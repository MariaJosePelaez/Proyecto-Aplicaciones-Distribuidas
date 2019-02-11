package ec.edu.ups.appdis.jpa.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.jpaModel.Pago;

public class PagoDAO {

	@Inject
	private EntityManager em;
	
	
	public void insert(Pago pago) {

		em.persist(pago); // esta linea lo que hace el jpa el internamente hace el insert de persona y le lleva a la base de datos 
		
	}

	public void update(Pago pago) {

		em.merge(pago);
	}

	public void remove(int id) {
		em.remove(read(id));
	}

	public Pago read(int id) {

		Pago aux = em.find(Pago.class,id);//esta linea devuelve el registro de la base de datos que tiene esa id pero como una entidad, es solo cuando es el id de ahi hay otros 
		
		return aux;
	}

	
	public List<Pago> getPersona(){
		
		String jpql = "SELECT P FROM Pago p ";
		 Query query = em.createQuery(jpql,Pago.class);
		 List<Pago> lista = query.getResultList();
		return lista;
	}
	
	public List<Pago> buscarPago(){
		String jpql = "SELECT o FROM Pago o JOIN FETCH o.listaLibros do "
						+ "JOIN FETCH o.cliente dir ";
		Query query = em.createQuery(jpql, Pago.class);
		List<Pago> orden =query.getResultList();
		return orden;
	}

}
