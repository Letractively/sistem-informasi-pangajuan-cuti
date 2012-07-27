/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entity.Karyawan;
import entity.LoginKaryawan;
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

    public List<LoginKaryawan> gets() throws Exception {
        List<LoginKaryawan> list = new ArrayList<LoginKaryawan>();
        try {
            em.getTransaction().begin();
            list = em.createQuery("SELECT a FROM LoginKaryawan a").getResultList();
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
        return list;
    }

    public boolean loginKaryawan(LoginKaryawan lk) throws Exception {
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
