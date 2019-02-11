package ec.edu.ups.appdis.jpaModel;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Comentario.class)
public abstract class Comentario_ {

	public static volatile SingularAttribute<Comentario, String> texto;
	public static volatile SingularAttribute<Comentario, Libro> libro;
	public static volatile SingularAttribute<Comentario, Integer> codigo;
	public static volatile SingularAttribute<Comentario, Persona> clienteCom;

}

