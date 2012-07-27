/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Smart
 */
@Entity
@Table(name = "tbladmin")
@NamedQueries({
    @NamedQuery(name = "Tbladmin.findAll", query = "SELECT t FROM Tbladmin t"),
    @NamedQuery(name = "Tbladmin.findById", query = "SELECT t FROM Tbladmin t WHERE t.id = :id"),
    @NamedQuery(name = "Tbladmin.findByUsername", query = "SELECT t FROM Tbladmin t WHERE t.username = :username"),
    @NamedQuery(name = "Tbladmin.findByPassword", query = "SELECT t FROM Tbladmin t WHERE t.password = :password")})
public class Tbladmin implements Serializable {
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

    public Tbladmin() {
    }

    public Tbladmin(Long id) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbladmin)) {
            return false;
        }
        Tbladmin other = (Tbladmin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tbladmin[id=" + id + "]";
    }

}
