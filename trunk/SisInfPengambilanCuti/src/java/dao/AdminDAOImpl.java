/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.TblAdmin;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author and2erlangga
 */
public class AdminDAOImpl extends GeneralDAOImpl implements AdminDAO {

    public AdminDAOImpl(EntityManager em) {
        super(em);
    }

    public boolean loginAdmin(TblAdmin tAdmin) throws Exception {
        boolean login = false;
        try {
            em.getTransaction().begin();
            List resultList = em.createQuery("SELECT a FROM TblAdmin a WHERE a.username='" 
                    + tAdmin.getUsername() + "' AND a.password='" + tAdmin.getPassword() + "'").getResultList();
            em.getTransaction().commit();
            if(!resultList.isEmpty()){
                login = true;
            }       
        } catch (Exception ex) {
            throw ex;
        }
        return login;
    }

    public List<TblAdmin> gets() throws Exception {
        List<TblAdmin> list = new ArrayList<TblAdmin>();
        try {
            em.getTransaction().begin();
            list = em.createQuery("SELECT a FROM TblAdmin a").getResultList();
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        }
        return list;
    }
}