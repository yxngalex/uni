package rs.ac.metropolitan.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ocena")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ocena.findAll", query = "SELECT o FROM Ocena o")
    , @NamedQuery(name = "Ocena.findByIdOcene", query = "SELECT o FROM Ocena o WHERE o.idOcene = :idOcene")
    , @NamedQuery(name = "Ocena.findByOcena", query = "SELECT o FROM Ocena o WHERE o.ocena = :ocena")
    , @NamedQuery(name = "Ocena.findByCreatedDate", query = "SELECT o FROM Ocena o WHERE o.createdDate = :createdDate")
    , @NamedQuery(name = "Ocena.findByLastModifiedDate", query = "SELECT o FROM Ocena o WHERE o.lastModifiedDate = :lastModifiedDate")
    , @NamedQuery(name = "Ocena.findByLastModifiedBy", query = "SELECT o FROM Ocena o WHERE o.lastModifiedBy = :lastModifiedBy")
    , @NamedQuery(name = "Ocena.findByRecordStatus", query = "SELECT o FROM Ocena o WHERE o.recordStatus = :recordStatus")})
public class Ocena implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_OCENE")
    private Integer idOcene;
    @Column(name = "OCENA")
    private Integer ocena;
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
    @ManyToOne(optional = false)
    private Poslovi idPosla;
    @JoinColumn(name = "ID_RADNIKA", referencedColumnName = "ID_RADNIKA")
    @ManyToOne(optional = false)
    private Radnik idRadnika;

    public Ocena() {
    }

    public Ocena(Integer idOcene) {
        this.idOcene = idOcene;
    }

    public Ocena(Integer idOcene, Date createdDate, Date lastModifiedDate) {
        this.idOcene = idOcene;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public Integer getIdOcene() {
        return idOcene;
    }

    public void setIdOcene(Integer idOcene) {
        this.idOcene = idOcene;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
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

    public Radnik getIdRadnika() {
        return idRadnika;
    }

    public void setIdRadnika(Radnik idRadnika) {
        this.idRadnika = idRadnika;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOcene != null ? idOcene.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ocena)) {
            return false;
        }
        Ocena other = (Ocena) object;
        if ((this.idOcene == null && other.idOcene != null) || (this.idOcene != null && !this.idOcene.equals(other.idOcene))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.metropolitan.entity.Ocena[ idOcene=" + idOcene + " ]";
    }
    
}
