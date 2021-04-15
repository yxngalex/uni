/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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

/**
 *
 * @author aleks
 */
@Entity
@Table(name = "korisnik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Korisnik.findAll", query = "SELECT k FROM Korisnik k")
    , @NamedQuery(name = "Korisnik.findByIdKorisnika", query = "SELECT k FROM Korisnik k WHERE k.idKorisnika = :idKorisnika")
    , @NamedQuery(name = "Korisnik.findByIme", query = "SELECT k FROM Korisnik k WHERE k.ime = :ime")
    , @NamedQuery(name = "Korisnik.findByPrezime", query = "SELECT k FROM Korisnik k WHERE k.prezime = :prezime")
    , @NamedQuery(name = "Korisnik.findByGodine", query = "SELECT k FROM Korisnik k WHERE k.godine = :godine")
    , @NamedQuery(name = "Korisnik.findByCreatedDate", query = "SELECT k FROM Korisnik k WHERE k.createdDate = :createdDate")
    , @NamedQuery(name = "Korisnik.findByLastModifiedDate", query = "SELECT k FROM Korisnik k WHERE k.lastModifiedDate = :lastModifiedDate")
    , @NamedQuery(name = "Korisnik.findByLastModifiedBy", query = "SELECT k FROM Korisnik k WHERE k.lastModifiedBy = :lastModifiedBy")
    , @NamedQuery(name = "Korisnik.findByRecordStatus", query = "SELECT k FROM Korisnik k WHERE k.recordStatus = :recordStatus")})
public class Korisnik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_KORISNIKA")
    private Integer idKorisnika;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "ime")
    private String ime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "prezime")
    private String prezime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "godine")
    private String godine;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idKorisnika")
    private Collection<Administrator> administratorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idKorisnika")
    private Collection<Radnik> radnikCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idKorisnika")
    private Collection<Poslodavac> poslodavacCollection;

    public Korisnik() {
    }

    public Korisnik(Integer idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public Korisnik(Integer idKorisnika, String ime, String prezime, String godine, Date createdDate, Date lastModifiedDate) {
        this.idKorisnika = idKorisnika;
        this.ime = ime;
        this.prezime = prezime;
        this.godine = godine;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public Integer getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(Integer idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getGodine() {
        return godine;
    }

    public void setGodine(String godine) {
        this.godine = godine;
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

    @XmlTransient
    public Collection<Administrator> getAdministratorCollection() {
        return administratorCollection;
    }

    public void setAdministratorCollection(Collection<Administrator> administratorCollection) {
        this.administratorCollection = administratorCollection;
    }

    @XmlTransient
    public Collection<Radnik> getRadnikCollection() {
        return radnikCollection;
    }

    public void setRadnikCollection(Collection<Radnik> radnikCollection) {
        this.radnikCollection = radnikCollection;
    }

    @XmlTransient
    public Collection<Poslodavac> getPoslodavacCollection() {
        return poslodavacCollection;
    }

    public void setPoslodavacCollection(Collection<Poslodavac> poslodavacCollection) {
        this.poslodavacCollection = poslodavacCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKorisnika != null ? idKorisnika.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Korisnik)) {
            return false;
        }
        Korisnik other = (Korisnik) object;
        if ((this.idKorisnika == null && other.idKorisnika != null) || (this.idKorisnika != null && !this.idKorisnika.equals(other.idKorisnika))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Korisnik[ idKorisnika=" + idKorisnika + " ]";
    }
    
}
