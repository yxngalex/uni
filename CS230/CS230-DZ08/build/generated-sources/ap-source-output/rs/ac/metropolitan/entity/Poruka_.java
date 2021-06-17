package rs.ac.metropolitan.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import rs.ac.metropolitan.entity.Poslodavac;
import rs.ac.metropolitan.entity.Radnik;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-08T16:20:58")
@StaticMetamodel(Poruka.class)
public class Poruka_ { 

    public static volatile SingularAttribute<Poruka, Date> createdDate;
    public static volatile SingularAttribute<Poruka, Integer> recordStatus;
    public static volatile SingularAttribute<Poruka, Date> lastModifiedDate;
    public static volatile SingularAttribute<Poruka, Integer> idPoruke;
    public static volatile SingularAttribute<Poruka, String> lastModifiedBy;
    public static volatile SingularAttribute<Poruka, String> poruka;
    public static volatile CollectionAttribute<Poruka, Poslodavac> poslodavacCollection;
    public static volatile CollectionAttribute<Poruka, Radnik> radnikCollection;

}