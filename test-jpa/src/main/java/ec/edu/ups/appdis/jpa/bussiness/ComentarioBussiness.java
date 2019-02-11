package ec.edu.ups.appdis.jpa.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.appdis.jpa.dao.ComentarioDAO;
import ec.edu.ups.appdis.jpaModel.Comentario;

@Stateless
public class ComentarioBussiness {

	@Inject
	private ComentarioDAO dao;

	public void save(Comentario comentario) throws Exception {

		Comentario aux = dao.read(comentario.getCodigo());
		if (aux != null) {

			throw new Exception("Comentario ya registrado");

		} else {
			
				dao.insert(comentario);
				System.out.println("Comentario registrado exitosamente");
			
		}

	}

	public List<Comentario> getListadoComentario() {
		return dao.getPersona();
	}

	public void eliminar(int codigo) throws Exception {
		Comentario aux = dao.read(codigo);
		if (aux == null) {

			throw new Exception("Comentario no registrado");

		} else {

			dao.remove(codigo);

		}

	}

	public Comentario buscar(int codigo) {
		return dao.read(codigo);
	}

	public void actualizar(Comentario comentario) throws Exception {
		Comentario aux = dao.read(comentario.getCodigo());
		if (aux == null) {

			throw new Exception("Comentario ya registrado");

		} else {

			dao.update(comentario);

		}

	}
}
