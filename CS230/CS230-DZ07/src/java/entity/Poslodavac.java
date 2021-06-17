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

/**
 *
 * @author aleks
 */
@Entity
@Table(name = "poslodavac")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Poslodavac.findAll", query = "SELECT p FROM Poslodavac p")
    , @NamedQuery(name = "Poslodavac.findByIdPoslodavca", query = "SELECT p FROM Poslodavac p WHERE p.idPoslodavca = :idPoslodavca")
    , @NamedQuery(name = "Poslodavac.findByCreatedDate", query = "SELECT p FROM Poslodavac p WHERE p.createdDate = :createdDate")
    , @NamedQuery(name = "Poslodavac.findByLastModifiedDate", query = "SELECT p FROM Poslodavac p WHERE p.lastModifiedDate = :lastModifiedDate")
    , @NamedQuery(name = "Poslodavac.findByLastModifiedBy", query = "SELECT p FROM Poslodavac p WHERE p.lastModifiedBy = :lastModifiedBy")
    , @NamedQuery(name = "Poslodavac.findByRecordStatus", query = "SELECT p FROM Poslodavac p WHERE p.recordStatus = :recordStatus")})
public class Poslodavac implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_POSLODAVCA")
    private Integer idPoslodavca;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPoslodavca")
    private Collection<Poslovi> posloviCollection;
    @JoinColumn(name = "ID_KORISNIKA", referencedColumnName = "ID_KORISNIKA")
    @ManyToOne(optional = false)
    private Korisnik idKorisnika;
    @JoinColumn(name = "ID_PORUKE", referencedColumnName = "ID_PORUKE")
    @ManyToOne
    private Poruka idPoruke;

    public Poslodavac() {
    }

    public Poslodavac(Integer idPoslodavca) {
        this.idPoslodavca = idPoslodavca;
    }

    public Poslodavac(Integer idPoslodavca, Date createdDate, Date lastModifiedDate) {
        this.idPoslodavca = idPoslodavca;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public Integer getIdPoslodavca() {
        return idPoslodavca;
    }

    public void setIdPoslodavca(Integer idPoslodavca) {
        this.idPoslodavca = idPoslodavca;
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
    public Collection<Poslovi> getPosloviCollection() {
        return posloviCollection;
    }

    public void setPosloviCollection(Collection<Poslovi> posloviCollection) {
        this.posloviCollection = posloviCollection;
    }

    public Korisnik getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(Korisnik idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public Poruka getIdPoruke() {
        return idPoruke;
    }

    public void setIdPoruke(Poruka idPoruke) {
        this.idPoruke = idPoruke;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPoslodavca != null ? idPoslodavca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poslodavac)) {
            return false;
        }
        Poslodavac other = (Poslodavac) object;
        if ((this.idPoslodavca == null && other.idPoslodavca != null) || (this.idPoslodavca != null && !this.idPoslodavca.equals(other.idPoslodavca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Poslodavac[ idPoslodavca=" + idPoslodavca + " ]";
    }
    
}
