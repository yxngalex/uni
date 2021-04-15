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
@Table(name = "poslovi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Poslovi.findAll", query = "SELECT p FROM Poslovi p")
    , @NamedQuery(name = "Poslovi.findByIdPosla", query = "SELECT p FROM Poslovi p WHERE p.idPosla = :idPosla")
    , @NamedQuery(name = "Poslovi.findByNaziv", query = "SELECT p FROM Poslovi p WHERE p.naziv = :naziv")
    , @NamedQuery(name = "Poslovi.findByOpis", query = "SELECT p FROM Poslovi p WHERE p.opis = :opis")
    , @NamedQuery(name = "Poslovi.findByMaksBudzet", query = "SELECT p FROM Poslovi p WHERE p.maksBudzet = :maksBudzet")
    , @NamedQuery(name = "Poslovi.findByDuzinaTrajanja", query = "SELECT p FROM Poslovi p WHERE p.duzinaTrajanja = :duzinaTrajanja")
    , @NamedQuery(name = "Poslovi.findByBrojPotrebnihRadnika", query = "SELECT p FROM Poslovi p WHERE p.brojPotrebnihRadnika = :brojPotrebnihRadnika")
    , @NamedQuery(name = "Poslovi.findByKljucnaRec", query = "SELECT p FROM Poslovi p WHERE p.kljucnaRec = :kljucnaRec")
    , @NamedQuery(name = "Poslovi.findByCreatedDate", query = "SELECT p FROM Poslovi p WHERE p.createdDate = :createdDate")
    , @NamedQuery(name = "Poslovi.findByLastModifiedDate", query = "SELECT p FROM Poslovi p WHERE p.lastModifiedDate = :lastModifiedDate")
    , @NamedQuery(name = "Poslovi.findByLastModifiedBy", query = "SELECT p FROM Poslovi p WHERE p.lastModifiedBy = :lastModifiedBy")
    , @NamedQuery(name = "Poslovi.findByRecordStatus", query = "SELECT p FROM Poslovi p WHERE p.recordStatus = :recordStatus")})
public class Poslovi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_POSLA")
    private Integer idPosla;
    @Size(max = 16)
    @Column(name = "NAZIV")
    private String naziv;
    @Size(max = 255)
    @Column(name = "OPIS")
    private String opis;
    @Column(name = "MAKS_BUDZET")
    private Long maksBudzet;
    @Column(name = "DUZINA_TRAJANJA")
    private Integer duzinaTrajanja;
    @Column(name = "BROJ_POTREBNIH_RADNIKA")
    private Integer brojPotrebnihRadnika;
    @Size(max = 16)
    @Column(name = "KLJUCNA_REC")
    private String kljucnaRec;
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
    @JoinColumn(name = "ID_POSLODAVCA", referencedColumnName = "ID_POSLODAVCA")
    @ManyToOne(optional = false)
    private Poslodavac idPoslodavca;
    @OneToMany(mappedBy = "idPosla")
    private Collection<Radnik> radnikCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPosla")
    private Collection<Ponuda> ponudaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPosla")
    private Collection<Ocena> ocenaCollection;

    public Poslovi() {
    }

    public Poslovi(Integer idPosla) {
        this.idPosla = idPosla;
    }

    public Poslovi(Integer idPosla, Date createdDate, Date lastModifiedDate) {
        this.idPosla = idPosla;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public Integer getIdPosla() {
        return idPosla;
    }

    public void setIdPosla(Integer idPosla) {
        this.idPosla = idPosla;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Long getMaksBudzet() {
        return maksBudzet;
    }

    public void setMaksBudzet(Long maksBudzet) {
        this.maksBudzet = maksBudzet;
    }

    public Integer getDuzinaTrajanja() {
        return duzinaTrajanja;
    }

    public void setDuzinaTrajanja(Integer duzinaTrajanja) {
        this.duzinaTrajanja = duzinaTrajanja;
    }

    public Integer getBrojPotrebnihRadnika() {
        return brojPotrebnihRadnika;
    }

    public void setBrojPotrebnihRadnika(Integer brojPotrebnihRadnika) {
        this.brojPotrebnihRadnika = brojPotrebnihRadnika;
    }

    public String getKljucnaRec() {
        return kljucnaRec;
    }

    public void setKljucnaRec(String kljucnaRec) {
        this.kljucnaRec = kljucnaRec;
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

    public Poslodavac getIdPoslodavca() {
        return idPoslodavca;
    }

    public void setIdPoslodavca(Poslodavac idPoslodavca) {
        this.idPoslodavca = idPoslodavca;
    }

    @XmlTransient
    public Collection<Radnik> getRadnikCollection() {
        return radnikCollection;
    }

    public void setRadnikCollection(Collection<Radnik> radnikCollection) {
        this.radnikCollection = radnikCollection;
    }

    @XmlTransient
    public Collection<Ponuda> getPonudaCollection() {
        return ponudaCollection;
    }

    public void setPonudaCollection(Collection<Ponuda> ponudaCollection) {
        this.ponudaCollection = ponudaCollection;
    }

    @XmlTransient
    public Collection<Ocena> getOcenaCollection() {
        return ocenaCollection;
    }

    public void setOcenaCollection(Collection<Ocena> ocenaCollection) {
        this.ocenaCollection = ocenaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPosla != null ? idPosla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poslovi)) {
            return false;
        }
        Poslovi other = (Poslovi) object;
        if ((this.idPosla == null && other.idPosla != null) || (this.idPosla != null && !this.idPosla.equals(other.idPosla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Poslovi[ idPosla=" + idPosla + " ]";
    }
    
}
