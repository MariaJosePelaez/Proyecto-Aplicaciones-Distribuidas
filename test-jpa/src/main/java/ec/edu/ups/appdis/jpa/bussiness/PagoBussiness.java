package ec.edu.ups.appdis.jpa.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.appdis.jpa.dao.PagoDAO;
import ec.edu.ups.appdis.jpaModel.Pago;

@Stateless
public class PagoBussiness {

	@Inject
	private PagoDAO dao;

	public void save(Pago pago) throws Exception {

		Pago aux = dao.read(pago.getCodigo());
		if (aux != null) {

			throw new Exception("Pago ya registrado");

		} else {
			
				dao.insert(pago);
				System.out.println("Pago registrado exitosamente");
			
		}

	}

	public List<Pago> getListadoPago() {
		return dao.getPersona();
	}

	public void eliminar(int codigo) throws Exception {
		Pago aux = dao.read(codigo);
		if (aux == null) {

			throw new Exception("Pago no registrado");

		} else {

			dao.remove(codigo);

		}

	}

	public Pago buscar(int codigo) {
		return dao.read(codigo);
	}
	
	public List<Pago> listarPago() {
		return dao.buscarPago();
	}

	public void actualizar(Pago pago) throws Exception {
		Pago aux = dao.read(pago.getCodigo());
		if (aux == null) {

			throw new Exception("Pago ya registrado");

		} else {

			dao.update(pago);

		}

	}
}
