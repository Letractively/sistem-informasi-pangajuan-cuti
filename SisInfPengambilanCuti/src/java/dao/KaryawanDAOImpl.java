/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entity.Karyawan;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

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

  

}
