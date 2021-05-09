package rs.ac.metropolitan.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import rs.ac.metropolitan.entity.Radnik;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-08T16:20:58")
@StaticMetamodel(Fajlovi.class)
public class Fajlovi_ { 

    public static volatile SingularAttribute<Fajlovi, Integer> idFajla;
    public static volatile SingularAttribute<Fajlovi, Date> createdDate;
    public static volatile SingularAttribute<Fajlovi, Integer> recordStatus;
    public static volatile SingularAttribute<Fajlovi, String> tipFajla;
    public static volatile SingularAttribute<Fajlovi, Date> lastModifiedDate;
    public static volatile SingularAttribute<Fajlovi, String> lastModifiedBy;
    public static volatile SingularAttribute<Fajlovi, Radnik> idRadnika;

}