/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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

/**
 *
 * @author aleks
 */
@Entity
@Table(name = "zarada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zarada.findAll", query = "SELECT z FROM Zarada z")
    , @NamedQuery(name = "Zarada.findByIdZarade", query = "SELECT z FROM Zarada z WHERE z.idZarade = :idZarade")
    , @NamedQuery(name = "Zarada.findByVrednost", query = "SELECT z FROM Zarada z WHERE z.vrednost = :vrednost")
    , @NamedQuery(name = "Zarada.findByMesec", query = "SELECT z FROM Zarada z WHERE z.mesec = :mesec")
    , @NamedQuery(name = "Zarada.findByCreatedDate", query = "SELECT z FROM Zarada z WHERE z.createdDate = :createdDate")
    , @NamedQuery(name = "Zarada.findByLastModifiedDate", query = "SELECT z FROM Zarada z WHERE z.lastModifiedDate = :lastModifiedDate")
    , @NamedQuery(name = "Zarada.findByLastModifiedBy", query = "SELECT z FROM Zarada z WHERE z.lastModifiedBy = :lastModifiedBy")
    , @NamedQuery(name = "Zarada.findByRecordStatus", query = "SELECT z FROM Zarada z WHERE z.recordStatus = :recordStatus")})
public class Zarada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ZARADE")
    private Integer idZarade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VREDNOST")
    private long vrednost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MESEC")
    private int mesec;
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

    public Zarada() {
    }

    public Zarada(Integer idZarade) {
        this.idZarade = idZarade;
    }

    public Zarada(Integer idZarade, long vrednost, int mesec, Date createdDate, Date lastModifiedDate) {
        this.idZarade = idZarade;
        this.vrednost = vrednost;
        this.mesec = mesec;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public Integer getIdZarade() {
        return idZarade;
    }

    public void setIdZarade(Integer idZarade) {
        this.idZarade = idZarade;
    }

    public long getVrednost() {
        return vrednost;
    }

    public void setVrednost(long vrednost) {
        this.vrednost = vrednost;
    }

    public int getMesec() {
        return mesec;
    }

    public void setMesec(int mesec) {
        this.mesec = mesec;
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
        hash += (idZarade != null ? idZarade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zarada)) {
            return false;
        }
        Zarada other = (Zarada) object;
        if ((this.idZarade == null && other.idZarade != null) || (this.idZarade != null && !this.idZarade.equals(other.idZarade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Zarada[ idZarade=" + idZarade + " ]";
    }
    
}
