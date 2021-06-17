package rs.ac.metropolitan.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import rs.ac.metropolitan.entity.Korisnik;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-08T16:20:58")
@StaticMetamodel(Administrator.class)
public class Administrator_ { 

    public static volatile SingularAttribute<Administrator, Date> createdDate;
    public static volatile SingularAttribute<Administrator, Integer> recordStatus;
    public static volatile SingularAttribute<Administrator, Date> lastModifiedDate;
    public static volatile SingularAttribute<Administrator, Integer> idAdministartora;
    public static volatile SingularAttribute<Administrator, String> lastModifiedBy;
    public static volatile SingularAttribute<Administrator, Korisnik> idKorisnika;

}