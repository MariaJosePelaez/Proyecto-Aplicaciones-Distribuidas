package ec.edu.ups.appdis.jpaModel;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Persona.class)
public abstract class Persona_ {

	public static volatile SingularAttribute<Persona, Date> fecha;
	public static volatile ListAttribute<Persona, Pago> listaPagos;
	public static volatile SingularAttribute<Persona, String> cedula;
	public static volatile ListAttribute<Persona, Libro> listaLibros;
	public static volatile SingularAttribute<Persona, String> direccion;
	public static volatile SingularAttribute<Persona, String> contrasenia;
	public static volatile SingularAttribute<Persona, String> telefono;
	public static volatile SingularAttribute<Persona, String> nombre;
	public static volatile SingularAttribute<Persona, String> email;
	public static volatile ListAttribute<Persona, Comentario> listaComentarios;

}

