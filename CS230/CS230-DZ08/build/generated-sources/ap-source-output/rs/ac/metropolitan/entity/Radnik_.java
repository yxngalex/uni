package rs.ac.metropolitan.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import rs.ac.metropolitan.entity.Fajlovi;
import rs.ac.metropolitan.entity.Korisnik;
import rs.ac.metropolitan.entity.Ocena;
import rs.ac.metropolitan.entity.Ponuda;
import rs.ac.metropolitan.entity.Poruka;
import rs.ac.metropolitan.entity.Poslovi;
import rs.ac.metropolitan.entity.Radnik;
import rs.ac.metropolitan.entity.Zarada;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-08T16:20:58")
@StaticMetamodel(Radnik.class)
public class Radnik_ { 

    public static volatile SingularAttribute<Radnik, Poslovi> idPosla;
    public static volatile SingularAttribute<Radnik, Date> lastModifiedDate;
    public static volatile CollectionAttribute<Radnik, Fajlovi> fajloviCollection;
    public static volatile SingularAttribute<Radnik, String> lastModifiedBy;
    public static volatile SingularAttribute<Radnik, Korisnik> idKorisnika;
    public static volatile SingularAttribute<Radnik, Integer> idRadnika;
    public static volatile SingularAttribute<Radnik, Radnik> radIdRadnika;
    public static volatile SingularAttribute<Radnik, Date> createdDate;
    public static volatile SingularAttribute<Radnik, Integer> recordStatus;
    public static volatile CollectionAttribute<Radnik, Zarada> zaradaCollection;
    public static volatile SingularAttribute<Radnik, Poruka> idPoruke;
    public static volatile CollectionAttribute<Radnik, Radnik> radnikCollection;
    public static volatile SingularAttribute<Radnik, Ponuda> idPonude;
    public static volatile CollectionAttribute<Radnik, Ocena> ocenaCollection;

}