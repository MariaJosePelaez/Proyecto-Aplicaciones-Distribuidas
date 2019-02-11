package ec.edu.ups.appdis.jpa.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.appdis.jpa.dao.LibroDAO;
import ec.edu.ups.appdis.jpaModel.Libro;


@Stateless
public class LibroBussiness {

	@Inject
	private LibroDAO dao;

	public void save(Libro libro) throws Exception {

		Libro aux = dao.read(libro.getId());
		if (aux != null) {

			throw new Exception("Libro ya registrado");

		} else {
			
				dao.insert(libro);
				System.out.println("Libro registrado exitosamente");
			
		}

	}

	public List<Libro> getListadoLibro() {
		return dao.getPersona();
	}

	public void eliminar(int codigo) throws Exception {
		Libro aux = dao.read(codigo);
		if (aux == null) {

			throw new Exception("Libro no registrado");

		} else {

			dao.remove(codigo);

		}

	}

	public List<Libro> buscar(String categoria) {
		return dao.buscarLibro(categoria);
	}

	public void actualizar(Libro libro) throws Exception {
		Libro aux = dao.read(libro.getId());
		if (aux == null) {

			throw new Exception("Libro ya registrado");

		} else {

			dao.update(libro);

		}

	}
	
	public List<Libro> buscarLibroPorId(String email) {
		return dao.buscarLibroporid(email);
	}
}
