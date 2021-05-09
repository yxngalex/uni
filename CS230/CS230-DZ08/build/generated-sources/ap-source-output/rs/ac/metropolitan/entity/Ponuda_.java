package rs.ac.metropolitan.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import rs.ac.metropolitan.entity.Poslovi;
import rs.ac.metropolitan.entity.Radnik;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-08T16:20:58")
@StaticMetamodel(Ponuda.class)
public class Ponuda_ { 

    public static volatile SingularAttribute<Ponuda, Poslovi> idPosla;
    public static volatile SingularAttribute<Ponuda, String> kratakopis;
    public static volatile SingularAttribute<Ponuda, Long> predlozenacena;
    public static volatile SingularAttribute<Ponuda, Date> createdDate;
    public static volatile SingularAttribute<Ponuda, Integer> recordStatus;
    public static volatile SingularAttribute<Ponuda, Date> lastModifiedDate;
    public static volatile SingularAttribute<Ponuda, String> lastModifiedBy;
    public static volatile CollectionAttribute<Ponuda, Radnik> radnikCollection;
    public static volatile SingularAttribute<Ponuda, Integer> idPonude;

}