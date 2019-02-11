package ec.edu.ups.appdis.jpa.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.appdis.jpa.dao.PersonaDAO;
import ec.edu.ups.appdis.jpaModel.Persona;

//@Local para implementar remoto y local
@Stateless
public class PersonaBussiness {
	// la idea de estos metodos apliquen a reglas de negocios, calculos, descuentos,
	// en los objetos de negocio
	// que consuman la misma logica y no cada uno tenga que crear, si hacemso
	// referencia con ejb remoto se utiliza este mismo objeto de negocio la misma
	// logica para todos

	@Inject // si no se pone esto va a entender que es nulo
	// deme el objeto persona dao
	private PersonaDAO dao;

	public boolean save(Persona persona) throws Exception {

		// para saber si existe la persona
		Boolean estado = validarCedula(persona.getCedula());

		Persona aux = dao.read(persona.getCedula());
		if (aux != null) {

			throw new Exception("Persona ya registrada");

		} else {
			
			if(estado==true) {
				dao.insert(persona);
				return true;
			}
			System.out.println("Cedula incorrecta");
			return false;
		}

	}

	public List<Persona> getListadoPersona() {
		return dao.getPersona();
	}
	
	public List<Persona> getListadoPersonas() {
		return dao.obtenerLibros();
	}

	public void eliminar(String cedula) throws Exception {
		Persona aux = dao.read(cedula);
		if (aux == null) {

			throw new Exception("Persona no registrada");

		} else {

			dao.remove(cedula);

		}

	}

	public Persona buscar(String cedula) {
		return dao.read(cedula);
	}

	public void actualizar(Persona persona) throws Exception {
		Persona aux = dao.read(persona.getCedula());
		if (aux == null) {

			throw new Exception("Persona no registrada");

		} else {

			dao.update(persona);

		}

	}
	
	public boolean validarCedula(String cedula) {
		if (cedula != null) {
			String nueveDig = "";
			int pares = 0;
			int impares = 0;
			int mayorimpa = 0;
			int mayorimp = 0;
			int menorimpa = 0;
			int sumaImpares = 0;
			int resultado;
			int res;
			int resFinal;

			if (cedula.matches("[0-9]*")) {
				if (cedula.length() == 10) {
					if (Integer.parseInt(cedula.substring(0, 2)) >= 01
							&& Integer.parseInt(cedula.substring(0, 2)) <= 24) {
						// System.out.println("el numero es correcto");
						// System.out.println(Integer.parseInt(cedula.substring(2,3)));
						if (Integer.parseInt(cedula.substring(2, 3)) >= 0
								&& Integer.parseInt(cedula.substring(2, 3)) <= 5) {
							nueveDig = cedula.substring(0, 9);
							char[] digitos = nueveDig.toCharArray();

							for (int i = 0; i < digitos.length; i++) {
								if (i % 2 == 0) {
									// System.out.println("numeros impares "+digitos[i]);
									impares = Integer.parseInt("" + digitos[i]) * 2;
									// System.out.println("impares " + impares[i]);

									if (impares > 9) {
										mayorimp = impares - 9;
										mayorimpa += mayorimp;

										// System.out.println("impares mayores a 9 " + mayorimpa);
									} else {
										menorimpa = menorimpa + impares;
										// System.out.println("impares menores a 9 " + menorimpa);
									}
								} else {
									pares += Integer.parseInt("" + digitos[i]);
								}
							}
							sumaImpares = menorimpa + mayorimpa;

							resultado = sumaImpares + pares;

							res = resultado % 10;

							if (res == 0) {
								System.out.println("Cedula correcta");
								return true;
							} else {
								resFinal = 10 - res;

								if (resFinal == Integer.parseInt(cedula.substring(9, 10))) {
									System.out.println("resFinal  " + resFinal);
									System.out.println("Cedula " + cedula.substring(9, 10));
									System.out.println("Cedula Correcta");
									return true;
								} else {
									System.out.println("Cedula incorrecta");
								}
							}
						} else {
							System.out.println("fuera de rango de 0 a 5");
							return false;
						}
					} else {
						System.out.println("fuera de rango de 01 a 24");
						return false;
					}

				} else {
					System.out.println("Fuera de rango 10");
					return false;
				}
			} else {
				System.out.println("no valido");
				return false;
			}
		}
		return false;
	}

}
