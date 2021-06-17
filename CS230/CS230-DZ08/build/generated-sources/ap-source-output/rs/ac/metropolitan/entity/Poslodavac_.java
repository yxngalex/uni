package rs.ac.metropolitan.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import rs.ac.metropolitan.entity.Korisnik;
import rs.ac.metropolitan.entity.Poruka;
import rs.ac.metropolitan.entity.Poslovi;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-08T16:20:58")
@StaticMetamodel(Poslodavac.class)
public class Poslodavac_ { 

    public static volatile CollectionAttribute<Poslodavac, Poslovi> posloviCollection;
    public static volatile SingularAttribute<Poslodavac, Date> createdDate;
    public static volatile SingularAttribute<Poslodavac, Integer> recordStatus;
    public static volatile SingularAttribute<Poslodavac, Date> lastModifiedDate;
    public static volatile SingularAttribute<Poslodavac, String> lastModifiedBy;
    public static volatile SingularAttribute<Poslodavac, Poruka> idPoruke;
    public static volatile SingularAttribute<Poslodavac, Integer> idPoslodavca;
    public static volatile SingularAttribute<Poslodavac, Korisnik> idKorisnika;

}