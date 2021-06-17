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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "poruka")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Poruka.findAll", query = "SELECT p FROM Poruka p")
    , @NamedQuery(name = "Poruka.findByIdPoruke", query = "SELECT p FROM Poruka p WHERE p.idPoruke = :idPoruke")
    , @NamedQuery(name = "Poruka.findByCreatedDate", query = "SELECT p FROM Poruka p WHERE p.createdDate = :createdDate")
    , @NamedQuery(name = "Poruka.findByLastModifiedDate", query = "SELECT p FROM Poruka p WHERE p.lastModifiedDate = :lastModifiedDate")
    , @NamedQuery(name = "Poruka.findByLastModifiedBy", query = "SELECT p FROM Poruka p WHERE p.lastModifiedBy = :lastModifiedBy")
    , @NamedQuery(name = "Poruka.findByRecordStatus", query = "SELECT p FROM Poruka p WHERE p.recordStatus = :recordStatus")})
public class Poruka implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PORUKE")
    private Integer idPoruke;
    @Lob
    @Size(max = 65535)
    @Column(name = "PORUKA")
    private String poruka;
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
    @OneToMany(mappedBy = "idPoruke")
    private Collection<Radnik> radnikCollection;
    @OneToMany(mappedBy = "idPoruke")
    private Collection<Poslodavac> poslodavacCollection;

    public Poruka() {
    }

    public Poruka(Integer idPoruke) {
        this.idPoruke = idPoruke;
    }

    public Poruka(Integer idPoruke, Date createdDate, Date lastModifiedDate) {
        this.idPoruke = idPoruke;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public Integer getIdPoruke() {
        return idPoruke;
    }

    public void setIdPoruke(Integer idPoruke) {
        this.idPoruke = idPoruke;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
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
        hash += (idPoruke != null ? idPoruke.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poruka)) {
            return false;
        }
        Poruka other = (Poruka) object;
        if ((this.idPoruke == null && other.idPoruke != null) || (this.idPoruke != null && !this.idPoruke.equals(other.idPoruke))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Poruka[ idPoruke=" + idPoruke + " ]";
    }
    
}
