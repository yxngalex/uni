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
@Table(name = "administrator")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrator.findAll", query = "SELECT a FROM Administrator a")
    , @NamedQuery(name = "Administrator.findByIdAdministartora", query = "SELECT a FROM Administrator a WHERE a.idAdministartora = :idAdministartora")
    , @NamedQuery(name = "Administrator.findByCreatedDate", query = "SELECT a FROM Administrator a WHERE a.createdDate = :createdDate")
    , @NamedQuery(name = "Administrator.findByLastModifiedDate", query = "SELECT a FROM Administrator a WHERE a.lastModifiedDate = :lastModifiedDate")
    , @NamedQuery(name = "Administrator.findByLastModifiedBy", query = "SELECT a FROM Administrator a WHERE a.lastModifiedBy = :lastModifiedBy")
    , @NamedQuery(name = "Administrator.findByRecordStatus", query = "SELECT a FROM Administrator a WHERE a.recordStatus = :recordStatus")})
public class Administrator implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ADMINISTARTORA")
    private Integer idAdministartora;
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
    @JoinColumn(name = "ID_KORISNIKA", referencedColumnName = "ID_KORISNIKA")
    @ManyToOne(optional = false)
    private Korisnik idKorisnika;

    public Administrator() {
    }

    public Administrator(Integer idAdministartora) {
        this.idAdministartora = idAdministartora;
    }

    public Administrator(Integer idAdministartora, Date createdDate, Date lastModifiedDate) {
        this.idAdministartora = idAdministartora;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public Integer getIdAdministartora() {
        return idAdministartora;
    }

    public void setIdAdministartora(Integer idAdministartora) {
        this.idAdministartora = idAdministartora;
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

    public Korisnik getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(Korisnik idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdministartora != null ? idAdministartora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrator)) {
            return false;
        }
        Administrator other = (Administrator) object;
        if ((this.idAdministartora == null && other.idAdministartora != null) || (this.idAdministartora != null && !this.idAdministartora.equals(other.idAdministartora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.metropolitan.entity.Administrator[ idAdministartora=" + idAdministartora + " ]";
    }
    
}
