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
import javax.persistence.Lob;
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
@Table(name = "fajlovi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fajlovi.findAll", query = "SELECT f FROM Fajlovi f")
    , @NamedQuery(name = "Fajlovi.findByIdFajla", query = "SELECT f FROM Fajlovi f WHERE f.idFajla = :idFajla")
    , @NamedQuery(name = "Fajlovi.findByCreatedDate", query = "SELECT f FROM Fajlovi f WHERE f.createdDate = :createdDate")
    , @NamedQuery(name = "Fajlovi.findByLastModifiedDate", query = "SELECT f FROM Fajlovi f WHERE f.lastModifiedDate = :lastModifiedDate")
    , @NamedQuery(name = "Fajlovi.findByLastModifiedBy", query = "SELECT f FROM Fajlovi f WHERE f.lastModifiedBy = :lastModifiedBy")
    , @NamedQuery(name = "Fajlovi.findByRecordStatus", query = "SELECT f FROM Fajlovi f WHERE f.recordStatus = :recordStatus")})
public class Fajlovi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_FAJLA")
    private Integer idFajla;
    @Lob
    @Size(max = 65535)
    @Column(name = "TIP_FAJLA")
    private String tipFajla;
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
    @JoinColumn(name = "ID_RADNIKA", referencedColumnName = "ID_RADNIKA")
    @ManyToOne(optional = false)
    private Radnik idRadnika;

    public Fajlovi() {
    }

    public Fajlovi(Integer idFajla) {
        this.idFajla = idFajla;
    }

    public Fajlovi(Integer idFajla, Date createdDate, Date lastModifiedDate) {
        this.idFajla = idFajla;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public Integer getIdFajla() {
        return idFajla;
    }

    public void setIdFajla(Integer idFajla) {
        this.idFajla = idFajla;
    }

    public String getTipFajla() {
        return tipFajla;
    }

    public void setTipFajla(String tipFajla) {
        this.tipFajla = tipFajla;
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

    public Radnik getIdRadnika() {
        return idRadnika;
    }

    public void setIdRadnika(Radnik idRadnika) {
        this.idRadnika = idRadnika;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFajla != null ? idFajla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fajlovi)) {
            return false;
        }
        Fajlovi other = (Fajlovi) object;
        if ((this.idFajla == null && other.idFajla != null) || (this.idFajla != null && !this.idFajla.equals(other.idFajla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.metropolitan.entity.Fajlovi[ idFajla=" + idFajla + " ]";
    }
    
}
