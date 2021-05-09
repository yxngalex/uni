package rs.ac.metropolitan.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import rs.ac.metropolitan.entity.Poslovi;
import rs.ac.metropolitan.entity.Radnik;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-08T16:20:58")
@StaticMetamodel(Ocena.class)
public class Ocena_ { 

    public static volatile SingularAttribute<Ocena, Poslovi> idPosla;
    public static volatile SingularAttribute<Ocena, Date> createdDate;
    public static volatile SingularAttribute<Ocena, Integer> recordStatus;
    public static volatile SingularAttribute<Ocena, Date> lastModifiedDate;
    public static volatile SingularAttribute<Ocena, Integer> idOcene;
    public static volatile SingularAttribute<Ocena, String> lastModifiedBy;
    public static volatile SingularAttribute<Ocena, Radnik> idRadnika;
    public static volatile SingularAttribute<Ocena, Integer> ocena;

}