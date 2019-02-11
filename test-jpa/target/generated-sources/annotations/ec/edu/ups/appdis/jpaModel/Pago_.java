package ec.edu.ups.appdis.jpaModel;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pago.class)
public abstract class Pago_ {

	public static volatile SingularAttribute<Pago, Date> fecha;
	public static volatile SingularAttribute<Pago, Persona> cliente;
	public static volatile SingularAttribute<Pago, Integer> codigo;
	public static volatile ListAttribute<Pago, Libro> listaLibros;
	public static volatile SingularAttribute<Pago, Double> costoTotal;
	public static volatile SingularAttribute<Pago, String> formaPago;

}

