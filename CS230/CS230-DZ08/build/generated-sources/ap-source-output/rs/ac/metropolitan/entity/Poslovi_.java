package rs.ac.metropolitan.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import rs.ac.metropolitan.entity.Ocena;
import rs.ac.metropolitan.entity.Ponuda;
import rs.ac.metropolitan.entity.Poslodavac;
import rs.ac.metropolitan.entity.Radnik;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-08T16:20:58")
@StaticMetamodel(Poslovi.class)
public class Poslovi_ { 

    public static volatile SingularAttribute<Poslovi, Integer> idPosla;
    public static volatile SingularAttribute<Poslovi, Date> lastModifiedDate;
    public static volatile SingularAttribute<Poslovi, String> lastModifiedBy;
    public static volatile SingularAttribute<Poslovi, String> naziv;
    public static volatile SingularAttribute<Poslovi, Poslodavac> idPoslodavca;
    public static volatile SingularAttribute<Poslovi, Long> maksBudzet;
    public static volatile SingularAttribute<Poslovi, Integer> brojPotrebnihRadnika;
    public static volatile SingularAttribute<Poslovi, Date> createdDate;
    public static volatile SingularAttribute<Poslovi, Integer> recordStatus;
    public static volatile SingularAttribute<Poslovi, Integer> duzinaTrajanja;
    public static volatile SingularAttribute<Poslovi, String> kljucnaRec;
    public static volatile CollectionAttribute<Poslovi, Ponuda> ponudaCollection;
    public static volatile CollectionAttribute<Poslovi, Radnik> radnikCollection;
    public static volatile SingularAttribute<Poslovi, String> opis;
    public static volatile CollectionAttribute<Poslovi, Ocena> ocenaCollection;

}