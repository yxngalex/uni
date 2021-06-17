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
import javax.persistence.Lob;
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
@Table(name = "ponuda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ponuda.findAll", query = "SELECT p FROM Ponuda p")
    , @NamedQuery(name = "Ponuda.findByIdPonude", query = "SELECT p FROM Ponuda p WHERE p.idPonude = :idPonude")
    , @NamedQuery(name = "Ponuda.findByPredlozenacena", query = "SELECT p FROM Ponuda p WHERE p.predlozenacena = :predlozenacena")
    , @NamedQuery(name = "Ponuda.findByCreatedDate", query = "SELECT p FROM Ponuda p WHERE p.createdDate = :createdDate")
    , @NamedQuery(name = "Ponuda.findByLastModifiedDate", query = "SELECT p FROM Ponuda p WHERE p.lastModifiedDate = :lastModifiedDate")
    , @NamedQuery(name = "Ponuda.findByLastModifiedBy", query = "SELECT p FROM Ponuda p WHERE p.lastModifiedBy = :lastModifiedBy")
    , @NamedQuery(name = "Ponuda.findByRecordStatus", query = "SELECT p FROM Ponuda p WHERE p.recordStatus = :recordStatus")})
public class Ponuda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Lob
    @Size(max = 65535)
    @Column(name = "KRATAKOPIS")
    private String kratakopis;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PONUDE")
    private Integer idPonude;
    @Column(name = "PREDLOZENACENA")
    private Long predlozenacena;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPonude")
    private Collection<Radnik> radnikCollection;
    @JoinColumn(name = "ID_POSLA", referencedColumnName = "ID_POSLA")
    @ManyToOne(optional = false)
    private Poslovi idPosla;

    public Ponuda() {
    }

    public Ponuda(Integer idPonude) {
        this.idPonude = idPonude;
    }

    public Ponuda(Integer idPonude, Date createdDate, Date lastModifiedDate) {
        this.idPonude = idPonude;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getKratakopis() {
        return kratakopis;
    }

    public void setKratakopis(String kratakopis) {
        this.kratakopis = kratakopis;
    }

    public Integer getIdPonude() {
        return idPonude;
    }

    public void setIdPonude(Integer idPonude) {
        this.idPonude = idPonude;
    }

    public Long getPredlozenacena() {
        return predlozenacena;
    }

    public void setPredlozenacena(Long predlozenacena) {
        this.predlozenacena = predlozenacena;
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

    public Poslovi getIdPosla() {
        return idPosla;
    }

    public void setIdPosla(Poslovi idPosla) {
        this.idPosla = idPosla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPonude != null ? idPonude.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ponuda)) {
            return false;
        }
        Ponuda other = (Ponuda) object;
        if ((this.idPonude == null && other.idPonude != null) || (this.idPonude != null && !this.idPonude.equals(other.idPonude))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ponuda[ idPonude=" + idPonude + " ]";
    }
    
}
