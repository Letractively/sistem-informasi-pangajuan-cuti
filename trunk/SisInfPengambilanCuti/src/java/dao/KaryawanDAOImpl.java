/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Karyawan;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Smart
 */
public class KaryawanDAOImpl extends GeneralDAOImpl implements KaryawanDAO {

    public KaryawanDAOImpl(EntityManager em) {
        super(em);
    }

    public List<Karyawan> gets() throws Exception {
        List<Karyawan> list = new ArrayList<Karyawan>();
        try {
            em.getTransaction().begin();
            list = em.createQuery("SELECT k FROM Karyawan k").getResultList();
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
        return list;
    }

    public Karyawan get(long id) throws Exception {
        Karyawan k = null;
        try {
            em.getTransaction().begin();
            k = em.find(Karyawan.class, id);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
        return k;
    }

    // New
    public List<Karyawan> getStatusKerja(String kerja) throws Exception {
        List<Karyawan> list = new ArrayList<Karyawan>();
        try {
            em.getTransaction().begin();
            list = em.createQuery("SELECT k FROM Karyawan k WHERE k.statuskerja='" + kerja + "'").getResultList();
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
        return list;
    }

    public void updateSisaCuti(Long id, String cuti) throws Exception {
        try {
            em.getTransaction().begin();
            em.createQuery("UPDATE Karyawan k SET k.sisacuti = :scuti WHERE k.id = :id").setParameter("scuti", cuti).setParameter("id", id).executeUpdate();
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void updateNotifikasi(Long id, String notif) throws Exception {
        try {
            em.getTransaction().begin();
            em.createQuery("UPDATE Karyawan k SET k.notifikasi = :notif WHERE k.id = :id").setParameter("notif", notif).setParameter("id", id).executeUpdate();
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    // News
    public boolean updateNotifikasi(String usr, String notif) throws Exception{
       boolean update=false;
        try {
            em.getTransaction().begin();
            Query q=em.createQuery("UPDATE Karyawan k SET k.notifikasi= :notif WHERE k.id= :user").setParameter("user", Long.parseLong(usr)).setParameter("notif", notif);
            q.executeUpdate();
            em.getTransaction().commit();
            update=true;
            
        } catch (Exception ex) {
            
        }
        return update;
    }
    
    
}

