package ec.edu.ups.appdis.jpa.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.appdis.jpa.dao.LibroDAO;
import ec.edu.ups.appdis.jpa.dao.LibrosDAO;
import ec.edu.ups.appdis.jpaModel.Libro;
import ec.edu.ups.appdis.jpaModel.Libros;

@Stateless
public class LibrosBussiness {

	@Inject
	private LibrosDAO dao;

	public void save(Libros libro) throws Exception {

		Libros aux = dao.read(libro.getId());
		if (aux != null) {

			throw new Exception("Libro ya registrado");

		} else {
			
				dao.insert(libro);
				System.out.println("Libro registrado exitosamente");
			
		}

	}

	public List<Libros> getListadoLibro() {
		return dao.getPersona();
	}

	public void eliminar(int codigo) throws Exception {
		Libros aux = dao.read(codigo);
		if (aux == null) {

			throw new Exception("Libro no registrado");

		} else {

			dao.remove(codigo);

		}

	}



	public void actualizar(Libros libro) throws Exception {
		Libros aux = dao.read(libro.getId());
		if (aux == null) {

			throw new Exception("Libro ya registrado");

		} else {

			dao.update(libro);

		}

	}
	
}
