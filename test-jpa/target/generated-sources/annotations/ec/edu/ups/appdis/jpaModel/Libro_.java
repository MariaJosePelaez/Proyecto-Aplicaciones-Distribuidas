package ec.edu.ups.appdis.jpaModel;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Libro.class)
public abstract class Libro_ {

	public static volatile SingularAttribute<Libro, String> descripcion;
	public static volatile SingularAttribute<Libro, Double> costo;
	public static volatile SingularAttribute<Libro, Persona> clienteLib;
	public static volatile SingularAttribute<Libro, String> categoria;
	public static volatile SingularAttribute<Libro, String> titulo;
	public static volatile SingularAttribute<Libro, Integer> id;
	public static volatile ListAttribute<Libro, Comentario> comentarios;
	public static volatile SingularAttribute<Libro, Pago> pago;
	public static volatile SingularAttribute<Libro, String> autor;

}

