package rs.ac.metropolitan.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import rs.ac.metropolitan.entity.Administrator;
import rs.ac.metropolitan.entity.Poslodavac;
import rs.ac.metropolitan.entity.Radnik;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-08T16:20:58")
@StaticMetamodel(Korisnik.class)
public class Korisnik_ { 

    public static volatile SingularAttribute<Korisnik, String> ime;
    public static volatile SingularAttribute<Korisnik, String> prezime;
    public static volatile SingularAttribute<Korisnik, Date> createdDate;
    public static volatile SingularAttribute<Korisnik, Integer> recordStatus;
    public static volatile CollectionAttribute<Korisnik, Administrator> administratorCollection;
    public static volatile SingularAttribute<Korisnik, Date> lastModifiedDate;
    public static volatile SingularAttribute<Korisnik, String> lastModifiedBy;
    public static volatile SingularAttribute<Korisnik, Integer> idKorisnika;
    public static volatile CollectionAttribute<Korisnik, Poslodavac> poslodavacCollection;
    public static volatile SingularAttribute<Korisnik, String> godine;
    public static volatile CollectionAttribute<Korisnik, Radnik> radnikCollection;

}