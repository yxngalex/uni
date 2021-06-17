package rs.ac.metropolitan.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "radnik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Radnik.findAll", query = "SELECT r FROM Radnik r")
    , @NamedQuery(name = "Radnik.findByIdRadnika", query = "SELECT r FROM Radnik r WHERE r.idRadnika = :idRadnika")
    , @NamedQuery(name = "Radnik.findByCreatedDate", query = "SELECT r FROM Radnik r WHERE r.createdDate = :createdDate")
    , @NamedQuery(name = "Radnik.findByLastModifiedDate", query = "SELECT r FROM Radnik r WHERE r.lastModifiedDate = :lastModifiedDate")
    , @NamedQuery(name = "Radnik.findByLastModifiedBy", query = "SELECT r FROM Radnik r WHERE r.lastModifiedBy = :lastModifiedBy")
    , @NamedQuery(name = "Radnik.findByRecordStatus", query = "SELECT r FROM Radnik r WHERE r.recordStatus = :recordStatus")})
public class Radnik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_RADNIKA")
    private Integer idRadnika;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Size(max = 64)
    @Column(name = "last_modified_by")
    private String lastModifiedBy;
    @Column(name = "record_status")
    private Integer recordStatus;
    @JoinColumn(name = "ID_POSLA", referencedColumnName = "ID_POSLA")
    @ManyToOne
    private Poslovi idPosla;
    @JoinColumn(name = "ID_PONUDE", referencedColumnName = "ID_PONUDE")
    @ManyToOne(optional = false)
    private Ponuda idPonude;
    @JoinColumn(name = "ID_PORUKE", referencedColumnName = "ID_PORUKE")
    @ManyToOne
    private Poruka idPoruke;
    @JoinColumn(name = "ID_KORISNIKA", referencedColumnName = "ID_KORISNIKA")
    @ManyToOne(optional = false)
    private Korisnik idKorisnika;
    @OneToMany(mappedBy = "radIdRadnika")
    private Collection<Radnik> radnikCollection;
    @JoinColumn(name = "RAD_ID_RADNIKA", referencedColumnName = "ID_RADNIKA")
    @ManyToOne
    private Radnik radIdRadnika;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRadnika")
    private Collection<Zarada> zaradaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRadnika")
    private Collection<Ocena> ocenaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRadnika")
    private Collection<Fajlovi> fajloviCollection;

    public Radnik() {
    }

    public Radnik(Integer idRadnika) {
        this.idRadnika = idRadnika;
    }

    public Radnik(Integer idRadnika, Date createdDate, Date lastModifiedDate) {
        this.idRadnika = idRadnika;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public Integer getIdRadnika() {
        return idRadnika;
    }

    public void setIdRadnika(Integer idRadnika) {
        this.idRadnika = idRadnika;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Integer getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Integer recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Poslovi getIdPosla() {
        return idPosla;
    }

    public void setIdPosla(Poslovi idPosla) {
        this.idPosla = idPosla;
    }

    public Ponuda getIdPonude() {
        return idPonude;
    }

    public void setIdPonude(Ponuda idPonude) {
        this.idPonude = idPonude;
    }

    public Poruka getIdPoruke() {
        return idPoruke;
    }

    public void setIdPoruke(Poruka idPoruke) {
        this.idPoruke = idPoruke;
    }

    public Korisnik getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(Korisnik idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    @XmlTransient
    public Collection<Radnik> getRadnikCollection() {
        return radnikCollection;
    }

    public void setRadnikCollection(Collection<Radnik> radnikCollection) {
        this.radnikCollection = radnikCollection;
    }

    public Radnik getRadIdRadnika() {
        return radIdRadnika;
    }

    public void setRadIdRadnika(Radnik radIdRadnika) {
        this.radIdRadnika = radIdRadnika;
    }

    @XmlTransient
    public Collection<Zarada> getZaradaCollection() {
        return zaradaCollection;
    }

    public void setZaradaCollection(Collection<Zarada> zaradaCollection) {
        this.zaradaCollection = zaradaCollection;
    }

    @XmlTransient
    public Collection<Ocena> getOcenaCollection() {
        return ocenaCollection;
    }

    public void setOcenaCollection(Collection<Ocena> ocenaCollection) {
        this.ocenaCollection = ocenaCollection;
    }

    @XmlTransient
    public Collection<Fajlovi> getFajloviCollection() {
        return fajloviCollection;
    }

    public void setFajloviCollection(Collection<Fajlovi> fajloviCollection) {
        this.fajloviCollection = fajloviCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRadnika != null ? idRadnika.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Radnik)) {
            return false;
        }
        Radnik other = (Radnik) object;
        if ((this.idRadnika == null && other.idRadnika != null) || (this.idRadnika != null && !this.idRadnika.equals(other.idRadnika))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.metropolitan.entity.Radnik[ idRadnika=" + idRadnika + " ]";
    }
    
}
