/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Smart
 */
@Entity
@Table(name = "historycuti")
@NamedQueries({
    @NamedQuery(name = "Historycuti.findAll", query = "SELECT h FROM Historycuti h"),
    @NamedQuery(name = "Historycuti.findById", query = "SELECT h FROM Historycuti h WHERE h.id = :id"),
    @NamedQuery(name = "Historycuti.findByTglawalcuti", query = "SELECT h FROM Historycuti h WHERE h.tglawalcuti = :tglawalcuti"),
    @NamedQuery(name = "Historycuti.findByStatus", query = "SELECT h FROM Historycuti h WHERE h.status = :status"),
    @NamedQuery(name = "Historycuti.findByTglakhircuti", query = "SELECT h FROM Historycuti h WHERE h.tglakhircuti = :tglakhircuti"),
    @NamedQuery(name = "Historycuti.findByAlasan", query = "SELECT h FROM Historycuti h WHERE h.alasan = :alasan")})
public class Historycuti implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TGLAWALCUTI")
    private String tglawalcuti;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "TGLAKHIRCUTI")
    private String tglakhircuti;
    @Column(name = "ALASAN")
    private String alasan;
    @JoinColumn(name = "id_karyawan", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    private Karyawan idKaryawan;

    public Historycuti() {
    }

    public Historycuti(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTglawalcuti() {
        return tglawalcuti;
    }

    public void setTglawalcuti(String tglawalcuti) {
        this.tglawalcuti = tglawalcuti;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTglakhircuti() {
        return tglakhircuti;
    }

    public void setTglakhircuti(String tglakhircuti) {
        this.tglakhircuti = tglakhircuti;
    }

    public String getAlasan() {
        return alasan;
    }

    public void setAlasan(String alasan) {
        this.alasan = alasan;
    }

    public Karyawan getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(Karyawan idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historycuti)) {
            return false;
        }
        Historycuti other = (Historycuti) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Historycuti[id=" + id + "]";
    }

}
