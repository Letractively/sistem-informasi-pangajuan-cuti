/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entity.Karyawan;
import entity.Loginkaryawan;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Wirawan
 */
public class LoginKaryawanDAOImpl extends GeneralDAOImpl implements LoginKaryawanDAO{

    public LoginKaryawanDAOImpl(EntityManager em) {
        super(em);
    }

    public List<Loginkaryawan> gets() throws Exception {
        List<Loginkaryawan> list = new ArrayList<Loginkaryawan>();
        try {
            em.getTransaction().begin();
            list = em.createQuery("SELECT a FROM Loginkaryawan a").getResultList();
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
        return list;
    }

    public boolean loginKaryawan(Loginkaryawan lk) throws Exception {
        boolean login = false;
        try {
            em.getTransaction().begin();
            List resultList = em.createQuery("SELECT k FROM Karyawan k WHERE k.username='"
                    + lk.getUsername() + "' AND k.password='" + lk.getPassword() + "'").getResultList();
            em.getTransaction().commit();
            if(!resultList.isEmpty()){
                login = true;
            }
        } catch (Exception ex) {
            throw ex;
        }
        return login;
    }

}
