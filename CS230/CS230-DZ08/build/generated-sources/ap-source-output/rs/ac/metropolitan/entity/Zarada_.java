package rs.ac.metropolitan.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import rs.ac.metropolitan.entity.Radnik;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-08T16:20:58")
@StaticMetamodel(Zarada.class)
public class Zarada_ { 

    public static volatile SingularAttribute<Zarada, Long> vrednost;
    public static volatile SingularAttribute<Zarada, Date> createdDate;
    public static volatile SingularAttribute<Zarada, Integer> recordStatus;
    public static volatile SingularAttribute<Zarada, Date> lastModifiedDate;
    public static volatile SingularAttribute<Zarada, Integer> mesec;
    public static volatile SingularAttribute<Zarada, String> lastModifiedBy;
    public static volatile SingularAttribute<Zarada, Integer> idZarade;
    public static volatile SingularAttribute<Zarada, Radnik> idRadnika;

}