package ec.edu.ups.appdis.jpa.serviciosweb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import ec.edu.ups.appdis.jpa.bussiness.LibroBussiness;
import ec.edu.ups.appdis.jpa.bussiness.LoginBussiness;
import ec.edu.ups.appdis.jpa.bussiness.PagoBussiness;
import ec.edu.ups.appdis.jpa.bussiness.PersonaBussiness;
import ec.edu.ups.appdis.jpaModel.Libro;
import ec.edu.ups.appdis.jpaModel.Pago;
import ec.edu.ups.appdis.jpaModel.Persona;

//expuesto un servicio de tipo resful que me devuelve un listado de personas

@Path("/personas")
public class PersonasServicesRest {

	@Inject
	private PersonaBussiness pBussiness;
	@Inject
	private LoginBussiness loguinBussiness;
	@Inject
	private LibroBussiness libroBussiness;
	
	@Inject
	private PagoBussiness pagoBussiness;

	@GET
	@Path("/listado")
	@Produces("application/json")
	public List<Persona> getPersonas() {

		return pBussiness.getListadoPersona();
	}
	
	@GET
	@Path("/listado-libro")
	@Produces("application/json")
	public List<Libro> getListadoLibro() {

		return libroBussiness.getListadoLibro();
	}

	@POST
	@Path("/insertar-comentario")
	@Produces("application/json")
	@Consumes("application/json")
	public Response insertar(Pago pago) {

		Response.ResponseBuilder builder = null;

		Map<String, String> data = new HashMap<>();

		try {
			pagoBussiness.save(pago);
			data.put("code", "1");
			data.put("message", "OK");
			builder = Response.status(Response.Status.OK).entity(data);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			data.put("code", "99");
			data.put("message", e.getMessage());
			builder = Response.status(Response.Status.OK).entity(data);
		}

		return builder.build();

	}
	
	@GET
	@Path("/buscar-libro")
	@Produces("application/json")
	public List<Libro> buscarLibro(@QueryParam("categoria") String categoria) {

		System.out.println("persona encontrada: " + libroBussiness.buscar(categoria));
		return libroBussiness.buscar(categoria);

	}
	
	@GET
	@Path("/buscar-libro-id")
	@Produces("application/json")
	public List<Libro> buscarLibroId(@QueryParam("email") String email) {

		System.out.println("persona encontrada: " + libroBussiness.buscarLibroPorId(email));
		return libroBussiness.buscarLibroPorId(email);

	}
	
	@GET
	@Path("/listar-pago")
	@Produces("application/json")
	public List<Pago> listarPago() {

		System.out.println("persona encontrada: " + pagoBussiness.listarPago());
		return pagoBussiness.listarPago();

	}
	
	@GET
	@Path("/loguin")
	@Produces("application/json")
	public Persona loguin(@QueryParam("email") String usuario,@QueryParam("contrasenia") String contrasenia) {

		System.out.println("persona encontrada: " + loguinBussiness.Logueo(usuario, contrasenia));
		return loguinBussiness.LogueoMovil(usuario, contrasenia);

	}
	
	

}
