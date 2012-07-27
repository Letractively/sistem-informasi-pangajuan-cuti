/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Smart
 */
@Entity
@Table(name = "karyawan")
@NamedQueries({
    @NamedQuery(name = "Karyawan.findAll", query = "SELECT k FROM Karyawan k"),
    @NamedQuery(name = "Karyawan.findById", query = "SELECT k FROM Karyawan k WHERE k.id = :id"),
    @NamedQuery(name = "Karyawan.findByJenkel", query = "SELECT k FROM Karyawan k WHERE k.jenkel = :jenkel"),
    @NamedQuery(name = "Karyawan.findByNamakaryawan", query = "SELECT k FROM Karyawan k WHERE k.namakaryawan = :namakaryawan"),
    @NamedQuery(name = "Karyawan.findBySisacuti", query = "SELECT k FROM Karyawan k WHERE k.sisacuti = :sisacuti"),
    @NamedQuery(name = "Karyawan.findByAlamat", query = "SELECT k FROM Karyawan k WHERE k.alamat = :alamat")})
public class Karyawan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "JENKEL")
    private String jenkel;
    @Column(name = "NAMAKARYAWAN")
    private String namakaryawan;
    @Column(name = "SISACUTI")
    private String sisacuti;
    @Column(name = "ALAMAT")
    private String alamat;
    @OneToMany(mappedBy = "idKaryawan", fetch = FetchType.LAZY)
    private List<Historycuti> historycutiList;
    @OneToMany(mappedBy = "idKaryawan", fetch = FetchType.LAZY)
    private List<Loginkaryawan> loginkaryawanList;

    public Karyawan() {
    }

    public Karyawan(Long id) {
        this.id = id;
    }

    public Karyawan(int i) {
        Long tempid=Long.parseLong("1");
        this.id=tempid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJenkel() {
        return jenkel;
    }

    public void setJenkel(String jenkel) {
        this.jenkel = jenkel;
    }

    public String getNamakaryawan() {
        return namakaryawan;
    }

    public void setNamakaryawan(String namakaryawan) {
        this.namakaryawan = namakaryawan;
    }

    public String getSisacuti() {
        return sisacuti;
    }

    public void setSisacuti(String sisacuti) {
        this.sisacuti = sisacuti;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public List<Historycuti> getHistorycutiList() {
        return historycutiList;
    }

    public void setHistorycutiList(List<Historycuti> historycutiList) {
        this.historycutiList = historycutiList;
    }

    public List<Loginkaryawan> getLoginkaryawanList() {
        return loginkaryawanList;
    }

    public void setLoginkaryawanList(List<Loginkaryawan> loginkaryawanList) {
        this.loginkaryawanList = loginkaryawanList;
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
        if (!(object instanceof Karyawan)) {
            return false;
        }
        Karyawan other = (Karyawan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Karyawan[id=" + id + "]";
    }

}
