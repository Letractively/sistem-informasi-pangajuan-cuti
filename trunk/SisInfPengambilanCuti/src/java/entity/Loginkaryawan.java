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
@Table(name = "loginkaryawan")
@NamedQueries({
    @NamedQuery(name = "Loginkaryawan.findAll", query = "SELECT l FROM Loginkaryawan l"),
    @NamedQuery(name = "Loginkaryawan.findById", query = "SELECT l FROM Loginkaryawan l WHERE l.id = :id"),
    @NamedQuery(name = "Loginkaryawan.findByUsername", query = "SELECT l FROM Loginkaryawan l WHERE l.username = :username"),
    @NamedQuery(name = "Loginkaryawan.findByPassword", query = "SELECT l FROM Loginkaryawan l WHERE l.password = :password")})
public class Loginkaryawan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @JoinColumn(name = "id_karyawan", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    private Karyawan idKaryawan;

    public Loginkaryawan() {
    }

    public Loginkaryawan(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        if (!(object instanceof Loginkaryawan)) {
            return false;
        }
        Loginkaryawan other = (Loginkaryawan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Loginkaryawan[id=" + id + "]";
    }

}
